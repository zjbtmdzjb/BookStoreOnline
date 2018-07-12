package com.ywwuyi.domain;

import java.util.Date;

public class Bookcommit {
    private Integer id;

    private Integer userid;

    private Integer bookid;

    private String commitmessage;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getCommitmessage() {
        return commitmessage;
    }

    public void setCommitmessage(String commitmessage) {
        this.commitmessage = commitmessage == null ? null : commitmessage.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}