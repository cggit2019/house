package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.ExHouse;
import com.team.house.entity.House;
import com.team.house.util.PageBean;
import com.team.house.util.SelHouse;
import java.util.Map;

public interface HouseService {

    boolean addHouse(House house);

    PageInfo<ExHouse> searchHouse(Integer userId, PageBean pb);

    boolean delHouse(String id);

    ExHouse getHouse(String id);

    boolean update(House house);

    PageInfo<ExHouse> getHousesBySome(SelHouse selHouse,Integer page);

    ExHouse getExHouse(String id);

    PageInfo<ExHouse> getHousesByPass(Integer state,PageBean pb);

    boolean goPass(Map map);
}
