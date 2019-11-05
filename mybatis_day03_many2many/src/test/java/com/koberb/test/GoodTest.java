package com.koberb.test;

import com.koberb.dao.IGoodDao;
import com.koberb.pojo.Good;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class GoodTest {
    private InputStream in;
    private SqlSession session;
    private IGoodDao goodDao;

    @Before
    public void Init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        session = factory.openSession(true);

        goodDao = session.getMapper(IGoodDao.class);
    }

    @After
    public void destroy() throws Exception{

        session.close();
        in.close();
    }

    @Test
    public void find(){
        List<Good> goods = goodDao.findAll();
        for (Good g :
                goods) {
            System.out.println(g);
            System.out.println(g.getBills());
        }
    }
}
