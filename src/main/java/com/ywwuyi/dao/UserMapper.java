package com.ywwuyi.dao;

import org.apache.ibatis.annotations.Param;

import com.ywwuyi.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    User selectByUsername(String username);
    
    User selectByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}