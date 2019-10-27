package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.dao.DistrictMapper;
import com.team.house.entity.District;
import com.team.house.service.DistrictService;
import com.team.house.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    //批量删除区域
    @Override
    public boolean delBatch(Integer[] idList) {
        int dels = districtMapper.delDistricts(idList);
        return dels>0?true:false;
    }
    //删除单个区域
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean del(Integer id) {
        int delStreet = districtMapper.delStreet(id);
        int delete = districtMapper.deleteByPrimaryKey(id);
        return (delStreet>=0&&delete>0)?true:false;
    }
    //更新区域
    @Override
    public boolean update(District district) {
        int update = districtMapper.updateByPrimaryKeySelective(district);
        return update>0?true:false;
    }
    //根据Id查询区域
    @Override
    public District queryById(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }
    //添加区域
    @Override
    public boolean add(District district) {
        int insert = districtMapper.insertSelective(district);
        return insert>0?true:false;
    }
    //分页查询数据
    @Override
    public PageInfo<District> queryAll(PageBean pb) {
        PageHelper.startPage(pb.getPage(),pb.getRows());
        List<District> districts = districtMapper.selectAll();
        PageInfo<District> pageInfo = new PageInfo<>(districts);
        return pageInfo;
    }

    @Override
    public List<District> queryDistricts() {
        List<District> districts = districtMapper.selectAll();
        return districts;
    }
}
