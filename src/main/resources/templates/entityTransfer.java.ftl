package com.example.bootmaven.vo.votransfer;

import org.mapstruct.Mapper;
import com.example.bootmaven.vo.${entity}VO;
import ${package.Entity}.${entity};
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.core.convert.converter.Converter;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.bootmaven.config.MapStructConvertor;
import java.util.List;

/**
* <p>
    * ${table.comment!}
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Mapper
public interface ${entity}Transfer
{
${entity}Transfer INSTANCE = Mappers.getMapper(${entity}Transfer.class);

@Mappings({
@Mapping(source = "createat", target = "createat", qualifiedByName = "parseString"),
@Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseString")})
${entity}VO d2v(${entity} d);

@Mappings({
@Mapping(source = "createat", target = "createat", qualifiedByName = "parseDate"),
@Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseDate")})
${entity} v2d(${entity}VO v);

/*
* @author robin
* @description 集合转集合
* @date 2022/6/29 8:09
* @param list
*/
List<${entity}> vList2dList(List
<${entity}VO> list);
    /*
    * @author robin
    * @description List集合转List集合
    * @date 2022/6/29 8:09
    * @param list
    */
    List
    <${entity}VO> dList2vList(List<${entity}> list);
        /*
        * @author robin
        * @description IPage集合转IPage集合
        * @date 2022/6/29 8:09
        * @param list
        */
        IPage
        <${entity}VO> dPage2vPage(IPage<${entity}> page);
            /*
            * @author robin
            * @description IPage集合转IPage集合
            * @date 2022/6/29 8:09
            * @param list
            */
            IPage<${entity}> vPage2dPage(IPage
            <${entity}VO> page);


                }
