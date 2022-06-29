package com.example.bootmaven.vo.votransfer;

import org.mapstruct.Mapper;
import com.example.bootmaven.vo.RoleVO;
import com.example.bootmaven.entity.Role; 
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.core.convert.converter.Converter;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.bootmaven.config.MapStructConvertor;
import java.util.List;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface RoleTransfer
{
RoleTransfer INSTANCE = Mappers.getMapper(RoleTransfer.class);

@Mappings({
@Mapping(source = "createat", target = "createat", qualifiedByName = "parseString"),
@Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseString")})
RoleVO d2v(Role d);

@Mappings({
@Mapping(source = "createat", target = "createat", qualifiedByName = "parseDate"),
@Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseDate")})
Role v2d(RoleVO v);

/*
* @author robin
* @description 集合转集合
* @date 2022/6/29 8:09
* @param list
*/
List<Role> vList2dList(List<RoleVO> list);
 /*
 * @author robin
 * @description List集合转List集合
 * @date 2022/6/29 8:09
 * @param list
 */
List<RoleVO> dList2vList(List<Role> list);
  /*
  * @author robin
  * @description IPage集合转IPage集合
  * @date 2022/6/29 8:09
  * @param list
  */
IPage<RoleVO> dPage2vPage(IPage<Role> page);
   /*
   * @author robin
   * @description IPage集合转IPage集合
   * @date 2022/6/29 8:09
   * @param list
   */
IPage<Role> vPage2dPage(IPage<RoleVO> page);


}
