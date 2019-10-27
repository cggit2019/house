package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.dao.DistrictMapper;
import com.team.house.dao.TypeMapper;
import com.team.house.entity.District;
import com.team.house.entity.Street;
import com.team.house.entity.Type;
import com.team.house.service.DistrictService;
import com.team.house.service.TypeService;
import com.team.house.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    //批量删除类型
    @Override
    public boolean delBatch(Integer[] idList) {
        int dels = typeMapper.delTypes(idList);
        return dels>0?true:false;
    }
    //删除单个类型
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean del(Integer id) {
        int delete = typeMapper.deleteByPrimaryKey(id);
        return delete>0?true:false;
    }
    //更新类型
    @Override
    public boolean update(Type type) {
        int update = typeMapper.updateByPrimaryKeySelective(type);
        return update>0?true:false;
    }
    //根据Id查询类型
    @Override
    public Type queryById(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }
    //添加区域
    @Override
    public boolean add(Type type) {
        int insert = typeMapper.insertSelective(type);
        return insert>0?true:false;
    }
    //分页查询数据
    @Override
    public PageInfo<Type> queryAll(PageBean pb) {
        PageHelper.startPage(pb.getPage(),pb.getRows());
        List<Type> types = typeMapper.selectAll();
        PageInfo<Type> pageInfo = new PageInfo<>(types);
        return pageInfo;
    }

    @Override
    public List<Type> queryType() {
        return typeMapper.selectAll();
    }
}
