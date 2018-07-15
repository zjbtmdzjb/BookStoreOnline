package com.ywwuyi.dao;

import java.util.List;
import java.util.Map;

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
    
    List<Map<String,String>> selectAllAdmin();
    
    Admin selectByAdminnameAndPassword(@Param("adminname")String adminname, @Param("password")String password);

}