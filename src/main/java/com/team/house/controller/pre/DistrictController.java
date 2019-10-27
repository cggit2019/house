package com.team.house.controller.pre;

import com.team.house.entity.District;
import com.team.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("preDistrictController")
@RequestMapping("/page")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("/queryDistricts")
    @ResponseBody
    public List<District> queryDistricts(){
        List<District> districts = districtService.queryDistricts();
        return districts;
    }
}
