package com.example.bootmaven.vo.votransfer;

import org.mapstruct.Mapper;
import com.example.bootmaven.vo.RoleuserVO;
import com.example.bootmaven.entity.Roleuser; 
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.core.convert.converter.Converter;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.bootmaven.config.MapStructConvertor;
import java.util.List;

/**
 * <p>
 * 角色-用户对应表
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface RoleuserTransfer
{
RoleuserTransfer INSTANCE = Mappers.getMapper(RoleuserTransfer.class);

@Mappings({
@Mapping(source = "createat", target = "createat", qualifiedByName = "parseString"),
@Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseString")})
RoleuserVO d2v(Roleuser d);

@Mappings({
@Mapping(source = "createat", target = "createat", qualifiedByName = "parseDate"),
@Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseDate")})
Roleuser v2d(RoleuserVO v);

/*
* @author robin
* @description 集合转集合
* @date 2022/6/29 8:09
* @param list
*/
List<Roleuser> vList2dList(List<RoleuserVO> list);
 /*
 * @author robin
 * @description List集合转List集合
 * @date 2022/6/29 8:09
 * @param list
 */
List<RoleuserVO> dList2vList(List<Roleuser> list);
  /*
  * @author robin
  * @description IPage集合转IPage集合
  * @date 2022/6/29 8:09
  * @param list
  */
IPage<RoleuserVO> dPage2vPage(IPage<Roleuser> page);
   /*
   * @author robin
   * @description IPage集合转IPage集合
   * @date 2022/6/29 8:09
   * @param list
   */
IPage<Roleuser> vPage2dPage(IPage<RoleuserVO> page);


}
