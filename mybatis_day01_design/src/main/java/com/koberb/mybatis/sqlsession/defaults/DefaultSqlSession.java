package com.koberb.mybatis.sqlsession.defaults;

import com.koberb.mybatis.cfg.Configuration;
import com.koberb.mybatis.proxy.MapperProxy;
import com.koberb.mybatis.sqlsession.SqlSession;
import com.koberb.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;
    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }
    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     *
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));//类加载器，代理谁就实现相同的接口，如何代理
    }

    /**
     * 用于释放资源
     */
    public void close() {
        if(connection != null){
            try{
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
