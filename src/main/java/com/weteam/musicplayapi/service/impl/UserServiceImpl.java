package com.weteam.musicplayapi.service.impl;

import com.weteam.musicplayapi.constant.Constants;
import com.weteam.musicplayapi.dao.UserDao;
import com.weteam.musicplayapi.dao.UserSessionDao;
import com.weteam.musicplayapi.entity.Result;
import com.weteam.musicplayapi.entity.User;
import com.weteam.musicplayapi.entity.UserSession;
import com.weteam.musicplayapi.service.UserService;
import com.weteam.musicplayapi.util.EncryptUtil;
import com.weteam.musicplayapi.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserSessionDao sessionDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Result findByEmailAndPwd(String email, String password) {

        Result result = new Result();
        try {
            String encryptPwd = EncryptUtil.md5(password);
            User user = userDao.findByEmailAndPwd(email, encryptPwd);
            Optional<User> optional = Optional.ofNullable(user);
            if(optional.isPresent()) {
                //session存盘
                UserSession session = new UserSession();
                session.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                session.setUserId(user.getId());
                session.setExpireTime(24*60*60);
                int num = sessionDao.saveUserSession(session);
                System.out.println("id："+session.getId());
                redisTemplate.opsForValue().set(session.getId()+"", session.getId(), TimeUnit.DAYS.toSeconds(1));
                result.setErrorCode(Constants.SUCCESS);
                result.setErrorMsg(Variables.SUCCESS_LOGIN);
            } else {
                result.setErrorCode(Constants.FAIL);
                result.setErrorCode(Variables.USER_PWD_NOT_TRUE);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        return result;
    }
}
