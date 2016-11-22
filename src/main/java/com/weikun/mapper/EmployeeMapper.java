package com.weikun.mapper;

import com.weikun.model.Employee;
import com.weikun.model.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface EmployeeMapper {
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