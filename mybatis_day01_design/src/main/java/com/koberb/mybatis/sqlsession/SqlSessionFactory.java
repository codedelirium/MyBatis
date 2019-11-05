package com.koberb.mybatis.sqlsession;

public interface SqlSessionFactory {
    /**
     * 用于打开SqlSession对象
     * @return
     */
    SqlSession openSession();
}
