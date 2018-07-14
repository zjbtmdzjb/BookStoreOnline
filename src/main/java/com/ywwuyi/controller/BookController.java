package com.ywwuyi.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;
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
    public List<Map<String,Object>> bookList(HttpSession httpSession) {
    	return null;
    }
    
    @RequestMapping(value = "addNewbook.action")
    @ResponseBody
    public Book addNewbook(Book book, HttpServletRequest request) {
    	//保存数据库的路径  
        String sqlPath = null;   
        //定义文件保存的本地路径  
        String localPath= request.getSession().getServletContext().getRealPath("/src/main/webapp/img");
        //定义 文件名  
        String filename=null;        
        //生成uuid作为文件名称    
        String uuid = UUID.randomUUID().toString().replaceAll("-","");    
        //获得文件类型（可以判断如果不是图片，禁止上传）    
        String contentType = book.getFile().getContentType();
        //获得文件后缀名   
        String suffixName = contentType.substring(contentType.indexOf("/")+1);  
        //得到 文件名  
        filename=uuid+"."+suffixName;   
        System.out.println(filename);  
        //文件保存路径  
        try {
			book.getFile().transferTo(new File(localPath+filename));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}   
        
        //把图片的相对路径保存至数据库  
        sqlPath = "/src/main/webapp/img/"+filename;  
        System.out.println(sqlPath);
        book.setImage(sqlPath);  
 //       userService
 //       model.addAttribute("user", user);  
 //       return "MyJsp";  
        return book;
    }

}