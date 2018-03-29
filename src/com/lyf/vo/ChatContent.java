package com.lyf.vo;


import java.sql.Timestamp;

/**
 * Created by fangjiejie on 2017/11/17.
 */
public class ChatContent {
    private int cid;
    private String content;
    private int tid;//房间类型
    private int uid;//发表用户
    private String uname;
    private Timestamp date;
    public ChatContent() {
    }

    public ChatContent(int cid, String content, int tid, int uid,String uname,Timestamp date) {
        this.cid = cid;
        this.content = content;
        this.tid = tid;
        this.uid = uid;
        this.uname = uname;
        this.date=date;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {return uname;}

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Timestamp getDate() {return date;}

    public void setDate(Timestamp date) {this.date = date;}
}
