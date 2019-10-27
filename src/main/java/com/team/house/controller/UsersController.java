package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.Users;
import com.team.house.service.DistrictService;
import com.team.house.service.UsersService;
import com.team.house.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 获取区域数据并分页
     * 返回区域数据集合以及总记录
     * */
    @RequestMapping("/getUsers")
    @ResponseBody
    public Map<String,Object> getDistrict(PageBean pb, Users user){
        PageInfo<Users> pageInfo = usersService.queryByMore(pb, user);
        Map<String,Object> map=new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }


}
