package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.DormitoryDao;
import com.entity.DormitoryEntity;
import com.service.DormitoryService;
import com.entity.view.DormitoryView;

/**
 * 宿舍信息表 服务实现类
 * @author 
 * @since 2021-01-30
 */
@Service("dormitoryService")
@Transactional
public class DormitoryServiceImpl extends ServiceImpl<DormitoryDao, DormitoryEntity> implements DormitoryService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<DormitoryView> page =new Query<DormitoryView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
