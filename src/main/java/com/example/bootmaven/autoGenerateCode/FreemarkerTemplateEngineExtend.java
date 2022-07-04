package com.example.bootmaven.autoGenerateCode;

import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.Map;

/**
 * @author robin
 * @date 2022年06月27日 13:28
 * @description
 */
public class FreemarkerTemplateEngineExtend extends FreemarkerTemplateEngine {


    /*
     * @author robin
     * @description mybatis-plus自动生成自定义模板class，支持多个，下面就是有vo和 vo转换类
     * @date 2022/6/29 8:09
     * @param customFile
     * @param tableInfo
     * @param objectMap
     */
    @Override
    protected void outputCustomFile(Map<String, String> customFile, TableInfo tableInfo, Map<String, Object> objectMap) {
//        super.outputCustomFile(customFile, tableInfo, objectMap);
        String entityName = tableInfo.getEntityName();
        String otherPath = this.getPathInfo(OutputFile.other);

        customFile.forEach((key, value) -> {
            String fileName;
            if (key.contains("VO")) {
                fileName = String.format(otherPath + File.separator + "%sVO.java", entityName);
            } else {
                fileName = String.format(otherPath + File.separator + "votransfer" + File.separator + "%sTransfer.java", entityName);
            }
            this.outputFile(new File(fileName), objectMap, value);
        });
    }

    /*
     * @author robin
     * @description 重写write方法这种方式适用于定义需要处理plus自带数据才能得到的数据。比如依赖注入的对象名首字母小写，这种在配置map时是无法处理的，因为plus的默认数据都还没有
     * @date 2022/7/4 8:40
     * @param objectMap
     * @param templatePath
     * @param outputFile
     */
    @Override
    public void writer(Map<String, Object> objectMap, String templatePath, File outputFile) throws Exception {
//        TableInfo tableInfo= (TableInfo)objectMap.get("table");

        super.writer(objectMap, templatePath, outputFile);
    }
}
