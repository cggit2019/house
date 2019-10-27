package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.service.DistrictService;
import com.team.house.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    /**
     * 获取区域数据并分页
     * 返回区域数据集合以及总记录
     * */
    @RequestMapping("/getDistrict")
    @ResponseBody
    public Map<String,Object> getDistrict(PageBean pb){
        PageInfo<District> pageInfo = districtService.queryAll(pb);
        Map<String,Object> map=new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }

    /**
     * 添加区域数据
     * 返回字符串成功(success)或失败(fail)
     * */
    @RequestMapping("/addDistrict")
    @ResponseBody
    public String add(District district){
        boolean add = districtService.add(district);
        if(add){
            return "success!";
        }
        return "fail!";
    }

    /**
     * 修改区域数据前的显示查询
     * 返回区域类型的对象
     * */
    @RequestMapping("/queryDistrict")
    @ResponseBody
    public District queryDistrict(Integer id){
        District district = districtService.queryById(id);
        return district;
    }

    /**
     * 修改区域数据
     * 返回字符串成功(success)或失败(fail)
     * */
    @RequestMapping("/upDistrict")
    @ResponseBody
    public String upDistrict(District district){
        boolean update = districtService.update(district);
        if(update){
            return "success!";
        }
        return "fail!";
    }

    /**
     * 删除区域数据
     * 返回字符串成功(success)或失败(fail)
     * */
    @RequestMapping("/delDistrict")
    @ResponseBody
    public String delDistrict(Integer id){
        boolean del = districtService.del(id);
        if(del){
            return "success!";
        }
        return "fail!";
    }

    /**
     * 批量删除区域数据
     * 返回字符串(success)或(fail)
     * */
    @RequestMapping("/delDistricts")
    @ResponseBody
    public String delDistricts(Integer[] idList){
        boolean del = districtService.delBatch(idList);
        if(del){
            return "success!";
        }
        return "fail!";
    }
}
