package com.lyf.dao;

import com.lyf.db.Druid;
import com.lyf.vo.ChatContent;
import com.lyf.vo.ChatRoom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fangjiejie on 2017/11/17.
 */
public class ChatDaoImp implements IChatDao{
    private Connection connection;

    public ChatDaoImp() {
        connection= Druid.getConnection();
//        connection= DB.getConnection();
    }

    @Override
    public List<ChatRoom> queryAllChatRoom() {
        String sql="select * from roomtype";
        ResultSet rs=null;
        List<ChatRoom> list=new ArrayList<>();
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            ChatRoom chatRoom;
            while (rs.next()){
                chatRoom=new ChatRoom();
                chatRoom.setid(rs.getInt("tid"));
                chatRoom.setRoomname(rs.getString("roomname"));
                list.add(chatRoom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ChatContent> queryAllContentByTid(int id) {
        String sql="select * from chatcontent where tid=? order by date asc";
        ResultSet rs=null;
        List<ChatContent> list=new ArrayList<>();
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            ChatContent chatContent;
            while (rs.next()){
                chatContent=new ChatContent(rs.getInt("cid"),rs.getString("content"),rs.getInt("tid"),
                        rs.getInt("uid"),rs.getString("uname"),rs.getTimestamp("date"));
                System.out.println(chatContent.getDate());
                Timestamp now=new Timestamp(System.currentTimeMillis());
                long t=now.getTime()-chatContent.getDate().getTime();
                if(t/1000<=(long)3600*24*7) {
                    list.add(chatContent);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean addContent(ChatContent chatContent) {
        String sql="insert into chatcontent(cid,content,tid,uid,uname,date) values(?,?,?,?,?,?)";
        boolean flag=false;
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,chatContent.getCid());
            ps.setString(2,chatContent.getContent());
            ps.setInt(3,chatContent.getTid());
            ps.setInt(4,chatContent.getUid());
            ps.setString(5,chatContent.getUname());
            ps.setTimestamp(6,chatContent.getDate());
            flag=ps.executeUpdate()>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<String> queryUsersByTid(int id) {
        String sql="select distinct(uname) from chatcontent where tid=?";
        ResultSet rs=null;
        List<String> list=new ArrayList<>();
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while (rs.next()){
                list.add(rs.getString("uname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
