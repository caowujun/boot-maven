package com.example.bootmaven.vo.votransfer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.bootmaven.entity.Sysuser;
import com.example.bootmaven.vo.SysuserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface SysuserTransfer {
    SysuserTransfer INSTANCE = Mappers.getMapper(SysuserTransfer.class);

    @Mappings({
            @Mapping(source = "createat", target = "createat", qualifiedByName = "parseString"),
            @Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseString")})
    SysuserVO d2v(Sysuser d);

    @Mappings({
            @Mapping(source = "createat", target = "createat", qualifiedByName = "parseDate"),
            @Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseDate")})
    Sysuser v2d(SysuserVO v);

    /*
     * @author robin
     * @description 集合转集合
     * @date 2022/6/29 8:09
     * @param list
     */
    List<Sysuser> vList2dList(List
                                      <SysuserVO> list);

    /*
     * @author robin
     * @description List集合转List集合
     * @date 2022/6/29 8:09
     * @param list
     */
    List
            <SysuserVO> dList2vList(List<Sysuser> list);

    /*
     * @author robin
     * @description IPage集合转IPage集合
     * @date 2022/6/29 8:09
     * @param list
     */
    IPage
            <SysuserVO> dPage2vPage(IPage<Sysuser> page);

    /*
     * @author robin
     * @description IPage集合转IPage集合
     * @date 2022/6/29 8:09
     * @param list
     */
    IPage<Sysuser> vPage2dPage(IPage
                                       <SysuserVO> page);


}
