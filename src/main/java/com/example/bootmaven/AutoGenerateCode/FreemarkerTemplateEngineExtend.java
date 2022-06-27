package com.example.bootmaven.AutoGenerateCode;

import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.Map;

/**
 * @author robin
 * @date 2022年06月27日 13:28
 * @description
 */
public class FreemarkerTemplateEngineExtend extends FreemarkerTemplateEngine {


    @Override
    protected void outputCustomFile(Map<String, String> customFile, TableInfo tableInfo, Map<String, Object> objectMap) {
//        super.outputCustomFile(customFile, tableInfo, objectMap);
        String entityName = tableInfo.getEntityName();
        String otherPath = this.getPathInfo(OutputFile.other);

        customFile.forEach((key, value) -> {
            String fileName = String.format(otherPath + File.separator   + File.separator + "%sDto.java", entityName);

//            String fileName = String.format(otherPath + File.separator + entityName + File.separator + "%s", key);
            this.outputFile(new File(fileName), objectMap, value);
        });
    }
}
