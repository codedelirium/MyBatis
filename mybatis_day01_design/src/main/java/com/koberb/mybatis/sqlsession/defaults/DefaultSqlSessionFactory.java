package com.koberb.mybatis.sqlsession.defaults;

import com.koberb.mybatis.cfg.Configuration;
import com.koberb.mybatis.sqlsession.SqlSession;
import com.koberb.mybatis.sqlsession.SqlSessionFactory;
/**
 * SqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }
    /**
     * 用于创建新的操作数据库对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
