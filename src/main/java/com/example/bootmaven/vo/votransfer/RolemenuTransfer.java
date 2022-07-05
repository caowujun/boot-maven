package com.example.bootmaven.vo.votransfer;

import org.mapstruct.Mapper;
import com.example.bootmaven.vo.RolemenuVO;
import com.example.bootmaven.entity.Rolemenu;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * 角色-菜单对应表
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper(componentModel = "spring")
public interface RolemenuTransfer {


    @Mappings({
            @Mapping(source = "createat", target = "createat", qualifiedByName = "parseString"),
            @Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseString")})
    RolemenuVO d2v(Rolemenu d);

    @Mappings({
            @Mapping(source = "createat", target = "createat", qualifiedByName = "parseDate"),
            @Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseDate")})
    Rolemenu v2d(RolemenuVO v);

    /*
     * @author robin
     * @description 集合转集合
     * @date 2022/6/29 8:09
     * @param list
     */
    List<Rolemenu> vList2dList(List<RolemenuVO> list);

    /*
     * @author robin
     * @description List集合转List集合
     * @date 2022/6/29 8:09
     * @param list
     */
    List<RolemenuVO> dList2vList(List<Rolemenu> list);

    /*
     * @author robin
     * @description IPage集合转IPage集合
     * @date 2022/6/29 8:09
     * @param list
     */
    Page<RolemenuVO> dPage2vPage(Page<Rolemenu> page);

    /*
     * @author robin
     * @description IPage集合转IPage集合
     * @date 2022/6/29 8:09
     * @param list
     */
    Page<Rolemenu> vPage2dPage(Page<RolemenuVO> page);

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
