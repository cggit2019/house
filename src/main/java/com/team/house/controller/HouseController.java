package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.ExHouse;
import com.team.house.service.HouseService;
import com.team.house.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping("/getNoPass")
    @ResponseBody
    public Map<String,Object> getNoPass(Integer state, PageBean pb){
        PageInfo<ExHouse> pageInfo = houseService.getHousesByPass(state, pb);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @RequestMapping("/goPass")
    @ResponseBody
    public boolean goPass(String id){
        Map map=new HashMap();
        map.put("id",id);
        map.put("state",1);
        return houseService.goPass(map);
    }

    @RequestMapping("/getPass")
    @ResponseBody
    public Map<String,Object> getPass(Integer state, PageBean pb){
        PageInfo<ExHouse> pageInfo = houseService.getHousesByPass(state, pb);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @RequestMapping("/goNoPass")
    @ResponseBody
    public boolean goNoPass(String id){
        Map map=new HashMap();
        map.put("id",id);
        map.put("state",0);
        return houseService.goPass(map);
    }
}
