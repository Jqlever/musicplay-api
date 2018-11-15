package com.weteam.musicplayapi.service;

import com.weteam.musicplayapi.entity.User;

public interface UserService {

    User findByEmailAndPwd(String email, String password);
}
