package com.team.house.controller.pre;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.ExHouse;
import com.team.house.entity.House;
import com.team.house.entity.Users;
import com.team.house.service.HouseService;
import com.team.house.util.PageBean;
import com.team.house.util.SelHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

@Controller("preHouseController")
@RequestMapping("/page")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping("/addHouse")
    public String addHouse(House house, HttpSession session, MultipartFile pfile){
        try {
            String filename = pfile.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));
            Calendar calendar = Calendar.getInstance();
            String path=calendar.get(Calendar.YEAR)+"/"
                    +(calendar.get(Calendar.MONTH)+1)+"/"
                    +calendar.get(Calendar.DAY_OF_MONTH);
            File filePath= new File("D:/image/"+path);
            if(!filePath.exists()){
                filePath.mkdirs();
            }
            String name=System.currentTimeMillis()+suffix;
            house.setPath(path+"/"+name);
            Users user = (Users) session.getAttribute("userInfo");
            house.setId(System.currentTimeMillis()+"");
            house.setUserId(user.getId());
            house.setIsdel(0);
            house.setIspass(0);
            boolean addHouse = houseService.addHouse(house);
            File file=new File("D:/image/"+path+"/"+name);
            pfile.transferTo(file);
            if(addHouse){
                return "redirect:/page/searchHouse";
            }
            return "fabu";
        } catch (IOException e) {
            e.printStackTrace();
            return "fabu";
        }
    }

    @RequestMapping("/searchHouse")
    public String searchHouse(PageBean pb,HttpSession session,Model model){
        Users user = (Users) session.getAttribute("userInfo");
        PageInfo<ExHouse> pageInfo = houseService.searchHouse(user.getId(), pb);
        model.addAttribute("pageInfo",pageInfo);
        return "guanli";
    }

    @RequestMapping("/delHouse")
    @ResponseBody
    public Boolean delHouse(String id){
        boolean delHouse = houseService.delHouse(id);
        return delHouse;
    }

    @RequestMapping("/getHouse")
    public String getHouse(House house){
        boolean getHouse = houseService.update(house);
        return "guanli";
    }

    @RequestMapping("/getExHouse")
    public String getExHouse(String id,Model model){
        ExHouse house = houseService.getHouse(id);
        model.addAttribute("house",house);
        return "update";
    }

    @RequestMapping("/updateHouse")
    public String updateHouse(House house,MultipartFile pfile,String oldPath){
        if(!pfile.isEmpty()){
            String filename = pfile.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));
            Calendar calendar = Calendar.getInstance();
            String path=calendar.get(Calendar.YEAR)+"/"
                    +(calendar.get(Calendar.MONTH)+1)+"/"
                    +calendar.get(Calendar.DAY_OF_MONTH);
            File filePath= new File("D:/image/"+path);
            if(!filePath.exists()){
                filePath.mkdirs();
            }
            String name=System.currentTimeMillis()+suffix;
            File file=new File("D:/image/"+path+"/"+name);
            try {
                pfile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            house.setPath(path+"/"+name);
            File oldFile=new File("D:/image/"+oldPath);
            oldFile.delete();
        }
        house.setIsdel(0);
        house.setIspass(0);
        boolean updateHouse = houseService.update(house);
        return "redirect:/page/searchHouse";
    }

    @RequestMapping("/getExHousesBySome")
    public String getExHousesBySome(SelHouse selHouse, @RequestParam(defaultValue = "1") Integer page, Model model){
        PageInfo<ExHouse> houses = houseService.getHousesBySome(selHouse,page);
        model.addAttribute("houses",houses);
        System.out.println(houses);
        model.addAttribute("selHouse",selHouse);
        return "list";
    }

    @RequestMapping("/getDetails")
    public String getDetails(String id,Model model){
        ExHouse house = houseService.getExHouse(id);
        model.addAttribute("house",house);
        return "details";
    }
}
