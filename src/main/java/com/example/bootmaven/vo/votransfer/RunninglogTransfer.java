package com.example.bootmaven.vo.votransfer;

import org.mapstruct.Mapper;
import com.example.bootmaven.vo.RunninglogVO;
import com.example.bootmaven.entity.Runninglog; 
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.core.convert.converter.Converter;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.bootmaven.config.MapStructConvertor;
import java.util.List;

/**
 * <p>
 * 执行日志
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface RunninglogTransfer
{
RunninglogTransfer INSTANCE = Mappers.getMapper(RunninglogTransfer.class);

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
IPage<RunninglogVO> dPage2vPage(IPage<Runninglog> page);
   /*
   * @author robin
   * @description IPage集合转IPage集合
   * @date 2022/6/29 8:09
   * @param list
   */
IPage<Runninglog> vPage2dPage(IPage<RunninglogVO> page);


}
