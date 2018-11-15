package com.weteam.musicplayapi.service.impl;

import com.weteam.musicplayapi.dao.UserDao;
import com.weteam.musicplayapi.entity.User;
import com.weteam.musicplayapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByEmailAndPwd(String email, String password) {

        return userDao.findByEmailAndPwd(email, password);
    }
}
