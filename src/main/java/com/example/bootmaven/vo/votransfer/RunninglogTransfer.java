package com.example.bootmaven.vo.votransfer;

import org.mapstruct.Mapper;
import com.example.bootmaven.vo.RunninglogVO;
import com.example.bootmaven.entity.Runninglog;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * 执行日志
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper(componentModel = "spring")
public interface RunninglogTransfer {


    @Mappings({
            @Mapping(source = "createat", target = "createat", qualifiedByName = "parseString"),
            @Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseString")})
    RunninglogVO d2v(Runninglog d);

    @Mappings({
            @Mapping(source = "createat", target = "createat", qualifiedByName = "parseDate"),
            @Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseDate")})
    Runninglog v2d(RunninglogVO v);

    /*
     * @author robin
     * @description 集合转集合
     * @date 2022/6/29 8:09
     * @param list
     */
    List<Runninglog> vList2dList(List<RunninglogVO> list);

    /*
     * @author robin
     * @description List集合转List集合
     * @date 2022/6/29 8:09
     * @param list
     */
    List<RunninglogVO> dList2vList(List<Runninglog> list);

    /*
     * @author robin
     * @description IPage集合转IPage集合
     * @date 2022/6/29 8:09
     * @param list
     */
    Page<RunninglogVO> dPage2vPage(Page<Runninglog> page);

    /*
     * @author robin
     * @description IPage集合转IPage集合
     * @date 2022/6/29 8:09
     * @param list
     */
    Page<Runninglog> vPage2dPage(Page<RunninglogVO> page);

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
