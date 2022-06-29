package com.example.bootmaven.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bootmaven.dao.NoticeboardDao;
import com.example.bootmaven.entity.Noticeboard;
import com.example.bootmaven.service.INoticeboardService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统公告 服务实现类
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Service
public class NoticeboardServiceImpl extends ServiceImpl<NoticeboardDao, Noticeboard> implements INoticeboardService {

}
