package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NoticeEntity;
import java.util.Map;

/**
 * 通知表 服务类
 * @author 
 * @since 2021-01-30
 */
public interface NoticeService extends IService<NoticeEntity> {

     PageUtils queryPage(Map<String, Object> params);

}