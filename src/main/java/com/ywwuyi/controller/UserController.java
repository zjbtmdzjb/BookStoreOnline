package com.ywwuyi.controller;

import java.util.HashMap;
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
import com.ywwuyi.domain.*;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
    private IUserService userService;
    
    @RequestMapping(value = "showUser",method = RequestMethod.GET)
    @ResponseBody
    public Admin toIndex(HttpSession httpSession) {
    	String adminname = "sha";
        Admin admin = this.userService.getAdminByAdminname(adminname);
        return admin;
    }
    
    @RequestMapping(value = "userlogin.action",method = RequestMethod.POST)
    @ResponseBody
    public User login(@RequestBody Map<String,String> map) {
    	String username = map.get("username");
    	String password = map.get("password");
    	User user = this.userService.userLogin(username, password);
    	return user;
    }
    
    @RequestMapping(value = "userregister.action", method = RequestMethod.POST)
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
}