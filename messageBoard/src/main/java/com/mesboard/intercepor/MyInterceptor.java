package com.mesboard.intercepor;

import com.mesboard.contants.Constants;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//拦截器定义
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {



        if (request.getContextPath().equals("/")||request.getContextPath().equals("/index") ||request.getContextPath().equals("/user/registry")){
            return true;
        }
        if (request.getSession().getAttribute(Constants.SESSION_USER)==null){
            response.sendRedirect(request.getContextPath()+"/");
        }
        return true;
    }
}
