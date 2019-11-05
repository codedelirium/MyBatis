package com.koberb.dao;

import com.koberb.pojo.Bill;
import com.koberb.pojo.BillUser;

import java.util.List;

public interface IBillDao {
    List<Bill> findAll();

    List<BillUser> findAllBU();

}
