package com.example.bootmaven.vo.votransfer;

import org.mapstruct.Mapper;
import com.example.bootmaven.vo.MoneyVO;
import com.example.bootmaven.entity.Money; 
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.core.convert.converter.Converter;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.bootmaven.config.MapStructConvertor;
import java.util.List;

/**
 * <p>
 * 消费
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface MoneyTransfer
{
MoneyTransfer INSTANCE = Mappers.getMapper(MoneyTransfer.class);

@Mappings({
@Mapping(source = "createat", target = "createat", qualifiedByName = "parseString"),
@Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseString")})
MoneyVO d2v(Money d);

@Mappings({
@Mapping(source = "createat", target = "createat", qualifiedByName = "parseDate"),
@Mapping(source = "updateat", target = "updateat", qualifiedByName = "parseDate")})
Money v2d(MoneyVO v);

/*
* @author robin
* @description 集合转集合
* @date 2022/6/29 8:09
* @param list
*/
List<Money> vList2dList(List<MoneyVO> list);
 /*
 * @author robin
 * @description List集合转List集合
 * @date 2022/6/29 8:09
 * @param list
 */
List<MoneyVO> dList2vList(List<Money> list);
  /*
  * @author robin
  * @description IPage集合转IPage集合
  * @date 2022/6/29 8:09
  * @param list
  */
IPage<MoneyVO> dPage2vPage(IPage<Money> page);
   /*
   * @author robin
   * @description IPage集合转IPage集合
   * @date 2022/6/29 8:09
   * @param list
   */
IPage<Money> vPage2dPage(IPage<MoneyVO> page);


}
