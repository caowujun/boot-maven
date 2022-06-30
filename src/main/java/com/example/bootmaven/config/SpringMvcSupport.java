package com.example.bootmaven.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

/**
 * @author robin
 * @date 2022年06月29日 16:06
 * @description
 */
@Configuration
public class SpringMvcSupport implements WebMvcConfigurer {

    @Resource
    HandlerInterceptorAdapter handlerInterceptorAdapter;

    /*
     * @author robin
     * @description 加载拦截器
     * @date 2022/6/30 10:24
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludePatterns = new String[]{
                "/sysuser/login.do",
                "/swagger-resources/**",
                "/webjars/**",
//                "/v2/**",
                "/v3/**",
                "/swagger-ui/**",
                "/api",
//                "/api-docs",
//                "/api-docs/**",
                "/doc.html",
                "/doc.html/**"
        };
        registry.addInterceptor(handlerInterceptorAdapter)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePatterns);
    }

    //https://doc.xiaominfo.com/knife4j/faq/springboot-404.html,解决springboot无法访问新的皮肤问题。
    /*
     * @author robin
     * @description 加载资源映射，Swagger3不加这个会报错
     * @date 2022/6/30 10:24
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}
