package com.entity.model;

import com.entity.XueshengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学生
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-01
 */
public class XueshengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String account;


    /**
     * 密码
     */
    private String mima;


    /**
     * 姓名
     */
    private String xingming;


    /**
     * 录取通知单编码
     */
    private String notificationCode;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 年龄
     */
    private Integer age;


    /**
     * 电话
     */
    private String phone;


    /**
     * 邮箱
     */
    private String email;


    /**
     * 照片
     */
    private String portraitPhoto;


    /**
     * 是否报道
     */
    private Integer reportTypes;


    /**
     * 学院id
     */
    private Integer collegeTypes;


    /**
     * 专业id
     */
    private Integer majorTypes;


    /**
     * 班级id
     */
    private Integer clazzTypes;


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
	 * 设置：账户
	 */
    public String getAccount() {
        return account;
    }


    /**
	 * 获取：账户
	 */

    public void setAccount(String account) {
        this.account = account;
    }
    /**
	 * 设置：密码
	 */
    public String getMima() {
        return mima;
    }


    /**
	 * 获取：密码
	 */

    public void setMima(String mima) {
        this.mima = mima;
    }
    /**
	 * 设置：姓名
	 */
    public String getXingming() {
        return xingming;
    }


    /**
	 * 获取：姓名
	 */

    public void setXingming(String xingming) {
        this.xingming = xingming;
    }
    /**
	 * 设置：录取通知单编码
	 */
    public String getNotificationCode() {
        return notificationCode;
    }


    /**
	 * 获取：录取通知单编码
	 */

    public void setNotificationCode(String notificationCode) {
        this.notificationCode = notificationCode;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 获取：年龄
	 */

    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 设置：电话
	 */
    public String getPhone() {
        return phone;
    }


    /**
	 * 获取：电话
	 */

    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getEmail() {
        return email;
    }


    /**
	 * 获取：邮箱
	 */

    public void setEmail(String email) {
        this.email = email;
    }
    /**
	 * 设置：照片
	 */
    public String getPortraitPhoto() {
        return portraitPhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setPortraitPhoto(String portraitPhoto) {
        this.portraitPhoto = portraitPhoto;
    }
    /**
	 * 设置：是否报道
	 */
    public Integer getReportTypes() {
        return reportTypes;
    }


    /**
	 * 获取：是否报道
	 */

    public void setReportTypes(Integer reportTypes) {
        this.reportTypes = reportTypes;
    }
    /**
	 * 设置：学院id
	 */
    public Integer getCollegeTypes() {
        return collegeTypes;
    }


    /**
	 * 获取：学院id
	 */

    public void setCollegeTypes(Integer collegeTypes) {
        this.collegeTypes = collegeTypes;
    }
    /**
	 * 设置：专业id
	 */
    public Integer getMajorTypes() {
        return majorTypes;
    }


    /**
	 * 获取：专业id
	 */

    public void setMajorTypes(Integer majorTypes) {
        this.majorTypes = majorTypes;
    }
    /**
	 * 设置：班级id
	 */
    public Integer getClazzTypes() {
        return clazzTypes;
    }


    /**
	 * 获取：班级id
	 */

    public void setClazzTypes(Integer clazzTypes) {
        this.clazzTypes = clazzTypes;
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
