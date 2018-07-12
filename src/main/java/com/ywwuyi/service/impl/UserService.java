package com.ywwuyi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ywwuyi.domain.*;
import com.ywwuyi.service.*;
import com.ywwuyi.dao.*;

@Service("userService")
public class UserService implements IUserService {
    @Resource
    private UserMapper userDao;

    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }

	@Override
	public User getUserByUsername(String username) {
		// TODO 自动生成的方法存根
		return this.userDao.selectByUsername(username);
	}
}
