package com.ywwuyi.service.impl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private OrderMapper orderDao;
    @Autowired
    private BookMapper bookDao;
    @Autowired
    private BookcommitMapper bookcommitDao;

    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }

	public Admin getAdminByAdminname(String adminname) {
		return this.adminDao.selectByAdminname(adminname);
	}

	@Override
	public User getUserByUsername(String username) {
		return this.userDao.selectByUsername(username);
	}
		

	public User userInsert(User user) {
		this.userDao.insert(user);
		return user;
	}

	@Override
	public User userLogin(String username, String password) {
		return this.userDao.selectByUsernameAndPassword(username, password);
	}

	@Override
	public Admin adminLogin(String adminname, String password) {
		return this.adminDao.selectByAdminnameAndPassword(adminname, password);
	}

	@Override
	public Integer orderDelete(Integer id) {
		this.orderDao.deleteByPrimaryKey(id);
		return id;
	}

	@Override
	public Integer bookDelete(Integer id) {
		this.bookDao.deleteByPrimaryKey(id);
		return id;
	}

	@Override
	public Integer bookcommitDelete(Integer id) {
		this.bookcommitDao.deleteByPrimaryKey(id);
		return id;
	}

	@Override
	public Integer adminDelete(Integer id) {
		this.adminDao.deleteByPrimaryKey(id);
		return id;
	}

	@Override
	public Integer userDelete(Integer id) {
		this.userDao.deleteByPrimaryKey(id);
		return id;
	}

	public Bookcommit bookcommitInsert(Bookcommit bookcommit) {
		this.bookcommitDao.insert(bookcommit);
		return bookcommit;
	}
	
	public Book bookInsert(Book book) {
		this.bookDao.insert(book);
		return book;
	}
	
	public List<Map<String,String>> getBookByBookName(String bookname) {
		return bookDao.selectByBookName(bookname);
	}
	
	public List<Map<String,String>> getBookByBookType(String type) {
		return bookDao.selectByBookType(type)
	}
		
	public Order orderInsert(Order order) {
		this.orderDao.insert(order);
		return order;
	}
	
	public Order getOrderByBookId(Integer bookid) {
		return this.orderDao.selectByBookId(bookid);
	}

	@Override
	public Bookcommit getBookcommitByBookcommitId(Integer bookid) {
		return this.bookcommitDao.selectByBookId(bookid);
	}
	@Override
	public Integer bookUpdata(Book record) {
		return this.bookDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer bookcommitUpdata(Bookcommit record) {
		return this.bookcommitDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer orderUpdata(Order record) {
		return this.orderDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer sum(Integer userid) {
		return this.orderDao.sum(userid);
	}
}

