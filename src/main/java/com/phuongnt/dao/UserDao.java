package com.phuongnt.dao;

import com.phuongnt.entities.User;

import java.io.Serializable;

public interface UserDao {
    public Serializable create(User user);
    public User read(Serializable id);
}
