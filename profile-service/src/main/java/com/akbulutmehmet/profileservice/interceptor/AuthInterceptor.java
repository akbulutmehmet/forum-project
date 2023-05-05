package com.akbulutmehmet.profileservice.interceptor;

import com.akbulutmehmet.profileservice.dto.request.TokenRequest;
import com.akbulutmehmet.profileservice.exception.AuthorizationException;
import com.akbulutmehmet.profileservice.manager.IAuthManager;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    private final IAuthManager authManager;

    public AuthInterceptor(IAuthManager authManager) {
        this.authManager = authManager;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null || token.equals("")) {
            throw  new AuthorizationException("UnAuthorization request ");
        }
        token = token.substring(7);
        Boolean tokenControl = authManager.tokenControl(new TokenRequest(token));
        if(!tokenControl) {
            throw  new AuthorizationException("UnAuthorization request");
        }
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }
}
