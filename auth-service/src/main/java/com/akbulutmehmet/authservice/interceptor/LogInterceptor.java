package com.akbulutmehmet.authservice.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor {
    private final Logger logger =  LoggerFactory.getLogger(LogInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append(" Request url " + request.getRequestURL());
        sb.append(" Client ip "+request.getRemoteAddr());
        logger.info(sb.toString());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
