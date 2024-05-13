package com.entity.model;

import com.entity.DormitoryXueshengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 宿舍与学生一对多关系表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-01
 */
public class DormitoryXueshengModel implements Serializable {
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
     * 宿舍id(dormitory表)
     */
    private Integer dormitoryId;


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
