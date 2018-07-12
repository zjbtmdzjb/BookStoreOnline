package com.ywwuyi.service;

import com.ywwuyi.domain.*;

public interface IUserService {
	public User getUserById(int Id);
	
	public Admin getAdminByAdminname(String adminname);
	
	public User getUserByUsername(String username);
}
