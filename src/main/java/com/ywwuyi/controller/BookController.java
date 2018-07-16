package com.ywwuyi.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
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
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ywwuyi.domain.*;

@CrossOrigin
@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
    private IUserService userService;
    
	@RequestMapping(value = "booklist",method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String  userList(HttpSession httpSession) {
    	List<Map<String,String>> lists = this.userService.getAllBook();
    	String jsonStr = JSONArray.toJSONString(lists);
    	return jsonStr;
    }
    
    @RequestMapping(value = "deleteBook.action",method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Integer delete(@RequestBody Map<String,String> map) {
    	String id = map.get("id");
    	int i = Integer.parseInt(id);
    	return this.userService.bookDelete(i);
    }
    
    @RequestMapping(value = "bookCommit.action", method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Bookcommit review(@RequestBody Map<String,String> map) {
    	String userid = map.get("userid");
    	String username = map.get("username");
    	String bookid = map.get("bookid");
    	String commitmessage = map.get("commitmessage");
    	Bookcommit regis = new Bookcommit();
    	int ui = Integer.parseInt(userid);
    	int bi = Integer.parseInt(bookid);
    	Date nowDate = new Date(System.currentTimeMillis());
    	regis.setUserid(ui);
    	regis.setUsername(username);
    	regis.setBookid(bi);
    	regis.setCommitmessage(commitmessage);
    	regis.setDate(nowDate);
    	return this.userService.bookcommitInsert(regis);
    }
    
    @RequestMapping(value = "selectBookcommit.action",produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String selectbookcommit(@RequestBody Map<String,String> map) {
    	String bookid = map.get("bookid");
    	int i = Integer.parseInt(bookid);
    	List<Map<String,String>> lists = this.userService.getBookcommitByBookId(i);
    	String jsonStr = JSONArray.toJSONString(lists);
    	return jsonStr;
    }
    
    @RequestMapping(value = "deleteBookcommit.action",method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Integer deletecommit(@RequestBody Map<String,String> map) {
    	String id = map.get("id");
    	int i = Integer.parseInt(id);
    	return this.userService.bookcommitDelete(i);
    }
    
    @RequestMapping(value = "selectBookname.action",produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String selectbookname(@RequestBody Map<String,String> map) {
    	String bookname = map.get("bookname");
    	List<Map<String,String>> lists = this.userService.getBookByBookName(bookname);
    	String jsonStr = JSONArray.toJSONString(lists);
    	return jsonStr;
    }
    
    @RequestMapping(value = "selectBooktype.action", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String selectbooktype(@RequestBody Map<String,String> map) {
    	String type = map.get("type");
    	List<Map<String,String>> lists = this.userService.getBookByBookType(type);
    	String jsonStr = JSONArray.toJSONString(lists);
    	return jsonStr;
    }
    
    @RequestMapping(value = "selectBookid.action", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String selectbookid(@RequestBody Map<String,String> map) {
    	String id = map.get("id");
    	Book book = this.userService.getBookById(Integer.parseInt(id));
    	String jsonStr = JSONObject.toJSONString(book);
    	return jsonStr;
    }
    
    @RequestMapping(value = "getIntroduce", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String getIntroduce() {
    	List<Map<String,String>> lists = this.userService.getAllIntroduce();
    	List<Book> books = new ArrayList<Book>();
    	String jsonStr = JSONArray.toJSONString(lists);
    	JSONArray jsonArray = JSON.parseArray(jsonStr);
    	//遍历方式2
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            books.add(this.userService.getBookById(Integer.parseInt(jsonObject.getString("bookid"))));
        }
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(books));
        String bookJsonStr = JSONArray.toJSONString(array);
    	return bookJsonStr;
    }
    
    @RequestMapping(value = "getRecommend", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String getRecommend() {
    	List<Map<String,String>> lists = this.userService.getAllRecommend();
    	List<Book> books = new ArrayList<Book>();
    	String jsonStr = JSONArray.toJSONString(lists);
    	JSONArray jsonArray = JSON.parseArray(jsonStr);
    	//遍历方式2
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            books.add(this.userService.getBookById(Integer.parseInt(jsonObject.getString("bookid"))));
        }
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(books));
        String bookJsonStr = JSONArray.toJSONString(array);
    	return bookJsonStr;
    }
    
    @RequestMapping(value = "addNewbook.action",produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Book addNewbook(@RequestBody Map<String,String> map) {
    	String bookname = map.get("bookname");
    	String type = map.get("type");
    	String presentation = map.get("presentation");
    	String cost = map.get("cost");
    	String image = map.get("image");
    	Book book = new Book();
    	String sql_path = "/img/"+image;
    	Date sql_date = new Date(System.currentTimeMillis());
    	book.setDate(sql_date);
    	book.setImage(sql_path);
    	book.setBookname(bookname);
    	book.setCost(Double.parseDouble(cost));
    	book.setType(type);
    	book.setPresentation(presentation);
    	this.userService.bookInsert(book);
        return book;
    }
    

    
    @RequestMapping(value = "uploadimg.action",produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String uploadImg(MultipartFile file, HttpServletRequest request) {
        //定义文件保存的本地路径  
        String localPath= request.getSession().getServletContext().getRealPath("/img/");
        //定义 文件名  
        String filename=null;        
        //生成uuid作为文件名称    
        String uuid = UUID.randomUUID().toString().replaceAll("-","");    
        //获得文件类型（可以判断如果不是图片，禁止上传）    
        String contentType = file.getContentType();
        //获得文件后缀名   
        String suffixName = contentType.substring(contentType.indexOf("/")+1);  
        //得到 文件名  
        filename=uuid+"."+suffixName;   
        //文件保存路径  
        try {
			file.transferTo(new File(localPath+filename));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}   
        
        return filename;
    }
    
    @RequestMapping(value = "order.action", method = RequestMethod.POST)
    @ResponseBody
    public Order takeOrder(@RequestBody Map<String,String> map) {
    	String cost = map.get("cost");
    	String username = map.get("username");
    	String userid = map.get("userid");
    	String bookid = map.get("bookid");
    	String bookname = map.get("bookname");
    	Order regis = new Order();
    	int ui = Integer.parseInt(userid);
    	int bi = Integer.parseInt(bookid);
    	Date sql_date = new Date(System.currentTimeMillis());
    	regis.setUserid(ui);
    	regis.setBookname(bookname);
    	regis.setBookid(bi);
    	regis.setUsername(username);
    	regis.setDate(sql_date);
    	regis.setCost(Double.parseDouble(cost));
    	return this.userService.orderInsert(regis);
    }

}