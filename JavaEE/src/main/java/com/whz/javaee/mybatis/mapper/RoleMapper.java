package com.whz.javaee.mybatis.mapper;

import com.whz.javaee.mybatis.pojo.Role;

import java.util.List;

public interface RoleMapper {
    int insertRole(Role role);

    int updateRole(Role role);

    int deleteRole(Long id);

    Role getRole(Long id);

    List<Role> findRoles(String roleName);
}
