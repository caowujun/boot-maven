package com.example.bootmaven.dao;

import com.example.bootmaven.entity.Runninglog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 执行日志 Mapper 接口
 * </p>
 *
 * @author robin
 * @since 2022-06-27
 */
@Mapper
public interface RunninglogDao extends BaseMapper<Runninglog> {

}
