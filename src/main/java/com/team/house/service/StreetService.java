package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.Street;
import com.team.house.util.PageBean;

import java.util.List;

public interface StreetService {
    //分页查询数据
    PageInfo<Street> queryAll(PageBean pb,Integer districtId);
    //添加区域
    boolean add(Street street);
    //根据Id查询区域
    Street queryById(Integer id);
    //更新区域
    boolean update(Street street);
    //删除区域
    boolean del(Integer id);
    //批量删除区域
    boolean delBatch(Integer[] idList);

    List<Street> getStreets(Integer districtId);

    List<Street> selectStreets();

}
