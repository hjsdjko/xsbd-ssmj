package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PayEntity;
import java.util.Map;

/**
 * 缴费信息表 服务类
 * @author 
 * @since 2021-01-30
 */
public interface PayService extends IService<PayEntity> {

     PageUtils queryPage(Map<String, Object> params);

}