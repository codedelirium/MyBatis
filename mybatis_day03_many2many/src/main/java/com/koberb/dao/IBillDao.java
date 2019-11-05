package com.koberb.dao;

import com.koberb.pojo.Bill;

import java.util.List;

public interface IBillDao {
    List<Bill> findAll();
}
