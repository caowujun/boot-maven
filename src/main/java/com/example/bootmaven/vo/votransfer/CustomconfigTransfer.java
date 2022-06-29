package com.example.bootmaven.vo.votransfer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.bootmaven.entity.Customconfig;
import com.example.bootmaven.vo.CustomconfigVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 自定义配置
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface CustomconfigTransfer {
    CustomconfigTransfer INSTANCE = Mappers.getMapper(CustomconfigTransfer.class);

    @Mappings({
            @Mapping(source = "createat", target = "createat", qualifiedByName = "parseString"),
            @Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseString")})
    CustomconfigVO d2v(Customconfig d);

    @Mappings({
            @Mapping(source = "createat", target = "createat", qualifiedByName = "parseDate"),
            @Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseDate")})
    Customconfig v2d(CustomconfigVO v);

    /*
     * @author robin
     * @description 集合转集合
     * @date 2022/6/29 8:09
     * @param list
     */
    List<Customconfig> vList2dList(List
                                           <CustomconfigVO> list);

    /*
     * @author robin
     * @description List集合转List集合
     * @date 2022/6/29 8:09
     * @param list
     */
    List
            <CustomconfigVO> dList2vList(List<Customconfig> list);

    /*
     * @author robin
     * @description IPage集合转IPage集合
     * @date 2022/6/29 8:09
     * @param list
     */
    IPage
            <CustomconfigVO> dPage2vPage(IPage<Customconfig> page);

    /*
     * @author robin
     * @description IPage集合转IPage集合
     * @date 2022/6/29 8:09
     * @param list
     */
    IPage<Customconfig> vPage2dPage(IPage
                                            <CustomconfigVO> page);


}
