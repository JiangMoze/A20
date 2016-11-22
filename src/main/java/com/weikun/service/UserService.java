package com.weikun.service;

import com.weikun.model.User;
import com.weikun.model.UserExample;
import org.apache.ibatis.session.*;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/22.
 */
public class UserService {
    private SqlSessionFactory ssf=null;
    public UserService(){

        String path=UserService.class.getClassLoader().getResource("").getPath()+"mybatis.cfg.xml";
        try {
            ssf=new SqlSessionFactoryBuilder().build(new FileInputStream(new File(path)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print(path);

    }
    @Test
    public void update1(){
        SqlSession session=ssf.openSession();
        try {
            User user=new User();
            user.setId(1388);
            user.setUsername("黑龙江");
            user.setPassword("555");

            user.setBirth(new Date());

            session.update("updateByPrimaryKey",user);

            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    @Test
    public void queryByProc1(){
        SqlSession session=ssf.openSession();
        try {

            Map<String, Object> map=new HashMap<String, Object>();
            map.put("in_id", 1387);

            List<User> list=session.selectList("selectByProc1",map);

            for(User u :list){
                System.out.println(u.getUsername()+":"+u.getPassword());

            }

            System.out.print(map.get("out_result"));

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void queryByProc(){
        SqlSession session=ssf.openSession();
        try {
            User user=session.selectOne("selectByProc",1387);

            System.out.print(user.getUsername());

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    @Test
    public void query2(){
        SqlSession session=ssf.openSession();
        try {
            User user=session.selectOne("selectByPrimaryKey",1388);
            System.out.print(user.getUsername());

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    @Test
    public void query1(){
        SqlSession session=ssf.openSession();
        try {

            UserExample ue=new UserExample();
            ue.createCriteria().andUsernameLike("%wei%");
            List<User> list=session.selectList("selectByExample",ue);

            for(User u :list){
                System.out.println(u.getUsername()+":"+u.getPassword());

            }


        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    @Test
    public void update2(){
        SqlSession session=ssf.openSession();
        try {
            User user=new User();
            user.setId(1388);
            user.setUsername("黑龙江11");
            user.setPassword("555222");

            user.setBirth(new Date());

            UserExample ue=new UserExample();
            ue.createCriteria().andIdEqualTo(1388);
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("record", user);
            map.put("example", ue);


            session.update("updateByExampleSelective",map);

            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    @Test
    public void del(){
        SqlSession session=ssf.openSession();
        try {

            session.delete("deleteByPrimaryKey",1389);

            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    @Test
    public void add1(){
        SqlSession session=ssf.openSession();
        try {
            User user=new User();
            user.setUsername("哈尔滨");
            user.setPassword("999");

            user.setBirth(new Date());
            session.insert("insert",user);

            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    @Test
    public void add2(){
        SqlSession session=ssf.openSession();
        try {
            User user=new User();
            user.setUsername("哈尔滨22");
            user.setPassword("99922");

            session.insert("insertSelective",user);

            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    public static void main(String[] args) {
        new UserService();
    }



}
