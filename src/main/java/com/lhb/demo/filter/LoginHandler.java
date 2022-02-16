package com.lhb.demo.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lhb
 * @date 2021/2/16 9:34
 */
public class LoginHandler implements HandlerInterceptor {
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        Object user = request.getSession().getAttribute("user");
        if (user == null)  {
            response.sendRedirect("/toLogin");
            return false;
        }
        return true;
    }

}
