package com.team.house.dao;

import com.team.house.entity.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    List<Users> selectByMore(Users user);

    //登录查询
    @Select("select * from users where `NAME`=#{param1} and `PASSWORD`=#{param2}")
    Users login(String name,String password);

    @Select("select * from users where `NAME`=#{name}")
    Users checkName(String name);
}