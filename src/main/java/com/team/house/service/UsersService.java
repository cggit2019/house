package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.util.PageBean;

public interface UsersService {
    //分页查询数据
    PageInfo<Users> queryByMore(PageBean pb, Users user);

    //登录
    Users login(String name,String password);

    //注册
    boolean add(Users users);

    //验证用户名
    boolean checkName(String name);
}
