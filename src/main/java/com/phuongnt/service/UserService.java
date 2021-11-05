package com.phuongnt.service;

import com.phuongnt.entities.User;

import java.io.Serializable;

public interface UserService {

    public void create(User user);
    public User read(Serializable id);
}
