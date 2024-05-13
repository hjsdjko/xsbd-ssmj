package com.entity.model;

import com.entity.PayEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 缴费信息表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-01
 */
public class PayModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户id(xuesheng表)
     */
    private Integer xueshengId;


    /**
     * 缴费金额
     */
    private Double money;


    /**
     *  是否缴费
     */
    private Integer payFlag;


    /**
     * 缴费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date moneyTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
