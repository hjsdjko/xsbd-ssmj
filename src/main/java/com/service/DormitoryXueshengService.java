package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DormitoryXueshengEntity;
import java.util.Map;

/**
 * 宿舍与学生一对多关系表 服务类
 * @author 
 * @since 2021-01-30
 */
public interface DormitoryXueshengService extends IService<DormitoryXueshengEntity> {

     PageUtils queryPage(Map<String, Object> params);

}