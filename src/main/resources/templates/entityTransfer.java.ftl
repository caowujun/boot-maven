package com.example.bootmaven.vo.votransfer;

import org.mapstruct.Mapper;
import com.example.bootmaven.vo.${entity}VO;
import ${package.Entity}.${entity};
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.mapstruct.Named;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
* <p>
* ${table.comment!}
* </p>
*
* @author ${author}
* @since ${date}
*/
@Mapper(componentModel="spring")
public interface ${entity}Transfer
{
<#--${entity}Transfer INSTANCE = Mappers.getMapper(${entity}Transfer.class);-->


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
List<${entity}> vList2dList(List<${entity}VO> list);
/*
* @author robin
* @description List集合转List集合
* @date 2022/6/29 8:09
* @param list
*/
List<${entity}VO> dList2vList(List<${entity}> list);
/*
* @author robin
* @description IPage集合转IPage集合
* @date 2022/6/29 8:09
* @param list
*/
Page<${entity}VO> dPage2vPage(Page<${entity}> page);
/*
* @author robin
* @description IPage集合转IPage集合
* @date 2022/6/29 8:09
* @param list
*/
Page<${entity}> vPage2dPage(Page<${entity}VO> page);

/*
* @author robin
* @description 不能单独定义成一行，比如 // DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
* @date 2022/6/28 15:38
* @param date
* @return java.lang.String
*/
@Named("parseString")
default String parseString(LocalDateTime date) {
try {
return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(date);
} catch (Exception ex) {
return null;
}
}

/*
* @author robin
* @description  不能单独定义成一行，比如 // DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
* @date 2022/6/28 15:38
* @param date
* @return java.time.LocalDateTime
*/
@Named("parseDate")
default LocalDateTime parseDate(String date) {
try {
return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
} catch (Exception ex) {
return null;
}
}
}
