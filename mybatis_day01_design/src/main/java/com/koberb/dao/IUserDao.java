package com.koberb.dao;

import com.koberb.mybatis.annotations.Select;
import com.koberb.pojo.User;

import java.util.List;

public interface IUserDao {
    @Select("select * from tb_user")
    List<User> findAll();
}
