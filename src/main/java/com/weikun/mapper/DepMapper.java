package com.weikun.mapper;

import com.weikun.model.Dep;
import com.weikun.model.DepExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface DepMapper {




    //一对多演示

    @Select({
            "SELECT * FROM dep where deptno=#{no}"
    })
    @Results({
        @Result(id = true, column = "deptno", property = "deptno"),
        @Result(column = "deptname", property = "deptname"),
            @Result(property = "list",javaType = List.class, column = "deptno",
                    many = @Many(select="com.weikun.mapper.EmployeeMapper.selectEmployeesByNo"))

                    })
    Dep findDepEmployeesById(@Param("no") int no);


    @SelectProvider(type=DepSqlProvider.class, method="countByExample")
    long countByExample(DepExample example);

    @DeleteProvider(type=DepSqlProvider.class, method="deleteByExample")
    int deleteByExample(DepExample example);

    @Delete({
        "delete from dep",
        "where deptno = #{deptno,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer deptno);

    @Insert({
        "insert into dep (deptno, deptname)",
        "values (#{deptno,jdbcType=INTEGER}, #{deptname,jdbcType=VARCHAR})"
    })
    int insert(Dep record);

    @InsertProvider(type=DepSqlProvider.class, method="insertSelective")
    int insertSelective(Dep record);

    @SelectProvider(type=DepSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="deptno", property="deptno", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="deptname", property="deptname", jdbcType=JdbcType.VARCHAR)
    })
    List<Dep> selectByExample(DepExample example);

    @Select({
        "select",
        "deptno, deptname",
        "from dep",
        "where deptno = #{deptno,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="deptno", property="deptno", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="deptname", property="deptname", jdbcType=JdbcType.VARCHAR)
    })
    Dep selectByPrimaryKey(Integer deptno);

    @UpdateProvider(type=DepSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Dep record, @Param("example") DepExample example);

    @UpdateProvider(type=DepSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Dep record, @Param("example") DepExample example);

    @UpdateProvider(type=DepSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Dep record);

    @Update({
        "update dep",
        "set deptname = #{deptname,jdbcType=VARCHAR}",
        "where deptno = #{deptno,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Dep record);
}