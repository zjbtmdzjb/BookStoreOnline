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
    
    Admin selectByAdminname(String adminname);
    
    Admin selectByAdminnameAndPassword(@Param("name")String adminname, @Param("password")String password);

}