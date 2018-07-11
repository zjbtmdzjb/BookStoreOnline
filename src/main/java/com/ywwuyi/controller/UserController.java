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
    public User toIndex(HttpSession httpSession) {
        User user = this.userService.getUserById(1);
        return user;
    }
    
    @RequestMapping(value = "hello", method = RequestMethod.GET) 
    @ResponseBody // 要返回json数据
    public Map<String, Object> login(HttpSession httpSession) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
          map.put("errorCode", 0);
          map.put("message", "hello world");
        } catch (Exception e) {
            map.put("errorCode", 1);
            map.put("errorMessage", "未知错误");
        }
        return map;
    }
}