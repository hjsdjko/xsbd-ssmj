package com.dao;

import com.entity.DormitoryEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DormitoryView;

/**
 * 宿舍信息表 Dao 接口
 *
 * @author 
 * @since 2021-01-30
 */
public interface DormitoryDao extends BaseMapper<DormitoryEntity> {

   List<DormitoryView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
