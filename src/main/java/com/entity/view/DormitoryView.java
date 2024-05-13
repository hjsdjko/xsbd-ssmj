package com.entity.view;

import com.entity.DormitoryEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 宿舍信息表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-01
 */
@TableName("dormitory")
public class DormitoryView extends DormitoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public DormitoryView() {

	}

	public DormitoryView(DormitoryEntity dormitoryEntity) {
		try {
			BeanUtils.copyProperties(this, dormitoryEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
