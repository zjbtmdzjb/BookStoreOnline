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
@RequestMapping("/book")
public class BookController {

	@Autowired
    private IUserService userService;
    
    @RequestMapping(value = "booklist",method = RequestMethod.GET)
    @ResponseBody
    public Book bookList(HttpSession httpSession) {
    	return null;
    }
    

}