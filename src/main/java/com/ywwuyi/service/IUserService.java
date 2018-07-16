package com.ywwuyi.service;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

import com.ywwuyi.domain.*;

public interface IUserService {
	public User getUserById(int Id);
	
	public Admin getAdminByAdminname(String adminname);
	
	public List<Map<String,String>> getAllAdmin();
	
	public User getUserByUsername(String username);
	
	public List<Map<String,String>> getAllUser();

	public Admin adminLogin(@Param("adminname")String adminname, @Param("password")String password);

	public User userInsert(User user);
	
	public User userLogin(@Param("username")String username, @Param("password")String password);

	public Integer orderDelete(Integer id);
	
	public Integer bookDelete(Integer id);
	
	public Integer bookcommitDelete(Integer id);
	
	public Integer adminDelete(Integer id);
	
	public Integer userDelete(Integer id);
	
	public Bookcommit bookcommitInsert(Bookcommit bookcommit);
	
	public List<Map<String,String>> getBookcommitByBookId(Integer bookid);
	
	public Book bookInsert(Book book);
	
	public List<Map<String,String>> getBookByBookName(String bookname);
	
	public List<Map<String,String>> getBookByBookType(String type);
	
	public List<Map<String,String>> getBookByBookCost(Integer min,Integer max);
	
	public List<Map<String,String>> getAllBook();

	public Order orderInsert(Order order);
	
	public List<Map<String,String>> getOrderByUserId(Integer userid);
	
	public List<Map<String,String>> getOrderByUsername(String username);
	
	public List<Map<String,String>> getAllOrder();

	public Integer bookUpdata(Book record);
	
	public Integer bookcommitUpdata(Bookcommit record);
	
	public Integer orderUpdata(Order record);

	public List<Map<String, String>> getAllIntroduce();
	
	public List<Map<String, String>> getAllRecommend();

	Book getBookById(Integer bookid);
	
}
