package com.koberb.test;

import com.koberb.dao.IBillDao;
import com.koberb.pojo.Bill;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class BillTest {
    private InputStream in;
    private SqlSession session;
    private IBillDao billDao;

    @Before
    public void Init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        session = factory.openSession(true);

        billDao = session.getMapper(IBillDao.class);
    }

    @After
    public void destroy() throws Exception{

        session.close();
        in.close();
    }

    @Test
    public void find(){
        List<Bill> bills = billDao.findAll();
        for (Bill b :
                bills) {
            System.out.println(b);
            System.out.println(b.getGoods());
        }
    }
}
