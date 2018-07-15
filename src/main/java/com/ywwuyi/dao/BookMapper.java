package com.ywwuyi.dao;

import java.util.List;
import java.util.Map;
import com.ywwuyi.domain.Book;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);
    
    List<Map<String,String>> selectByBookName(String bookname);
    
    List<Map<String,String>> selectByBookType(String type);
    
    List<Map<String,String>> selectAllBook();

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}