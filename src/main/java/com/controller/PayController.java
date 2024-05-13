package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.DictionaryEntity;
import com.entity.XueshengEntity;
import com.entity.view.PayView;
import com.service.DictionaryService;
import com.service.XueshengService;
import com.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.PayEntity;

import com.service.PayService;

/**
 * 缴费信息表
 * 后端接口
 * @author
 * @email
 * @date 2021-01-30
*/
@RestController
@Controller
@RequestMapping("/pay")
public class PayController {
    private static final Logger logger = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private PayService payService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private XueshengService xueshengService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        //如果权限是学生  就只能查询自己的缴费信息
        if("学生".equals(String.valueOf(request.getSession().getAttribute("role")))){
            params.put("xueshengId",String .valueOf(request.getSession().getAttribute("userId")));
        }
        PageUtils page = payService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        PayEntity pay = payService.selectById(id);
        if(pay!=null){
            return R.ok().put("data", pay);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody PayEntity pay, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<PayEntity> queryWrapper = new EntityWrapper<PayEntity>()
            .eq("xuesheng_id", pay.getXueshengId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PayEntity payEntity = payService.selectOne(queryWrapper);
            pay.setMoneyTime(new Date());
        if(payEntity==null){
            payService.insert(pay);
            return R.ok();
        }else {
            return R.error(511,"该学生已经创建过缴费订单");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PayEntity pay, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<PayEntity> queryWrapper = new EntityWrapper<PayEntity>()
            .notIn("id",pay.getId())
            .eq("xuesheng_id", pay.getXueshengId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PayEntity payEntity = payService.selectOne(queryWrapper);
                pay.setMoneyTime(new Date());
        if(payEntity==null){
            payService.updateById(pay);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该学生已经有缴费订单");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        payService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}

