package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.DormitoryXueshengEntity;
import com.service.DormitoryXueshengService;
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

import com.entity.DormitoryEntity;

import com.service.DormitoryService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 宿舍信息表
 * 后端接口
 * @author
 * @email
 * @date 2021-01-30
*/
@RestController
@Controller
@RequestMapping("/dormitory")
public class DormitoryController {
    private static final Logger logger = LoggerFactory.getLogger(DormitoryController.class);

    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private DormitoryXueshengService dormitoryXueshengService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = dormitoryService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        DormitoryEntity dormitory = dormitoryService.selectById(id);
        if(dormitory!=null){
            return R.ok().put("data", dormitory);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DormitoryEntity dormitory, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<DormitoryEntity> queryWrapper = new EntityWrapper<DormitoryEntity>()
            .eq("Building", dormitory.getBuilding())
            .eq("unit", dormitory.getUnit())
            .eq("room", dormitory.getRoom())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DormitoryEntity dormitoryEntity = dormitoryService.selectOne(queryWrapper);
        if(dormitoryEntity==null){
            dormitoryService.insert(dormitory);
            return R.ok();
        }else {
            return R.error(511,"此房间已存在");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DormitoryEntity dormitory, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<DormitoryEntity> queryWrapper = new EntityWrapper<DormitoryEntity>()
            .notIn("id",dormitory.getId())
            .eq("Building", dormitory.getBuilding())
            .eq("unit", dormitory.getUnit())
            .eq("room", dormitory.getRoom())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DormitoryEntity dormitoryEntity = dormitoryService.selectOne(queryWrapper);
        if(dormitoryEntity==null){
            dormitoryService.updateById(dormitory);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"房间已经存在");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        for (Long id:ids){
            Wrapper<DormitoryXueshengEntity> queryWrapper = new EntityWrapper<DormitoryXueshengEntity>()
                    .in("dormitory_id",String.valueOf(id));
            Integer i = dormitoryXueshengService.selectCount(queryWrapper);
            if(i>0){
                return R.error(512,"该宿舍下有学生住宿");
            }
        }
        dormitoryService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

