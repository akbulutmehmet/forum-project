package com.akbulutmehmet.webservice.interceptor;

import com.akbulutmehmet.webservice.dto.request.TokenRequest;
import com.akbulutmehmet.webservice.exception.AuthorizationException;
import com.akbulutmehmet.webservice.manager.IAuthManager;
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
            throw  new AuthorizationException("UnAuthorizaton ");
        }
        token = token.substring(7);
        Boolean tokenControl = authManager.tokenControl(new TokenRequest(token));
        if(!tokenControl) {
            throw  new AuthorizationException("UnAuthorizaton ");
        }
        return tokenControl;
    }
}
