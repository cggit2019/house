package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.dao.UsersMapper;
import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import com.team.house.util.MD5Utils;
import com.team.house.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public PageInfo<Users> queryByMore(PageBean pb, Users user) {
        PageHelper.startPage(pb.getPage(),pb.getRows());
        List<Users> users = usersMapper.selectByMore(user);
        PageInfo<Users> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    //用户登录
    @Override
    public Users login(String name, String password) {
        Users users = usersMapper.login(name, MD5Utils.md5Encrypt(password));
        return users;
    }

    //用户注册
    @Override
    public boolean add(Users users) {
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        users.setIsadmin(0);
        int add = usersMapper.insertSelective(users);
        return add>0?true:false;
    }

    //验证用户名
    @Override
    public boolean checkName(String name) {
        Users checkName = usersMapper.checkName(name);
        if(checkName==null){
            return true;
        }
        return false;
    }

    //电话登陆
    @Override
    public Users login2(String telephone) {
        return usersMapper.login2(telephone);
    }
}
