package com.example.bootmaven.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bootmaven.dao.EnumtypesDao;
import com.example.bootmaven.entity.Enumtypes;
import com.example.bootmaven.service.IEnumtypesService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 枚举配置 服务实现类
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Service
public class EnumtypesServiceImpl extends ServiceImpl<EnumtypesDao, Enumtypes> implements IEnumtypesService {

}
