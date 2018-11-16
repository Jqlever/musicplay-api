package com.weteam.musicplayapi.interceptor;

import com.weteam.musicplayapi.dao.UserSessionDao;
import com.weteam.musicplayapi.entity.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserSessionDao sessionDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String sessionId = request.getParameter("sessionId");

        String session = (String) redisTemplate.opsForValue().get(sessionId);
        if(session != null) {
            return true;
        } else {
            UserSession userSession = sessionDao.findBySessionId(sessionId);
            if(userSession != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
