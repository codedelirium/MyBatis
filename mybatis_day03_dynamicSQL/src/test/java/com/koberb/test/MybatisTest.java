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
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void Init() throws Exception{
	//获取输入流对象
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
	//根据输入流对象创建工厂对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
	//通过工厂创建SqlSession对象
        session = factory.openSession(true);
	//通过session代理userDAO接口
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception{

        session.close();
        in.close();
    }

    /**
     * if标签查询
     */
    @Test
    public void findByIf(){
        User u = new User();
//        u.setPwd("123");
//        u.setType(0);
        u.setType(1);
        List<User> users = userDao.findByIf(u);
        for (User user:users) {
            System.out.println(user);
        }
    }

    /**
     * foreach标签查询
     */
    @Test
    public void findByIds(){
        QueryVo vo = new QueryVo();
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(667);

        vo.setIds(integers);
        List<User> users = userDao.findByIds(vo);
        for (User u: users
             ) {
            System.out.println(u);
        }

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

    /**
     * 不同元素模糊查询
     */
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
