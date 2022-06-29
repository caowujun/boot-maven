package com.example.bootmaven.service.impl;

import com.example.bootmaven.entity.Fire;
import com.example.bootmaven.dao.FireDao;
import com.example.bootmaven.service.IFireService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 运动记录 服务实现类
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Service
public class FireServiceImpl extends ServiceImpl<FireDao, Fire> implements IFireService {

}
