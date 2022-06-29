package com.example.bootmaven.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bootmaven.dao.SysuserDao;
import com.example.bootmaven.entity.Sysuser;
import com.example.bootmaven.service.ISysuserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Service
public class SysuserServiceImpl extends ServiceImpl<SysuserDao, Sysuser> implements ISysuserService {

}
