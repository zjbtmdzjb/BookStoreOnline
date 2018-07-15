package com.ywwuyi.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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
import com.alibaba.fastjson.JSONArray;
import com.ywwuyi.domain.*;

@CrossOrigin
@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
    private IUserService userService;
    
	@RequestMapping(value = "booklist",method = RequestMethod.GET)
    @ResponseBody
    public String  userList(HttpSession httpSession) {
    	List<Map<String,String>> lists = this.userService.getAllBook();
    	String jsonStr = JSONArray.toJSONString(lists);
    	return jsonStr;
    }
    
    @RequestMapping(value = "deleteBook.action",method = RequestMethod.POST)
    @ResponseBody
    public Integer delete(@RequestBody Map<String,String> map) {
    	String id = map.get("id");
    	int i = Integer.parseInt(id);
    	return this.userService.bookDelete(i);
    }
    
    @RequestMapping(value = "Bookcommit.action", method = RequestMethod.POST)
    @ResponseBody
    public Bookcommit review(@RequestBody Map<String,String> map) {
    	String id = map.get("id");
    	String userid = map.get("userid");
    	String bookid = map.get("bookid");
    	String commitmessage = map.get("commitmessage");
    	Bookcommit regis = new Bookcommit();
    	int i = Integer.parseInt(id);
    	int ui = Integer.parseInt(userid);
    	int bi = Integer.parseInt(bookid);
    	Date nowDate = new Date();
    	regis.setId(i);
    	regis.setUserid(ui);
    	regis.setBookid(bi);
    	regis.setCommitmessage(commitmessage);
    	regis.setDate(nowDate);
    	return this.userService.bookcommitInsert(regis);
    }
    
    @RequestMapping(value = "selectBookcommit.action", method = RequestMethod.POST)
    @ResponseBody
    public Bookcommit selectbookcommit(@RequestBody Map<String,String> map) {
    	String bookid = map.get("bookid");
    	int i = Integer.parseInt(bookid);
    	return this.userService.getBookcommitByBookcommitId(i);
    }
    
    @RequestMapping(value = "deleteBookcommit.action",method = RequestMethod.POST)
    @ResponseBody
    public Integer deletecommit(@RequestBody Map<String,String> map) {
    	String id = map.get("id");
    	int i = Integer.parseInt(id);
    	return this.userService.bookcommitDelete(i);
    }
    
    @RequestMapping(value = "selectBookname.action", method = RequestMethod.POST)
    @ResponseBody
    public String selectbookname(@RequestBody Map<String,String> map) {
    	String bookname = map.get("bookname");
    	List<Map<String,String>> lists = this.userService.getBookByBookName(bookname);
    	String jsonStr = JSONArray.toJSONString(lists);
    	return jsonStr;
    }
    
    @RequestMapping(value = "selectBooktype.action", method = RequestMethod.POST)
    @ResponseBody
    public String selectbooktype(@RequestBody Map<String,String> map) {
    	String type = map.get("type");
    	List<Map<String,String>> lists = this.userService.getBookByBookType(type);
    	String jsonStr = JSONArray.toJSONString(lists);
    	return jsonStr;
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
    
    @RequestMapping(value = "showOrder",method = RequestMethod.GET)
    @ResponseBody
    public Order test(HttpSession httpSession) {
    	int bookid = 1;
        Order order = this.userService.getOrderByBookId(bookid);
        return order;
    }
    
}