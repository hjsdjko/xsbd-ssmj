package com.entity.view;

import com.entity.DormitoryXueshengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 宿舍与学生一对多关系表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-01
 */
@TableName("dormitory_xuesheng")
public class DormitoryXueshengView extends DormitoryXueshengEntity implements Serializable {
    private static final long serialVersionUID = 1L;


	private String xingming;


	private String notificationCode;



	public DormitoryXueshengView() {

	}

	public DormitoryXueshengView(DormitoryXueshengEntity dormitoryXueshengEntity) {
		try {
			BeanUtils.copyProperties(this, dormitoryXueshengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public String getXingming() {
		return xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public String getNotificationCode() {
		return notificationCode;
	}

	public void setNotificationCode(String notificationCode) {
		this.notificationCode = notificationCode;
	}
}
