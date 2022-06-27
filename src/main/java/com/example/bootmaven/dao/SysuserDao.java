package com.example.bootmaven.dao;

import com.example.bootmaven.entity.Sysuser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author robin
 * @since 2022-06-27
 */
@Mapper
public interface SysuserDao extends BaseMapper<Sysuser> {

}
