package com.example.bootmaven.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bootmaven.entity.Money;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 消费 Mapper 接口
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface MoneyDao extends BaseMapper<Money> {

}
