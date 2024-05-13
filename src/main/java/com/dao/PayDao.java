package com.dao;

import com.entity.PayEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PayView;

/**
 * 缴费信息表 Dao 接口
 *
 * @author 
 * @since 2021-01-30
 */
public interface PayDao extends BaseMapper<PayEntity> {

   List<PayView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
