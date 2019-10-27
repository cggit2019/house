package com.team.house.dao;

import com.team.house.entity.Street;
import com.team.house.entity.Type;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    //查询所有类型
    @Select("select * from type")
    List<Type> selectAll();

    //批量删除区域
    int delTypes(Integer[] idList);
}