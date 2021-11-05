package com.phuongnt.service;

import com.phuongnt.dao.UserDao;
import com.phuongnt.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public User read(Serializable id) {
        return userDao.read(id);
    }
}
