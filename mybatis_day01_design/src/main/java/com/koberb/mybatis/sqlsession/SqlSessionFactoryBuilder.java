package com.koberb.mybatis.sqlsession;

import com.koberb.mybatis.cfg.Configuration;
import com.koberb.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.koberb.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 *  用于创建SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个
     * @param in
     * @return
     */
    public SqlSessionFactory build(InputStream in){

        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        DefaultSqlSessionFactory factory = new DefaultSqlSessionFactory(cfg);//因为需要把cfg中的数据库连接传过去

        return factory;
    }
}
