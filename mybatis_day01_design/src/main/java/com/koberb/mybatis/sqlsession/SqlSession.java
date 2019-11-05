package com.koberb.mybatis.sqlsession;

/**
 * 自定义Mybatis中和数据库交互的核心类
 */
public interface SqlSession {

    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao的接口字节码
     *
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);//泛型变量：先声明后使用，声明在返回值之前

    /**
     * 释放资源
     */
    void close();
}
