package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.dao.StreetMapper;
import com.team.house.entity.Street;
import com.team.house.service.StreetService;
import com.team.house.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetMapper streetMapper;

    //批量删除区域
    @Override
    public boolean delBatch(Integer[] idList) {
        int dels = streetMapper.delStreets(idList);
        return dels>0?true:false;
    }
    //删除单个区域
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean del(Integer id) {
        int delHouse = streetMapper.delHouse(id);
        int delete = streetMapper.deleteByPrimaryKey(id);
        return (delHouse>=0&&delete>0)?true:false;
    }
    //更新区域
    @Override
    public boolean update(Street street) {
        int update = streetMapper.updateByPrimaryKeySelective(street);
        return update>0?true:false;
    }
    //根据Id查询区域
    @Override
    public Street queryById(Integer id) {
        return streetMapper.selectByPrimaryKey(id);
    }
    //添加区域
    @Override
    public boolean add(Street street) {
        int insert = streetMapper.insertSelective(street);
        return insert>0?true:false;
    }
    //分页查询数据
    @Override
    public PageInfo<Street> queryAll(PageBean pb,Integer districtId) {
        PageHelper.startPage(pb.getPage(),pb.getRows());
        List<Street> streets = streetMapper.selectAll(districtId);
        PageInfo<Street> pageInfo = new PageInfo<>(streets);
        return pageInfo;
    }

    @Override
    public List<Street> getStreets(Integer districtId) {
        List<Street> streets = streetMapper.selectAll(districtId);
        return streets;
    }

    @Override
    public List<Street> selectStreets() {
        return streetMapper.selectStreets();
    }
}
