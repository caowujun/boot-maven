package com.example.bootmaven.vo.votransfer;

import org.mapstruct.Mapper;
import com.example.bootmaven.vo.RolemenuVO;
import com.example.bootmaven.entity.Rolemenu; 
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.core.convert.converter.Converter;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.bootmaven.config.MapStructConvertor;
import java.util.List;

/**
 * <p>
 * 角色-菜单对应表
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface RolemenuTransfer
{
RolemenuTransfer INSTANCE = Mappers.getMapper(RolemenuTransfer.class);

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
IPage<RolemenuVO> dPage2vPage(IPage<Rolemenu> page);
   /*
   * @author robin
   * @description IPage集合转IPage集合
   * @date 2022/6/29 8:09
   * @param list
   */
IPage<Rolemenu> vPage2dPage(IPage<RolemenuVO> page);


}
