package com.example.bootmaven.config.filter;


import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.StaticLog;
import cn.hutool.log.level.Level;
import com.example.bootmaven.config.GlobalValue;
import com.example.bootmaven.response.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author robin
 * @date 2022年07月04日 12:25
 * @description
 */

@WebFilter(urlPatterns = "/*", filterName = "xssAndSqlFilter", dispatcherTypes = DispatcherType.REQUEST)
@Component
public class XssAndSqlFilter implements Filter {
    //推荐创建不可变静态类成员变量
    private static final Log log = LogFactory.get();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.log(Level.INFO, "init");
    }

//    1. GET 传递, 参数可以直接通过request.getParameter获取。
//    2. Post 传递,产生不能过直接从request.getInputStream() 读取，必须要进行重新写。（request.getInputStream()只能够读取一次）
//    方式：通过重写 HttpServletRequestWrapper 类 获取getInputStream中的流数据，然后在将body数据进行重新写入传递下去。
    /*
     * @author robin
     * @description
     *
     * @date 2022/7/6 14:04
     * @param request
     * @param response
     * @param chain
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        ServletOutputStream outputStream = response.getOutputStream();
        String method = "GET";//设置初始值
        String param = "";
        XssAndSqlHttpServletRequestWrapper xssRequest = null;
        if (request instanceof HttpServletRequest) {//判断左边的对象是否是它右边对象的实例
            method = ((HttpServletRequest) request).getMethod();//得到请求URL地址时使用的方法
            xssRequest = new XssAndSqlHttpServletRequestWrapper((HttpServletRequest) request);//创建对象
        }
        assert xssRequest != null;
        if (xssRequest.checkParameter()) {
            throwError(outputStream, "");
        } else {
            chain.doFilter(xssRequest, response);
        }
//        if ("POST".equalsIgnoreCase(method)) {//判断是否为post
//            param = getBodyString(xssRequest.getReader());//获取参数
//            if (StringUtils.isNotBlank(param) && (xssRequest.checkXSSAndSql(param) || xssRequest.checkParameter())) {//等价于 str != null && str.length > 0 && str.trim().length > 0
//                throwError(outputStream, param);
//            } else
//                chain.doFilter(new XssAndSqlHttpServletRequestWrapper((HttpServletRequest) request), response);
//        } else if (method.equals("GET")) {
//            if (xssRequest.checkParameter())
//                throwError(outputStream, "");
//            else
//                chain.doFilter(xssRequest, response);
//        } else {
//            chain.doFilter(xssRequest, response);
//        }
    }


    public static void throwError(ServletOutputStream outputStream, String param) throws IOException {
        StaticLog.info("您所访问的页面请求中有违反安全规则元素存在，拒绝访问!.[]==" + param, "ERROR");
        outputStream.write("您所访问的页面请求中有违反安全规则元素存在，拒绝访问!.".getBytes());
        outputStream.flush();
    }

    // 获取request请求body中参数
    public static String getBodyString(BufferedReader br) {
        String inputLine;
        StringBuilder str = new StringBuilder();
        try {
            while ((inputLine = br.readLine()) != null) {
                str.append(inputLine);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return str.toString();
    }


    @Override
    public void destroy() {

    }
}
