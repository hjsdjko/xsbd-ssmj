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
 * 缴费信息表
 *
 * @author 
 * @email
 * @date 2021-02-01
 */
@TableName("pay")
public class PayEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PayEntity() {

	}

	public PayEntity(T t) {
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
     * 缴费金额
     */
    @TableField(value = "money")
    private Double money;


    /**
     *  是否缴费
     */
    @TableField(value = "pay_flag")
    private Integer payFlag;


    /**
     * 缴费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "money_time")
    private Date moneyTime;


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
	 * 设置：缴费金额
	 */
    public Double getMoney() {
        return money;
    }


    /**
	 * 获取：缴费金额
	 */

    public void setMoney(Double money) {
        this.money = money;
    }
    /**
	 * 设置： 是否缴费
	 */
    public Integer getPayFlag() {
        return payFlag;
    }


    /**
	 * 获取： 是否缴费
	 */

    public void setPayFlag(Integer payFlag) {
        this.payFlag = payFlag;
    }
    /**
	 * 设置：缴费时间
	 */
    public Date getMoneyTime() {
        return moneyTime;
    }


    /**
	 * 获取：缴费时间
	 */

    public void setMoneyTime(Date moneyTime) {
        this.moneyTime = moneyTime;
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
