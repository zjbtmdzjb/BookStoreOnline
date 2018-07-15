package com.ywwuyi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ywwuyi.service.*;
import com.alibaba.fastjson.JSONArray;
import com.ywwuyi.domain.*;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
    private IUserService userService;
    
    @RequestMapping(value = "showUser",method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Admin toIndex(HttpSession httpSession) {
    	String adminname = "sha";
        Admin admin = this.userService.getAdminByAdminname(adminname);
        return admin;
    }
    
    @RequestMapping(value = "userlogin.action",method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public User login(@RequestBody Map<String,String> map) {
    	String username = map.get("username");
    	String password = map.get("password");
    	User user = this.userService.userLogin(username, password);
    	return user;
    }
    
    @RequestMapping(value = "deleteUser.action",method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Integer delete(@RequestBody Map<String,String> map) {
    	String id = map.get("id");
    	int i = Integer.parseInt(id);
    	return this.userService.userDelete(i);
    
    }
    
    @RequestMapping(value = "userlist",method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String userList(HttpSession httpSession) {
    	List<Map<String, String>> lists =  this.userService.getAllUser();
    	String jsonStr = JSONArray.toJSONString(lists);
    	return jsonStr;
    }
    
    @RequestMapping(value = "userregister.action", method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public User register(@RequestBody Map<String,String> map) {
    	String username = map.get("username");
    	String password = map.get("password");
    	String email = map.get("email");
    	User regis = new User();
    	regis.setUsername(username);
    	regis.setPassword(password);
    	regis.setEmail(email);
    	return this.userService.userInsert(regis);
    }
    
    @RequestMapping(value = "showOrder",method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String userList(@RequestBody Map<String,String> map) {
    	String userid = map.get("userid");
    	int i = Integer.parseInt(userid);
    	List<Map<String, String>> lists = this.userService.getOrderByUserId(i);
    	String jsonStr = JSONArray.toJSONString(lists);
    	return jsonStr;
    }
    
    @RequestMapping(value = "hh",method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String bookList(HttpSession httpSession) {
    	List<Map<String, String>> lists = this.userService.getBookByBookCost(15,20);
    	String jsonStr = JSONArray.toJSONString(lists);
    	return jsonStr;
    }
}