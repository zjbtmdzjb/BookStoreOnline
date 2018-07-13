package com.ywwuyi.service;

import org.apache.ibatis.annotations.Param;

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
	
	public Book bookInsert(Book book);

	public Order orderInsert(Order order);

}
