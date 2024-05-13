package com.entity.view;

import com.entity.NoticeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 通知表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-01
 */
@TableName("notice")
public class NoticeView extends NoticeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public NoticeView() {

	}

	public NoticeView(NoticeEntity noticeEntity) {
		try {
			BeanUtils.copyProperties(this, noticeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
