package com.entity.view;

import com.entity.PayEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 缴费信息表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-01
 */
@TableName("pay")
public class PayView extends PayEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public PayView() {

	}

	public PayView(PayEntity payEntity) {
		try {
			BeanUtils.copyProperties(this, payEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
