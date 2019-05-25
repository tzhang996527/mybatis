package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Permission;

import java.util.List;

public interface PermissionDao {
    public List<Permission> findAll();
    public List<Permission> findByAdminUserId(int userId);
}
