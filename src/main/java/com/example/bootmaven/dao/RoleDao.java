package com.example.bootmaven.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bootmaven.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface RoleDao extends BaseMapper<Role> {

}
