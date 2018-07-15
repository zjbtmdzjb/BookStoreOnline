package com.ywwuyi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ywwuyi.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    User selectByUsername(String username);
    
    List<Map<String,String>> selectAllUser();
    
    User selectByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}