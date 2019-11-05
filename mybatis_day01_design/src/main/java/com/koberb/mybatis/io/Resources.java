package com.koberb.mybatis.io;

import java.io.InputStream;

/**
 * 用于读取配置文件
 */
public class Resources  {

    public static InputStream getResourceAsStream(String xmlPath){
        return Resources.class.getClassLoader().getResourceAsStream(xmlPath);
    }
}
