package com.example.bootmaven.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bootmaven.entity.Rolemenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色-菜单对应表 Mapper 接口
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface RolemenuDao extends BaseMapper<Rolemenu> {

}
