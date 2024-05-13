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

import com.entity.DormitoryXueshengEntity;

import com.service.DormitoryXueshengService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 宿舍与学生一对多关系表
 * 后端接口
 * @author
 * @email
 * @date 2021-01-30
*/
@RestController
@Controller
@RequestMapping("/dormitoryXuesheng")
public class DormitoryXueshengController {
    private static final Logger logger = LoggerFactory.getLogger(DormitoryXueshengController.class);

    @Autowired
    private DormitoryXueshengService dormitoryXueshengService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = dormitoryXueshengService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        DormitoryXueshengEntity dormitoryXuesheng = dormitoryXueshengService.selectById(id);
        if(dormitoryXuesheng!=null){
            return R.ok().put("data", dormitoryXuesheng);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DormitoryXueshengEntity dormitoryXuesheng, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<DormitoryXueshengEntity> queryWrapper = new EntityWrapper<DormitoryXueshengEntity>()
            .eq("xuesheng_id", dormitoryXuesheng.getXueshengId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DormitoryXueshengEntity dormitoryXueshengEntity = dormitoryXueshengService.selectOne(queryWrapper);
        if(dormitoryXueshengEntity==null){
            dormitoryXueshengService.insert(dormitoryXuesheng);
            return R.ok();
        }else {
            return R.error(511,"该学生已经绑定过宿舍");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DormitoryXueshengEntity dormitoryXuesheng, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<DormitoryXueshengEntity> queryWrapper = new EntityWrapper<DormitoryXueshengEntity>()
            .notIn("id",dormitoryXuesheng.getId())
            .eq("xuesheng_id", dormitoryXuesheng.getXueshengId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DormitoryXueshengEntity dormitoryXueshengEntity = dormitoryXueshengService.selectOne(queryWrapper);
        if(dormitoryXueshengEntity==null){
            dormitoryXueshengService.updateById(dormitoryXuesheng);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该学生已经绑定过宿舍");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        dormitoryXueshengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

