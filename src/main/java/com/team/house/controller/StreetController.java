package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.Street;
import com.team.house.service.DistrictService;
import com.team.house.service.StreetService;
import com.team.house.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class StreetController {
    @Autowired
    private StreetService streetService;

    /**
     * 获取区域数据并分页
     * 返回区域数据集合以及总记录
     * */
    @RequestMapping("/getStreet")
    @ResponseBody
    public Map<String,Object> getStreet(PageBean pb, Integer districtId){
        PageInfo<Street> pageInfo = streetService.queryAll(pb,districtId);
        Map<String,Object> map=new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }

    /**
     * 添加区域数据
     * 返回字符串成功(success)或失败(fail)
     * */
    @RequestMapping("/addStreet")
    @ResponseBody
    public String add(Street street){
        boolean add = streetService.add(street);
        if(add){
            return "success!";
        }
        return "fail!";
    }

    /**
     * 修改区域数据前的显示查询
     * 返回区域类型的对象
     * */
    @RequestMapping("/queryStreet")
    @ResponseBody
    public Street queryStreet(Integer id){
        Street street = streetService.queryById(id);
        return street;
    }

    /**
     * 修改区域数据
     * 返回字符串成功(success)或失败(fail)
     * */
    @RequestMapping("/upStreet")
    @ResponseBody
    public String upStreet(Street street){
        boolean update = streetService.update(street);
        if(update){
            return "success!";
        }
        return "fail!";
    }

    /**
     * 删除区域数据
     * 返回字符串成功(success)或失败(fail)
     * */
    @RequestMapping("/delStreet")
    @ResponseBody
    public String delStreet(Integer id){
        boolean del = streetService.del(id);
        if(del){
            return "success!";
        }
        return "fail!";
    }

    /**
     * 批量删除区域数据
     * 返回字符串(success)或(fail)
     * */
    @RequestMapping("/delStreets")
    @ResponseBody
    public String delStreets(Integer[] idList){
        boolean del = streetService.delBatch(idList);
        if(del){
            return "success!";
        }
        return "fail!";
    }
}
