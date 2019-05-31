package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Customer;
import com.example.demomybatis.entity.CustomerKey;

public interface CustomerMapper {
    int deleteByPrimaryKey(CustomerKey key);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(CustomerKey key);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}