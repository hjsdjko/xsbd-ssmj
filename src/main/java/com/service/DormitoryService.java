package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DormitoryEntity;
import java.util.Map;

/**
 * 宿舍信息表 服务类
 * @author 
 * @since 2021-01-30
 */
public interface DormitoryService extends IService<DormitoryEntity> {

     PageUtils queryPage(Map<String, Object> params);

}