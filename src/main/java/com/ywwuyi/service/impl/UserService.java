package com.ywwuyi.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywwuyi.domain.*;
import com.ywwuyi.service.*;
import com.ywwuyi.dao.*;

@Service("userService")
public class UserService implements IUserService {
    @Resource
    private UserMapper userDao;
    @Autowired
    private AdminMapper adminDao;
    

    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }

	public Admin getAdminByAdminname(String adminname) {
		return this.adminDao.selectByAdminname(adminname);
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO 自动生成的方法存根
		return this.userDao.selectByUsername(username);
	}

	@Override
<<<<<<< HEAD
	public Admin getAdminByAdminnameAndPassword(String adminame, String password) {
		return this.adminDao.selectByAdminnameAndPassword(adminame, password);
	}
}			
=======
	public User userInsert(User user) {
		this.userDao.insert(user);
		return user;
	}

	@Override
	public User userLogin(String username, String password) {
		return this.userDao.selectByUsernameAndPassword(username, password);
	}
}
>>>>>>> 328ffc0a1f1b4ed1e3a55bc61ad3da12899ce271
