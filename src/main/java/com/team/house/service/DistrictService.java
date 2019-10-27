package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.util.PageBean;

import java.util.List;

public interface DistrictService {
    //分页查询数据
    PageInfo<District> queryAll(PageBean pb);
    //添加区域
    boolean add(District district);
    //根据Id查询区域
    District queryById(Integer id);
    //更新区域
    boolean update(District district);
    //删除区域
    boolean del(Integer id);
    //批量删除区域
    boolean delBatch(Integer[] idList);

    List<District> queryDistricts();
}
