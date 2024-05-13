package com.controller;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.annotation.IgnoreAuth;
import com.entity.DormitoryXueshengEntity;
import com.entity.PayEntity;
import com.entity.UserEntity;
import com.entity.view.XueshengView;
import com.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.XueshengEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 学生
 * 后端接口
 * @author
 * @email
 * @date 2021-01-30
*/
@RestController
@Controller
@RequestMapping("/xuesheng")
public class XueshengController {
    private static final Logger logger = LoggerFactory.getLogger(XueshengController.class);

    @Autowired
    private XueshengService xueshengService;

    @Autowired
    private PayService payService; // 缴费信息

    @Autowired
    private TokenService tokenService;

    @Autowired
    private DormitoryXueshengService dormitoryXueshengService;// 宿舍与学生关系

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = xueshengService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        XueshengEntity xuesheng = xueshengService.selectById(id);
        if(xuesheng!=null){
            return R.ok().put("data", xuesheng);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengEntity xuesheng, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<XueshengEntity> queryWrapper = new EntityWrapper<XueshengEntity>()
            .eq("account", xuesheng.getAccount())
            .eq("notification_code", xuesheng.getNotificationCode())
            .eq("phone", xuesheng.getPhone())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengEntity xueshengEntity = xueshengService.selectOne(queryWrapper);
        xuesheng.setMima("");
        if("".equals(xuesheng.getPortraitPhoto()) || "null".equals(xuesheng.getPortraitPhoto())){
            xuesheng.setPortraitPhoto(null);
        }
        if(xueshengEntity==null){
            xueshengService.insert(xuesheng);

            PayEntity<Object> pay = new PayEntity<>();
            pay.setPayFlag(2);//未交费
            pay.setMoneyTime(new Date());
            pay.setCreateTime(new Date());
            pay.setXueshengId(xuesheng.getId());//学生id
            pay.setMoney(33.3);
            payService.insert(pay);
            return R.ok();
        }else {
            return R.error(511,"账户,通知书编码,手机号已被使用");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XueshengEntity xuesheng, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<XueshengEntity> queryWrapper = new EntityWrapper<XueshengEntity>()
            .notIn("id",xuesheng.getId())
            .eq("account", xuesheng.getAccount())
            .eq("notification_code", xuesheng.getNotificationCode())
            .eq("phone", xuesheng.getPhone())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengEntity xueshengEntity = xueshengService.selectOne(queryWrapper);
        if("".equals(xuesheng.getPortraitPhoto()) || "null".equals(xuesheng.getPortraitPhoto())){
                xuesheng.setPortraitPhoto(null);
        }
        if(xueshengEntity==null){
            xueshengService.updateById(xuesheng);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户,通知书编码,手机号已被使用");
        }
    }

    /**
     * 注册
     */
    @RequestMapping("/register")
    public R register(@RequestBody XueshengEntity xuesheng, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",register");
        //编号姓名一致 并且账户为空的才是注册
        Wrapper<XueshengEntity> queryWrapper1 = new EntityWrapper<XueshengEntity>()
                .in("notification_code",xuesheng.getNotificationCode())
                .in("xingming",xuesheng.getXingming())
                .addFilterIfNeed(true,"account = ''")
                ;
        //查询账户没有被使用
        Wrapper<XueshengEntity> queryWrapper2 = new EntityWrapper<XueshengEntity>()
                .in("account",xuesheng.getAccount());
        logger.info("sql语句1:"+queryWrapper1.getSqlSegment());
        logger.info("sql语句2:"+queryWrapper1.getSqlSegment());
        XueshengEntity xueshengEntity1 = xueshengService.selectOne(queryWrapper1);
        XueshengEntity xueshengEntity2 = xueshengService.selectOne(queryWrapper2);
        if(xueshengEntity1!=null && xueshengEntity2==null){//编号未被其他账户使用  并且账户不存在为注册用户
            xuesheng.setId(xueshengEntity1.getId());
            xueshengService.updateById(xuesheng);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"通知书编号已经被使用 或 账户已存在");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        for(Long id :ids){
            PayEntity pay = payService.selectOne(new EntityWrapper<PayEntity>().in("xuesheng_id", String.valueOf(id)));
            Integer count = dormitoryXueshengService.selectCount(new EntityWrapper<DormitoryXueshengEntity>().in("xuesheng_id", String.valueOf(id)));//查询学生id是否绑定用宿舍
            if(pay!=null){
                XueshengEntity xueshengEntity = xueshengService.selectById(id);
                return R.error(512,"姓名为:"+xueshengEntity.getXingming()+"的账户下有缴费记录");
            }else if(count>0){
                XueshengEntity xueshengEntity = xueshengService.selectById(id);
                return R.error(512,"姓名为:"+xueshengEntity.getXingming()+"的账户下有住宿信息未清除");
            }
        }
        xueshengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 登录
     */
    @IgnoreAuth
    @PostMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        XueshengEntity xuesheng = xueshengService.selectOne(new EntityWrapper<XueshengEntity>().eq("account", username));
        if(xuesheng==null || !xuesheng.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
        String token = tokenService.generateToken(xuesheng.getId(),username, "users", "学生");
        R r = R.ok();
        r.put("token", token);
        r.put("role","学生");
        r.put("userId",xuesheng.getId());
        return r;
    }


    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        XueshengEntity xueshengEntity = xueshengService.selectById(id);
        return R.ok().put("data", xueshengEntity);
    }



}

