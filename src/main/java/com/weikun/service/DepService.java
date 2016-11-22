package com.weikun.service;

import com.weikun.model.Dep;
import com.weikun.model.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Administrator on 2016/11/22.
 */
public class DepService {
    private SqlSessionFactory ssf=null;
    public DepService(){

        String path=UserService.class.getClassLoader().getResource("").getPath()+"mybatis.cfg.xml";
        try {
            ssf=new SqlSessionFactoryBuilder().build(new FileInputStream(new File(path)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print(path);

    }



    @Test
    public void queryDepByEmployeeId(){

        SqlSession session=ssf.openSession();

        Employee emp=session.selectOne("selectDepByEmployee",2);

        System.out.print(emp.getName());
        List list=(List)emp.getDep();
        System.out.print(((Dep)list.get(0)).getDeptname());
        session.close();
    }
    @Test
    public void queryEmployeesByNo(){

        SqlSession session=ssf.openSession();

        Dep dep=session.selectOne("findDepEmployeesById",42);

        List<Employee> list=( List<Employee>) dep.getList();


        System.out.println(dep.getDeptname());

        for(Employee e :list){
            System.out.print(e.getName());
        }
        session.close();
    }

}
