package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 宿舍与学生一对多关系表
 *
 * @author 
 * @email
 * @date 2021-02-01
 */
@TableName("dormitory_xuesheng")
public class DormitoryXueshengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DormitoryXueshengEntity() {

	}

	public DormitoryXueshengEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private Integer id;


    /**
     * 用户id(xuesheng表)
     */
    @TableField(value = "xuesheng_id")
    private Integer xueshengId;


    /**
     * 宿舍id(dormitory表)
     */
    @TableField(value = "dormitory_id")
    private Integer dormitoryId;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户id(xuesheng表)
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 获取：用户id(xuesheng表)
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：宿舍id(dormitory表)
	 */
    public Integer getDormitoryId() {
        return dormitoryId;
    }


    /**
	 * 获取：宿舍id(dormitory表)
	 */

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
