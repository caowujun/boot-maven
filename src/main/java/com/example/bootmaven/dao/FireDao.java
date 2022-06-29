package com.example.bootmaven.dao;

import com.example.bootmaven.entity.Fire;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 运动记录 Mapper 接口
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface FireDao extends BaseMapper<Fire> {

}
