package com.example.bootmaven.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * @author robin
 * @date 2022年06月29日 16:06
 * @description
 */
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {

    @Resource
    HandlerInterceptorAdapter handlerInterceptorAdapter;

    /*
     * @author robin
     * @description 加载拦截器
     * @date 2022/6/30 10:24
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptorAdapter)
                .addPathPatterns("/**")
                .excludePathPatterns("/sysuser/login.do",
                        "/swagger-resources/**",
                        "/v3/**",
                        "/swagger-ui/**"
                );
        super.addInterceptors(registry);
    }
/*
 * @author robin
 * @description 加载资源映射，Swagger3不加这个会报错
 * @date 2022/6/30 10:24
 * @param registry
 */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
