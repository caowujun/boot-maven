package com.example.bootmaven.config.interceptor;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.log.StaticLog;
import com.example.bootmaven.config.GlobalValue;
import com.example.bootmaven.response.R;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

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
     * 调用时间：Controller方法处理之前,执行顺序：链式Intercepter情况下，Intercepter按照声明的顺序一个接一个执行,若返回false，则中断执行，注意：不会进入afterCompletion
     * @date 2022/6/30 13:46
     * @param request
     * @param response
     * @param handler
     * @return boolean
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");

        boolean result = StringUtils.hasLength(token) && JWTUtil.verify(token, GlobalValue.TOKEN_SECRET) && JWTUtil.parseToken(token).validate(0);
        if (result) {
            return true;
        } else {
            // response.setCharacterEncoding("utf-8");//返回？？？使用这一行可以解决,或者用下面这行
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(R.failed("没有权限"));
            StaticLog.info("您没有权限，拒绝访问!.", "WARN");
            return false;
        }
    }

    /*
    调用前提：preHandle返回true
    调用时间：Controller方法处理完之后，DispatcherServlet进行视图的渲染之前，也就是说在这个方法中你可以对ModelAndView进行操作
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /*
    调用前提：preHandle返回true
    调用时间：DispatcherServlet进行视图的渲染之后
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
