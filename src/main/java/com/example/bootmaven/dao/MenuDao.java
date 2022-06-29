package com.example.bootmaven.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bootmaven.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜单 Mapper 接口
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface MenuDao extends BaseMapper<Menu> {

}
