package com.example.bootmaven.service.impl;

import com.example.bootmaven.entity.Customconfig;
import com.example.bootmaven.dao.CustomconfigDao;
import com.example.bootmaven.service.ICustomconfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 自定义配置 服务实现类
 * </p>
 *
 * @author robin
 * @since 2022-06-27
 */
@Service
public class CustomconfigServiceImpl extends ServiceImpl<CustomconfigDao, Customconfig> implements ICustomconfigService {

}
