package com.ywwuyi.dao;

import java.util.List;
import java.util.Map;

import com.ywwuyi.domain.Recommend;

public interface RecommendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    Recommend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);
    
    List<Map<String,String>> selectAll();
}