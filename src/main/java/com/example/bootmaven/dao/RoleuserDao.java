package com.example.bootmaven.dao;

import com.example.bootmaven.entity.Roleuser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色-用户对应表 Mapper 接口
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface RoleuserDao extends BaseMapper<Roleuser> {

}
