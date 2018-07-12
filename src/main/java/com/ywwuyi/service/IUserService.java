package com.ywwuyi.service;

import org.apache.ibatis.annotations.Param;

import com.ywwuyi.domain.*;

public interface IUserService {
	public User getUserById(int Id);
	
	public Admin getAdminByAdminname(String adminname);
	
	public User getUserByUsername(String username);
	
<<<<<<< HEAD
	public Admin getAdminByAdminnameAndPassword(@Param("username")String adminame, @Param("password")String password);
=======
	public User userInsert(User user);
	
	public User userLogin(@Param("username")String username, @Param("password")String password);
>>>>>>> 328ffc0a1f1b4ed1e3a55bc61ad3da12899ce271
}
