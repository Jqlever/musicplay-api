package com.weteam.musicplayapi.web;

import com.weteam.musicplayapi.entity.Result;
import com.weteam.musicplayapi.entity.User;
import com.weteam.musicplayapi.service.UserService;
import com.weteam.musicplayapi.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public Result findByEmailAndPwd(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {

        return userService.findByEmailAndPwd(email, password);
    }

}
