package com.example.bootmaven.dao;

import com.example.bootmaven.entity.Money;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 消费 Mapper 接口
 * </p>
 *
 * @author robin
 * @since 2022-06-24
 */
@Mapper
public interface MoneyDao extends BaseMapper<Money> {

}
