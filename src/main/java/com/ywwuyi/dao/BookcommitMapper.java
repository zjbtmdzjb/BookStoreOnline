package com.ywwuyi.dao;

import java.util.List;
import java.util.Map;

import com.ywwuyi.domain.Bookcommit;

public interface BookcommitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bookcommit record);

    int insertSelective(Bookcommit record);

    Bookcommit selectByPrimaryKey(Integer id);
    
    List<Map<String,String>> selectByBookId(Integer bookid);
    
    int updateByPrimaryKeySelective(Bookcommit record);

    int updateByPrimaryKey(Bookcommit record);
}