package com.example.bootmaven.vo.votransfer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.bootmaven.entity.Fire;
import com.example.bootmaven.vo.FireVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 运动记录
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface FireTransfer {
    FireTransfer INSTANCE = Mappers.getMapper(FireTransfer.class);

    @Mappings({
            @Mapping(source = "createat", target = "createat", qualifiedByName = "parseString"),
            @Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseString")})
    FireVO d2v(Fire d);

    @Mappings({
            @Mapping(source = "createat", target = "createat", qualifiedByName = "parseDate"),
            @Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseDate")})
    Fire v2d(FireVO v);

    /*
     * @author robin
     * @description 集合转集合
     * @date 2022/6/29 8:09
     * @param list
     */
    List<Fire> vList2dList(List
                                   <FireVO> list);

    /*
     * @author robin
     * @description List集合转List集合
     * @date 2022/6/29 8:09
     * @param list
     */
    List
            <FireVO> dList2vList(List<Fire> list);

    /*
     * @author robin
     * @description IPage集合转IPage集合
     * @date 2022/6/29 8:09
     * @param list
     */
    IPage
            <FireVO> dPage2vPage(IPage<Fire> page);

    /*
     * @author robin
     * @description IPage集合转IPage集合
     * @date 2022/6/29 8:09
     * @param list
     */
    IPage<Fire> vPage2dPage(IPage
                                    <FireVO> page);


}
