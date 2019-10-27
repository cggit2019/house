package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.dao.HouseMapper;
import com.team.house.entity.ExHouse;
import com.team.house.entity.House;
import com.team.house.service.HouseService;
import com.team.house.util.PageBean;
import com.team.house.util.SelHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public boolean addHouse(House house) {
        int insert = houseMapper.insertSelective(house);
        return insert>0?true:false;
    }

    @Override
    public PageInfo<ExHouse> searchHouse(Integer userId, PageBean pb) {
        PageHelper.startPage(1,5);
        List<ExHouse> exHouses = houseMapper.selectByUserId(userId);
        PageInfo<ExHouse> pageInfo = new PageInfo<>(exHouses);
        return pageInfo;
    }

    @Override
    public boolean delHouse(String id) {
        House house=new House();
        house.setId(id);
        house.setIsdel(1);
        int del = houseMapper.updateByPrimaryKeySelective(house);
        return del>0?true:false;
    }

    @Override
    public ExHouse getHouse(String id) {
        ExHouse exHouse = houseMapper.selectExHouse(id);
        return exHouse;
    }

    @Override
    public boolean update(House house) {
        int update = houseMapper.updateByPrimaryKeySelective(house);
        return update>0?true:false;
    }

    @Override
    public PageInfo<ExHouse> getHousesBySome(SelHouse selHouse,Integer page) {
        PageHelper.startPage(page,5);
        List<ExHouse> exHouses = houseMapper.selectExHouseBySome(selHouse);
        PageInfo<ExHouse> pageInfo = new PageInfo<>(exHouses);
        return pageInfo;
    }

    @Override
    public ExHouse getExHouse(String id) {
        return houseMapper.getExHouse(id);
    }

    @Override
    public PageInfo<ExHouse> getHousesByPass(Integer state,PageBean pb) {
        PageHelper.startPage(pb.getPage(),pb.getRows());
        List<ExHouse> exHouses = houseMapper.selectExHouseByPass(state);
        PageInfo<ExHouse> pageInfo = new PageInfo<>(exHouses);
        return pageInfo;
    }

    @Override
    public boolean goPass(Map map) {
        int goPass = houseMapper.goPass(map);
        return goPass>0?true:false;
    }
}
