package com.ywwuyi.dao;

import com.ywwuyi.domain.Order;
import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);
    
    List<Map<String,String>> selectByUserId(Integer userid);
    
    List<Map<String,String>> selectAllOrder();

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
}