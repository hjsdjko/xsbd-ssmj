package com.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.DormitoryXueshengDao;
import com.entity.DormitoryXueshengEntity;
import com.service.DormitoryXueshengService;
import com.entity.view.DormitoryXueshengView;

/**
 * 宿舍与学生一对多关系表 服务实现类
 * @author 
 * @since 2021-01-30
 */
@Service("dormitoryXueshengService")
@Transactional
public class DormitoryXueshengServiceImpl extends ServiceImpl<DormitoryXueshengDao, DormitoryXueshengEntity> implements DormitoryXueshengService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<DormitoryXueshengView> page =new Query<DormitoryXueshengView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, params));
        return new PageUtils(page);
    }

}
