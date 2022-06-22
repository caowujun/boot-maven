package com.example.bootmaven.dao;

import com.example.bootmaven.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author robin
 * @since 2022-06-21
 */
@Mapper
public interface MenuDao extends BaseMapper<Menu> {

}
