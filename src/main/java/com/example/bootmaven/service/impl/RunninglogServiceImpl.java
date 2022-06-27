package com.example.bootmaven.service.impl;

import com.example.bootmaven.entity.Runninglog;
import com.example.bootmaven.dao.RunninglogDao;
import com.example.bootmaven.service.IRunninglogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 执行日志 服务实现类
 * </p>
 *
 * @author robin
 * @since 2022-06-27
 */
@Service
public class RunninglogServiceImpl extends ServiceImpl<RunninglogDao, Runninglog> implements IRunninglogService {

}
