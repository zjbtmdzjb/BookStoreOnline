package com.ywwuyi.service;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

import com.ywwuyi.domain.*;

public interface IUserService {
	public User getUserById(int Id);
	
	public Admin getAdminByAdminname(String adminname);
	
	public User getUserByUsername(String username);
	

	public Admin adminLogin(@Param("username")String adminame, @Param("password")String password);

	public User userInsert(User user);
	
	public User userLogin(@Param("username")String username, @Param("password")String password);

	public Integer orderDelete(Integer id);
	
	public Integer bookDelete(Integer id);
	
	public Integer bookcommitDelete(Integer id);
	
	public Integer adminDelete(Integer id);
	
	public Integer userDelete(Integer id);
	
	public Bookcommit bookcommitInsert(Bookcommit bookcommit);
	
	public Bookcommit getBookcommitByBookcommitId(Integer bookid);
	
	public Book bookInsert(Book book);
	
	public List<Map<String,String>> getBookByBookName(String bookname);

	public Order orderInsert(Order order);
	
	public Order getOrderByBookId(Integer bookid);

	public Integer bookUpdata(Book record);
	
	public Integer bookcommitUpdata(Bookcommit record);
	
	public Integer orderUpdata(Order record);
	
	public Integer sum(Integer userid);
}
