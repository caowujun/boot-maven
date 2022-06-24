package com.example.bootmaven.AutoGenerateCode;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.bootmaven.controller.BaseController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author robin
 * @date 2022年06月21日 11:15
 */
public class MybatisPlusCodeAutoGenerator {

    public  static   void main(String[] args)
    {
        String projectPath =System.getProperty("user.dir");//D:\workstation\boot-maven
          FastAutoGenerator.create("jdbc:mysql://192.168.109.128:3306/robin?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8&useSSL=false",
                "root", "Win2003@")
                .globalConfig(builder -> {
                    builder.author("robin") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath+"/generator"); // 指定输出目录
                })
                .templateConfig(builder->{

                    builder.controller( "/templates/controller.java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.bootmaven") // 设置父包名
                            .mapper("dao")
                            .other("dto")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath+"/generator/resources/xml")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.enableSkipView()
                            .addInclude("money")
//                            .addInclude("customconfig,enumtypes,menu,money,noticeboard,role,rolemenu,roleuser,runninglog,sport,sysuser")
                            .entityBuilder()
                            .enableTableFieldAnnotation()//开启生成实体时生成字段注解
                            .naming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策略
                            .enableLombok()//开启 lombok 模型
                            .controllerBuilder()
                            .superClass(BaseController.class)//设置父类
                            .enableRestStyle()//开启生成@RestController 控制器
                            .mapperBuilder()
                            .superClass(BaseMapper.class)//设置父类
                            .enableMapperAnnotation()//开启 @Mapper 注解
                            .enableBaseResultMap()//启用 BaseResultMap 生成
                            .enableBaseColumnList()//启用 BaseColumnList
                            .formatMapperFileName("%sDao")//转换 mapper 类文件名称
                            .formatXmlFileName("%sXml"); // 转换 xml 文件名称

                })
                 .injectionConfig(consumer -> {
                     Map<String, String> customFile = new HashMap<>();
                     // DTO，.vm为velocity引擎的，.ftl为freemarker
                     customFile.put("DTO.java","/templates/entityDTO.java.ftl");
                     consumer.customFile(customFile);
                 })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
