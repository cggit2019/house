package com.team.house.dao;

import com.team.house.entity.District;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DistrictMapper {
    //查询所有区域
    @Select("select * from district")
    List<District> selectAll();
    //删除区域
    int deleteByPrimaryKey(Integer id);
    //插入区域(全部插入)
    int insert(District record);
    //插入区域(部分插入)
    int insertSelective(District record);
    //根据Id查询
    District selectByPrimaryKey(Integer id);
    //更新数据(部分更新)
    int updateByPrimaryKeySelective(District record);
    //更新数据(全部更新)
    int updateByPrimaryKey(District record);
    //删除区域内的街道
    @Delete("delete from street where DISTRICT_ID=#{id}")
    int delStreet(Integer id);
    //批量删除区域
    int delDistricts(Integer[] idList);
}
