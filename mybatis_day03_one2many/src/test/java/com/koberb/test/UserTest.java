package com.koberb.test;

import com.koberb.dao.IUserDao;
import com.koberb.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void Init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        session = factory.openSession(true);

        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception{

        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<User> users = userDao.findAll();

        for (User u :
                users) {
            System.out.println(u);
            System.out.println(u.getBills().toString());
        }
    }
}
