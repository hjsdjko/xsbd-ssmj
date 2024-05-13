package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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

import com.entity.NoticeEntity;

import com.service.NoticeService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 通知表
 * 后端接口
 * @author
 * @email
 * @date 2021-01-30
*/
@RestController
@Controller
@RequestMapping("/notice")
public class NoticeController {
    private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

    @Autowired
    private NoticeService noticeService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = noticeService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        NoticeEntity notice = noticeService.selectById(id);
        if(notice!=null){
            return R.ok().put("data", notice);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody NoticeEntity notice, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<NoticeEntity> queryWrapper = new EntityWrapper<NoticeEntity>()
            .eq("notice_types", notice.getNoticeTypes())
            .eq("notice_content", notice.getNoticeContent())
            ;
        Integer userId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        notice.setUsersId(userId);
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NoticeEntity noticeEntity = noticeService.selectOne(queryWrapper);
            notice.setNoticeTime(new Date());
        if(noticeEntity==null){
            noticeService.insert(notice);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody NoticeEntity notice, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<NoticeEntity> queryWrapper = new EntityWrapper<NoticeEntity>()
            .notIn("id",notice.getId())
            .eq("users_id", notice.getUsersId())
            .eq("notice_types", notice.getNoticeTypes())
            .eq("notice_content", notice.getNoticeContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NoticeEntity noticeEntity = noticeService.selectOne(queryWrapper);
                notice.setNoticeTime(new Date());
        if(noticeEntity==null){
            noticeService.updateById(notice);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        noticeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

