package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.service.TypeService;
import com.team.house.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;

    /**
     * 获取区域数据并分页
     * 返回区域数据集合以及总记录
     * */
    @RequestMapping("/getType")
    @ResponseBody
    public Map<String,Object> getType(PageBean pb){
        PageInfo<Type> pageInfo = typeService.queryAll(pb);
        Map<String,Object> map=new HashMap<>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }

    /**
     * 添加区域数据
     * 返回字符串成功(success)或失败(fail)
     * */
    @RequestMapping("/addType")
    @ResponseBody
    public String add(Type type){
        boolean add = typeService.add(type);
        if(add){
            return "success!";
        }
        return "fail!";
    }

    /**
     * 修改区域数据前的显示查询
     * 返回区域类型的对象
     * */
    @RequestMapping("/queryType")
    @ResponseBody
    public Type queryType(Integer id){
        Type type = typeService.queryById(id);
        return type;
    }

    /**
     * 修改区域数据
     * 返回字符串成功(success)或失败(fail)
     * */
    @RequestMapping("/upType")
    @ResponseBody
    public String upType(Type type){
        boolean update = typeService.update(type);
        if(update){
            return "success!";
        }
        return "fail!";
    }

    /**
     * 删除区域数据
     * 返回字符串成功(success)或失败(fail)
     * */
    @RequestMapping("/delType")
    @ResponseBody
    public String delType(Integer id){
        boolean del = typeService.del(id);
        if(del){
            return "success!";
        }
        return "fail!";
    }

    /**
     * 批量删除区域数据
     * 返回字符串(success)或(fail)
     * */
    @RequestMapping("/delTypes")
    @ResponseBody
    public String delTypes(Integer[] idList){
        boolean del = typeService.delBatch(idList);
        if(del){
            return "success!";
        }
        return "fail!";
    }
}
