package com.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.XueshengDao;
import com.entity.XueshengEntity;
import com.service.XueshengService;
import com.entity.view.XueshengView;

/**
 * 学生 服务实现类
 * @author 
 * @since 2021-01-30
 */
@Service("xueshengService")
@Transactional
public class XueshengServiceImpl extends ServiceImpl<XueshengDao, XueshengEntity> implements XueshengService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<XueshengView> page =new Query<XueshengView>(params).getPage();
        List<XueshengView> xueshengViews = baseMapper.selectListView(page, params);
//        for( XueshengView  x: xueshengViews){
//            x.set
//        }
        page.setRecords(xueshengViews);
        return new PageUtils(page);
    }

}
