package com.example.demomybatis.dao;

import com.example.demomybatis.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public SysUser findByUserName(String username);
}
