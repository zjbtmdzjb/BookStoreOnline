package com.ywwuyi.dao;

import java.util.List;
import java.util.Map;

import com.ywwuyi.domain.Introduce;

public interface IntroduceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Introduce record);

    int insertSelective(Introduce record);

    Introduce selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Introduce record);

    int updateByPrimaryKey(Introduce record);
    
    List<Map<String,String>> selectAll();
}