package com.ywwuyi.dao;

import com.ywwuyi.domain.Book;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);
    
    Book selectByBookName(String bookname);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}