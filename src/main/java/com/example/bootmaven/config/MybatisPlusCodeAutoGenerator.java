package com.example.bootmaven.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.bootmaven.controller.BaseController;

import java.util.Collections;

/**
 * @author robin
 * @date 2022年06月21日 11:15
 */
public class MybatisPlusCodeAutoGenerator {

    public  static void main(String[] args)
    {

        FastAutoGenerator.create("jdbc:mysql://192.168.109.128:3306/robin?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8&useSSL=false",
                "root", "Win2003@")
                .globalConfig(builder -> {
                    builder.author("robin") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\workstation\\boot-maven\\src\\main\\generator"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.bootmaven") // 设置父包名
                             .mapper("dao")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\workstation\\boot-maven\\src\\main\\resources\\xml")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("menu")
                            .addInclude("sysuser")
                            .entityBuilder()
                            .enableTableFieldAnnotation()
                            .naming(NamingStrategy.underline_to_camel)
                            .enableLombok()
                            .controllerBuilder()
                            .superClass(BaseController.class)
                            .enableRestStyle()
                            .mapperBuilder()
                            .superClass(BaseMapper.class)
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .formatMapperFileName("%sDao")
                            .formatXmlFileName("%sXml"); // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
