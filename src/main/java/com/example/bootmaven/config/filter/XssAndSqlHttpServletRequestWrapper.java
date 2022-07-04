package com.example.bootmaven.config.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HtmlUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author robin
 * @date 2022年07月04日 9:57
 * @description
 */
public class XssAndSqlHttpServletRequestWrapper extends HttpServletRequestWrapper {

    HttpServletRequest httpServletRequest = null;

    private static final Set<String> notAllowedKeyWords = new HashSet<String>(0);
    static {
        String key = "and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+";
        String[] keyStr = key.split("\\|");
        notAllowedKeyWords.addAll(Arrays.asList(keyStr));
    }

    public XssAndSqlHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        httpServletRequest = request;
    }


    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (!StrUtil.hasEmpty())
            value = HtmlUtil.filter(value);
        return value;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (null != values) {
            for (int i = 0, l = values.length; i < l; i++) {
                values[i] = !StrUtil.hasEmpty(values[i]) ? HtmlUtil.filter(values[i]) : values[i];
            }
        }
        return values;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> parameters = super.getParameterMap();
        Map<String, String[]> map = new LinkedHashMap<>();
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                String[] values = parameters.get(key);
                for (int i = 0, l = values.length; i < l; i++) {
                    values[i] = !StrUtil.hasEmpty(values[i]) ? HtmlUtil.filter(values[i]) : values[i];
                }
                map.put(key, values);
            }
        }
        return map;
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (!StrUtil.hasEmpty())
            value = HtmlUtil.filter(value);
        return value;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }


    public static String stripXSSAndSql(String value) {
        if (value != null) {
// NOTE: It's highly recommended to use the ESAPI library and
// uncomment the following line to
// avoid encoded attacks.
// value = ESAPI.encoder().canonicalize(value);
// Avoid null characters
/** value = value.replaceAll("", ""); ***/
// Avoid anything between script tags
            Pattern scriptPattern = Pattern.compile(
                    "<[\r\n| | ]*script[\r\n| | ]*>(.*?)<!--[\r\n| | ]*script[\r\n| | ]*-->", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
// Avoid anything in a
// src="http://www.yihaomen.com/article/java/..." type of
// e-xpression
            scriptPattern = Pattern.compile("src[\r\n| | ]*=[\r\n| | ]*[\\\"|\\\'](.*?)[\\\"|\\\']",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
// Remove any lonesome tag
            scriptPattern = Pattern.compile("<!--[\r\n| | ]*script[\r\n| | ]*-->", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
// Remove any lonesome <script ...> tag
            scriptPattern = Pattern.compile("<[\r\n| | ]*script(.*?)>",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
// Avoid eval(...) expressions
            scriptPattern = Pattern.compile("eval\\((.*?)\\)",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
// Avoid e-xpression(...) expressions
            scriptPattern = Pattern.compile("e-xpression\\((.*?)\\)",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
// Avoid javascript:... expressions
            scriptPattern = Pattern.compile("javascript[\r\n| | ]*:[\r\n| | ]*", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
// Avoid vbscript:... expressions
            scriptPattern = Pattern.compile("vbscript[\r\n| | ]*:[\r\n| | ]*", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
// Avoid onload= expressions
            scriptPattern = Pattern.compile("onload(.*?)=",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
        }
        return value;
    }

    public boolean checkXSSAndSql(String value) {
        boolean flag = false;
        if (value != null) {
// NOTE: It's highly recommended to use the ESAPI library and
// uncomment the following line to
// avoid encoded attacks.
// value = ESAPI.encoder().canonicalize(value);
// Avoid null characters
/** value = value.replaceAll("", ""); ***/
// Avoid anything between script tags
            Pattern scriptPattern = Pattern.compile(
                    "<[\r\n| | ]*script[\r\n| | ]*>(.*?)</[\r\n| | ]*script[\r\n| | ]*>", Pattern.CASE_INSENSITIVE);
            flag = scriptPattern.matcher(value).find();
            if (flag) {
                return flag;
            }
// Avoid anything in a
// src="http://www.yihaomen.com/article/java/..." type of
// e-xpression
            scriptPattern = Pattern.compile("src[\r\n| | ]*=[\r\n| | ]*[\\\"|\\\'](.*?)[\\\"|\\\']",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            flag = scriptPattern.matcher(value).find();
            if (flag) {
                return flag;
            }
// Remove any lonesome </script> tag
            scriptPattern = Pattern.compile("<!--[\r\n| | ]*script[\r\n| | ]*-->", Pattern.CASE_INSENSITIVE);
            flag = scriptPattern.matcher(value).find();
            if (flag) {
                return flag;
            }
// Remove any lonesome <script ...> tag
            scriptPattern = Pattern.compile("<[\r\n| | ]*script(.*?)>",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            flag = scriptPattern.matcher(value).find();
            if (flag) {
                return flag;
            }
// Avoid eval(...) expressions
            scriptPattern = Pattern.compile("eval\\((.*?)\\)",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            flag = scriptPattern.matcher(value).find();
            if (flag) {
                return flag;
            }
// Avoid e-xpression(...) expressions
            scriptPattern = Pattern.compile("e-xpression\\((.*?)\\)",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            flag = scriptPattern.matcher(value).find();
            if (flag) {
                return flag;
            }
// Avoid javascript:... expressions
            scriptPattern = Pattern.compile("javascript[\r\n| | ]*:[\r\n| | ]*", Pattern.CASE_INSENSITIVE);
            flag = scriptPattern.matcher(value).find();
            if (flag) {
                return flag;
            }
// Avoid vbscript:... expressions
            scriptPattern = Pattern.compile("vbscript[\r\n| | ]*:[\r\n| | ]*", Pattern.CASE_INSENSITIVE);
            flag = scriptPattern.matcher(value).find();
            if (flag) {
                return flag;
            }
// Avoid onload= expressions
            scriptPattern = Pattern.compile("onload(.*?)=",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            flag = scriptPattern.matcher(value).find();
            if (flag) {
                return flag;
            }
            flag = checkSqlKeyWords(value);
        }
        return flag;
    }
    public boolean checkSqlKeyWords(String value) {
        for (String keyword : notAllowedKeyWords) {
            if (value.length() > keyword.length() + 4
                    && (value.contains(" " + keyword) || value.contains(keyword + " ") || value.contains(" " + keyword + " "))) {
//                log.error(this.getRequestURI() + "，参数异常，包含sql的关键词(" + keyword + ")");
                return true;
            }
        }
        return false;
    }
//    public boolean checkSqlKeyWords(String value) {
//        String paramValue = value;
//        for (String keyword : notAllowedKeyWords) {
//            if (paramValue.length() > keyword.length() + 4
//                    && (paramValue.contains(" " + keyword) || paramValue.contains(keyword + " ") || paramValue.contains(" " + keyword + " "))) {
////                log.error(this.getRequestURI() + "，参数异常，包含sql的关键词(" + keyword + ")");
//                return true;
//            }
//        }
//        return false;
//    }

    public final boolean checkParameter() {
        Map<String, String[]> submitParams = new HashMap(super.getParameterMap());
        Set<String> submitNames = submitParams.keySet();
        for (String submitName : submitNames) {
            Object submitValues = submitParams.get(submitName);
            if ((submitValues != null)) {
                for (String submitValue : (String[]) submitValues) {
                    if (checkXSSAndSql(submitValue)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
     * @author robin
     * @description
     * @date 2022/7/4 11:19
     * @return java.io.BufferedReader
     */
    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }


    @Override
    public ServletInputStream getInputStream() throws IOException {
        InputStream in = super.getInputStream();
        StringBuilder body = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
        BufferedReader buffer = new BufferedReader(reader);
        String line = buffer.readLine();
        while (line != null) {
            body.append(line);
            line = buffer.readLine();
        }
        buffer.close();
        reader.close();
        in.close();
        Map<String, Object> map = JSONUtil.parseObj(body.toString());
        Map<String, Object> resultMap = new HashMap<String, Object>(map.size());
        for (String key : map.keySet()) {
            Object val = map.get(key);
            if (map.get(key) instanceof String) {
                resultMap.put(key, HtmlUtil.filter(val.toString()));
            } else {
                resultMap.put(key, val);
            }
        }
        String str = JSONUtil.toJsonStr(resultMap);
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {
            }
        };
    }

}
