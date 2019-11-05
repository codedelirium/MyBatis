package com.koberb.dao;

import com.koberb.pojo.QueryVo;
import com.koberb.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

    void add(User user);

    void del(Integer uid);

    void alt(User user);

    List<User> findByName(String name);

    List<User> findByVo(QueryVo vo);

    List<User> findByIf(User user);

    List<User> findByIds(QueryVo vo);

}