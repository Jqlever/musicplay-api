package com.weteam.musicplayapi.config;

import com.weteam.musicplayapi.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        List<String> excludeList = new ArrayList<String>();
        excludeList.add("/user/login");

        registry.addInterceptor(new SessionInterceptor()).excludePathPatterns(excludeList);
    }
}
