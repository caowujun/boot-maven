package com.example.bootmaven.dao;

import com.example.bootmaven.entity.Noticeboard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统公告 Mapper 接口
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Mapper
public interface NoticeboardDao extends BaseMapper<Noticeboard> {

}
