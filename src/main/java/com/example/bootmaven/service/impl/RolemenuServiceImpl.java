package com.example.bootmaven.service.impl;

import com.example.bootmaven.entity.Rolemenu;
import com.example.bootmaven.dao.RolemenuDao;
import com.example.bootmaven.service.IRolemenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色-菜单对应表 服务实现类
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Service
public class RolemenuServiceImpl extends ServiceImpl<RolemenuDao, Rolemenu> implements IRolemenuService {

}
