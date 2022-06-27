package com.example.bootmaven.tools;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName JavaUtils
 * @Description TODO
 * @Author wujun.cao
 * @Date Created in 2021/03/18 14:40
 */
public class JsonUtils {

    //<T> T 表示返回值T的类型是泛型，T是一个占位符，用来告诉编译器，这个东西是先给我留着， 等我编译的时候再告诉你是什么类型。

    public static String ObjToJson(Object obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }

    public static <T> T JsonToObj(String jsonString, Class<T> tClass) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, tClass);
    }

}
