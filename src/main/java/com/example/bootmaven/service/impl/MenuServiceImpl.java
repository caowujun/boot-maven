package com.example.bootmaven.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bootmaven.dao.MenuDao;
import com.example.bootmaven.entity.Menu;
import com.example.bootmaven.service.IMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements IMenuService {

}
