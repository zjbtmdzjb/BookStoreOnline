package com.ywwuyi.dao;

import com.ywwuyi.domain.Bookcommit;

public interface BookcommitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bookcommit record);

    int insertSelective(Bookcommit record);

    Bookcommit selectByPrimaryKey(Integer id);
    
    Bookcommit selectByBookId(Integer bookid);
    
    int updateByPrimaryKeySelective(Bookcommit record);

    int updateByPrimaryKey(Bookcommit record);
}