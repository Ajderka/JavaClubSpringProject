package com.group4.dao;

import com.group4.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;

public interface RoleDAO {
    void create(Role role);

    void update(Role role);

    List<Role> findAll();

    Role findOne();

    void deleteAll();

    void deleteById();
}
