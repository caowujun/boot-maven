package com.example.bootmaven.vo.votransfer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.bootmaven.entity.Enumtypes;
import com.example.bootmaven.vo.EnumtypesVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 枚举配置
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface EnumtypesTransfer {
    EnumtypesTransfer INSTANCE = Mappers.getMapper(EnumtypesTransfer.class);

    @Mappings({
            @Mapping(source = "createat", target = "createat", qualifiedByName = "parseString"),
            @Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseString")})
    EnumtypesVO d2v(Enumtypes d);

    @Mappings({
            @Mapping(source = "createat", target = "createat", qualifiedByName = "parseDate"),
            @Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseDate")})
    Enumtypes v2d(EnumtypesVO v);

    /*
     * @author robin
     * @description 集合转集合
     * @date 2022/6/29 8:09
     * @param list
     */
    List<Enumtypes> vList2dList(List
                                        <EnumtypesVO> list);

    /*
     * @author robin
     * @description List集合转List集合
     * @date 2022/6/29 8:09
     * @param list
     */
    List
            <EnumtypesVO> dList2vList(List<Enumtypes> list);

    /*
     * @author robin
     * @description IPage集合转IPage集合
     * @date 2022/6/29 8:09
     * @param list
     */
    IPage
            <EnumtypesVO> dPage2vPage(IPage<Enumtypes> page);

    /*
     * @author robin
     * @description IPage集合转IPage集合
     * @date 2022/6/29 8:09
     * @param list
     */
    IPage<Enumtypes> vPage2dPage(IPage
                                         <EnumtypesVO> page);


}
