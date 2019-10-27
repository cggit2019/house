package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.util.PageBean;

import java.util.List;

public interface TypeService {
    //分页查询数据
    PageInfo<Type> queryAll(PageBean pb);
    //添加类型
    boolean add(Type type);
    //根据Id查询类型
    Type queryById(Integer id);
    //更新类型
    boolean update(Type type);
    //删除类型
    boolean del(Integer id);
    //批量删除类型
    boolean delBatch(Integer[] idList);

    List<Type> queryType();
}
