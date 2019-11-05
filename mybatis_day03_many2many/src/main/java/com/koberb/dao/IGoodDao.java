package com.koberb.dao;

import com.koberb.pojo.Good;

import java.util.List;

public interface IGoodDao {
    List<Good> findAll();
}
