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
@RequestMapping("/admin")
public class AdminController {

	@Autowired
    private IUserService userService;
    
    @RequestMapping(value = "adminlogin.action",method = RequestMethod.POST)
    @ResponseBody
    public Admin login(@RequestBody Map<String,String> map) {
    	String adminname = map.get("adminname");
    	String password = map.get("password");
    	Admin admin = this.userService.adminLogin(adminname, password);
    	return admin;
    }
    

    @RequestMapping(value = "deleteAdmin.action",method = RequestMethod.POST)
    @ResponseBody
    public Integer delete(@RequestBody Map<String,String> map) {
    	String id = map.get("id");
    	int i = Integer.parseInt(id);
    	return this.userService.adminDelete(i);
    }
    

    @RequestMapping(value = "Adminlist",method = RequestMethod.GET)
    @ResponseBody
    public String  userList(HttpSession httpSession) {
    	List<Map<String,String>> lists = this.userService.getAllAdmin();
    	String jsonStr = JSONArray.toJSONString(lists);
    	return jsonStr;
    }
    
    @RequestMapping(value = "orderlist",method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String userList(@RequestBody Map<String,String> map) {
    	List<Map<String, String>> lists = this.userService.getAllOrder();
    	String jsonStr = JSONArray.toJSONString(lists);
    	return jsonStr;
    }
}