package com.example.bootmaven.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bootmaven.dao.MoneyDao;
import com.example.bootmaven.entity.Money;
import com.example.bootmaven.service.IMoneyService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消费 服务实现类
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@Service
public class MoneyServiceImpl extends ServiceImpl<MoneyDao, Money> implements IMoneyService {

}
