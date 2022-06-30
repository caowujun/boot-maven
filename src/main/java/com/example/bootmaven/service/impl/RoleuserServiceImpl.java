package com.example.bootmaven.service.impl;

import com.example.bootmaven.entity.Roleuser;
import com.example.bootmaven.dao.RoleuserDao;
import com.example.bootmaven.service.IRoleuserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色-用户对应表 服务实现类
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Service
public class RoleuserServiceImpl extends ServiceImpl<RoleuserDao, Roleuser> implements IRoleuserService {

}
