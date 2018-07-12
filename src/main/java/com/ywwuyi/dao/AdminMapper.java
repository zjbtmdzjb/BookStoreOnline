package com.ywwuyi.dao;

import org.apache.ibatis.annotations.Param;

import com.ywwuyi.domain.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    Admin selectByAdminname(String adminame);
    
    Admin selectByAdminnameAndPassword(@Param("name")String adminame, @Param("password")String password);

}