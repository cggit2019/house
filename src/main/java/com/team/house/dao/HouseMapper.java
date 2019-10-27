package com.team.house.dao;

import com.team.house.entity.ExHouse;
import com.team.house.entity.House;
import com.team.house.util.SelHouse;

import java.util.List;
import java.util.Map;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<ExHouse> selectByUserId(Integer userId);

    ExHouse selectExHouse(String id);

    List<ExHouse> selectExHouseBySome(SelHouse selHouse);

    ExHouse getExHouse(String id);

    List<ExHouse> selectExHouseByPass(Integer state);

    int goPass(Map map);

}