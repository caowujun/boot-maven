package com.example.bootmaven.config;

import cn.hutool.jwt.JWTUtil;
import com.alibaba.druid.wall.violation.ErrorCode;
import com.example.bootmaven.tools.JsonUtils;
import com.example.bootmaven.tools.response.R;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author robin
 * @date 2022年06月29日 16:09,https://blog.csdn.net/qq_23107097/article/details/120130490
 * @description
 */
@Configuration
public class HandlerInterceptorAdapter implements HandlerInterceptor {

/*
 * @author robin 
 * @description 拦截没有登录的请求，并在没权限的说话返回一个警告
 * @date 2022/6/30 13:46
 * @param request
 * @param response
 * @param handler 
 * @return boolean
 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        boolean result = StringUtils.hasLength(token) && JWTUtil.verify(token, GlobalValue.TOKEN_SECRET);
        if (result) {
            return true;
        } else {
            // response.setCharacterEncoding("utf-8");//返回？？？使用这一行可以解决,或者用下面这行
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(R.failed("没有权限"));
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
