package com.weteam.musicplayapi.service;

import com.weteam.musicplayapi.entity.Result;
import com.weteam.musicplayapi.entity.User;

public interface UserService {

    Result findByEmailAndPwd(String email, String password);
}
