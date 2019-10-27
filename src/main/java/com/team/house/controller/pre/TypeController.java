package com.team.house.controller.pre;

import com.team.house.entity.Type;
import com.team.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("preTypeController")
@RequestMapping("/page")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("/getTypes")
    @ResponseBody
    public List<Type> getTypes(){
        List<Type> types = typeService.queryType();
        return types;
    }
}
