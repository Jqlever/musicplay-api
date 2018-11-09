package com.weteam.musicplayapi.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(value = "name") String name) {

        return "hello："+name;
    }
}
