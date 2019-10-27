package com.team.house.dao;

import com.team.house.entity.Street;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);

    //查询所有街道
    List<Street> selectAll(Integer districtId);

    //删除街道内的房源
    @Delete("delete from house where STREET_ID=#{id}")
    int delHouse(Integer id);
    //批量删除街道
    int delStreets(Integer[] idList);

    @Select("select * from street")
    List<Street> selectStreets();
}