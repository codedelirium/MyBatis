package com.koberb.dao;

import com.koberb.pojo.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

}