package com.example.bootmaven.vo.votransfer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.bootmaven.entity.Noticeboard;
import com.example.bootmaven.vo.NoticeboardVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 系统公告
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface NoticeboardTransfer {
    NoticeboardTransfer INSTANCE = Mappers.getMapper(NoticeboardTransfer.class);

    @Mappings({
            @Mapping(source = "createat", target = "createat", qualifiedByName = "parseString"),
            @Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseString")})
    NoticeboardVO d2v(Noticeboard d);

    @Mappings({
            @Mapping(source = "createat", target = "createat", qualifiedByName = "parseDate"),
            @Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseDate")})
    Noticeboard v2d(NoticeboardVO v);

    /*
     * @author robin
     * @description 集合转集合
     * @date 2022/6/29 8:09
     * @param list
     */
    List<Noticeboard> vList2dList(List
                                          <NoticeboardVO> list);

    /*
     * @author robin
     * @description List集合转List集合
     * @date 2022/6/29 8:09
     * @param list
     */
    List
            <NoticeboardVO> dList2vList(List<Noticeboard> list);

    /*
     * @author robin
     * @description IPage集合转IPage集合
     * @date 2022/6/29 8:09
     * @param list
     */
    IPage
            <NoticeboardVO> dPage2vPage(IPage<Noticeboard> page);

    /*
     * @author robin
     * @description IPage集合转IPage集合
     * @date 2022/6/29 8:09
     * @param list
     */
    IPage<Noticeboard> vPage2dPage(IPage
                                           <NoticeboardVO> page);


}
