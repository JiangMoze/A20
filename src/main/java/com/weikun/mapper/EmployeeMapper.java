package com.weikun.mapper;

import com.weikun.model.Employee;
import com.weikun.model.EmployeeExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface EmployeeMapper {

    @Select({
            "SELECT * FROM employee where id=#{id}"
    })
    @Results({
            @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="deptno", property="deptno", jdbcType=JdbcType.INTEGER),
            @Result(column="sex", property="sex", jdbcType=JdbcType.CHAR),
            @Result(property="dep", column = "deptno",
                one=@One( select = "com.weikun.mapper.DepMapper.selectByPrimaryKey"))
    })
    Employee selectDepByEmployee(@Param("id") int id);//通过从表找到主表


    @Select({
            "SELECT * FROM employee where deptno=#{no}"
    })
    @Results({
            @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="deptno", property="deptno", jdbcType=JdbcType.INTEGER),
            @Result(column="sex", property="sex", jdbcType=JdbcType.CHAR)
    })
    List<Employee> selectEmployeesByNo(@Param("no") int no);//通过部门编号找到所有员工

    @SelectProvider(type=EmployeeSqlProvider.class, method="countByExample")
    long countByExample(EmployeeExample example);

    @DeleteProvider(type=EmployeeSqlProvider.class, method="deleteByExample")
    int deleteByExample(EmployeeExample example);

    @Delete({
        "delete from employee",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into employee (Id, name, ",
        "deptno, sex)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{deptno,jdbcType=INTEGER}, #{sex,jdbcType=CHAR})"
    })
    int insert(Employee record);

    @InsertProvider(type=EmployeeSqlProvider.class, method="insertSelective")
    int insertSelective(Employee record);

    @SelectProvider(type=EmployeeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="deptno", property="deptno", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.CHAR)
    })
    List<Employee> selectByExample(EmployeeExample example);

    @Select({
        "select",
        "Id, name, deptno, sex",
        "from employee",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="deptno", property="deptno", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.CHAR)
    })
    Employee selectByPrimaryKey(Integer id);

    @UpdateProvider(type=EmployeeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    @UpdateProvider(type=EmployeeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    @UpdateProvider(type=EmployeeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Employee record);

    @Update({
        "update employee",
        "set name = #{name,jdbcType=VARCHAR},",
          "deptno = #{deptno,jdbcType=INTEGER},",
          "sex = #{sex,jdbcType=CHAR}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Employee record);
}