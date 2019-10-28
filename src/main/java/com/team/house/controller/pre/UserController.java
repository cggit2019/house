package com.team.house.controller.pre;

import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller("preUserController")
@RequestMapping("/page")
public class UserController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/login")
    public String login(String name, String password, HttpSession session, HttpServletRequest req){
        Users users = usersService.login(name, password);
        if(users==null){
            req.setAttribute("msg","fail");
            return "login";
        }else{
            session.setAttribute("userInfo",users);
            return "redirect:/page/searchHouse";
        }
    }

    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.removeAttribute("userInfo");
        return "login";
    }

    @RequestMapping("/regs")
    public String regs(Users users){
        boolean add = usersService.add(users);
        if(add){
            return "login";
        }else{
            return "regs";
        }
    }

    @RequestMapping("/checkName")
    @ResponseBody
    public Boolean checkName(String name){
        return usersService.checkName(name);
    }
}
