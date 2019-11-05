package com.koberb.test;

import com.koberb.dao.IUserDao;
import com.koberb.pojo.QueryVo;
import com.koberb.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void Init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        session = factory.openSession();

        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception{

        //提交事务
        session.commit();

        session.close();
        in.close();
    }

    /**
     * 增
     */
    @Test
    public void add(){
        User u = new User();
        u.setName("bb");
        u.setMoney(12355);
        u.setPwd("newpwd");
        u.setType(0);

        System.out.println("before commit:"+u);
        userDao.add(u);
//        session.commit();
//        System.out.println("after commit:"+u);

    }

    /***
     * 删
     */
    @Test
    public void dele(){

        userDao.del(666);
    }

    /**
     * 改
     */
    @Test
    public void alt(){
        User u = new User();
        u.setId(666);
        u.setName("kk");
        userDao.alt(u);
    }

    /**
     * 模糊查询
     */
    @Test
    public void findByName(){
        List<User> list = userDao.findByName("%k%");
        for (User u:
                list) {
            System.out.println(u);
        }
    }
    /**
     * 查寻所有
     */
    @Test
    public void findAll(){
        List<User> list = userDao.findAll();
        for (User u:
                list) {
            System.out.println(u);
        }
    }


    @Test
    public void findByVo(){
        QueryVo queryVo = new QueryVo();
        User u = new User();
        u.setName("%张三%");//
        queryVo.setUser(u);
        List<User> list = userDao.findByVo(queryVo);
        for (User user:
                list) {
            System.out.println(user);
        }
    }
}
