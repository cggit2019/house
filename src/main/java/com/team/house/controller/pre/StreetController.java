package com.team.house.controller.pre;

import com.team.house.entity.Street;
import com.team.house.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("preStreetController")
@RequestMapping("/page")
public class StreetController {

    @Autowired
    private StreetService streetService;

    @RequestMapping("/queryStreets")
    @ResponseBody
    public List<Street> queryStreets(Integer districtId){
        List<Street> streets = streetService.getStreets(districtId);
        return streets;
    }

    @RequestMapping("/selectStreets")
    @ResponseBody
    public List<Street> selectStreets(){
        List<Street> streets = streetService.selectStreets();
        return streets;
    }
}
