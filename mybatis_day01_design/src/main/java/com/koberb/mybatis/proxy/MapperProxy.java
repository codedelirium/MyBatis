package com.koberb.mybatis.proxy;

import com.koberb.mybatis.cfg.Mapper;
import com.koberb.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;


public class MapperProxy implements InvocationHandler {
    //Map的key是全限定类名加方法名
    private Map<String, Mapper> mappers;//因为要用mapper里面的sql语句
    private Connection conn;//为了调用selectList方法

    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
        this.mappers = mappers;
        this.conn = conn;
    }
    /**
     * 用于对方法进行增强，其实就是调用selectlist方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //1.获取方法名
        String methodName = method.getName();
        //2.获取全限定类名
        String className = method.getDeclaringClass().getName();
        //3.合成key
        String key = className+"."+methodName;
        //4.获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        if(mapper == null){
            throw new IllegalArgumentException("传入的参数有问题");
        }
        //6.调用工具类，执行sql语句
        return new Executor().selectList(mapper,conn);
    }
}
