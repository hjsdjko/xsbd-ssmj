package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.PayDao;
import com.entity.PayEntity;
import com.service.PayService;
import com.entity.view.PayView;

/**
 * 缴费信息表 服务实现类
 * @author 
 * @since 2021-01-30
 */
@Service("payService")
@Transactional
public class PayServiceImpl extends ServiceImpl<PayDao, PayEntity> implements PayService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<PayView> page =new Query<PayView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
