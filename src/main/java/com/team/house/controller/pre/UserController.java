package com.team.house.controller.pre;

import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import com.team.house.util.sms.SentMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("/getCode")
    @ResponseBody
    public Map<String,Boolean> getCode(String telephone, HttpSession session){
        Users users = usersService.login2(telephone);
        Map<String,Boolean> map=new HashMap<>();
        if(users==null){
            map.put("tel",false);
        }else {
            int msg = (int)(Math.random()*1000000);
            session.setAttribute("code", msg + "");
            System.out.println(msg);
            int i = SentMsgUtil.sendMsg(telephone, msg + "");
            if (i > 0) {
                map.put("sendCode",true);
            }else{
                map.put("sendCode",false);
            }
        }
        return map;
    }

    @RequestMapping("/login2")
    public String login2(String telephone,String code,HttpSession session,HttpServletRequest req){
        String codes = (String) session.getAttribute("code");
        if(code.equals(codes)){
            Users users = usersService.login2(telephone);
            session.setAttribute("userInfo",users);
            return "redirect:/page/searchHouse";
        }else {
            req.setAttribute("msg","fail");
            return "login2";
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
