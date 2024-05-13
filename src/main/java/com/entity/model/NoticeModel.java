package com.entity.model;

import com.entity.NoticeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 通知表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-01
 */
public class NoticeModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 发通知的人id(user表)
     */
    private Integer usersId;


    /**
     *  通知类型
     */
    private Integer noticeTypes;


    /**
     * 通知内容
     */
    private String noticeContent;


    /**
     * 通知时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date noticeTime;


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
	 * 设置：发通知的人id(user表)
	 */
    public Integer getUsersId() {
        return usersId;
    }


    /**
	 * 获取：发通知的人id(user表)
	 */

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }
    /**
	 * 设置： 通知类型
	 */
    public Integer getNoticeTypes() {
        return noticeTypes;
    }


    /**
	 * 获取： 通知类型
	 */

    public void setNoticeTypes(Integer noticeTypes) {
        this.noticeTypes = noticeTypes;
    }
    /**
	 * 设置：通知内容
	 */
    public String getNoticeContent() {
        return noticeContent;
    }


    /**
	 * 获取：通知内容
	 */

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }
    /**
	 * 设置：通知时间
	 */
    public Date getNoticeTime() {
        return noticeTime;
    }


    /**
	 * 获取：通知时间
	 */

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
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
