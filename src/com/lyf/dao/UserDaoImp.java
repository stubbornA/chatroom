package com.lyf.dao;

import com.lyf.db.Druid;
import com.lyf.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fangjiejie on 2017/11/17.
 */
public class UserDaoImp implements IUserDao {
    private Connection connection;

    public UserDaoImp() {
        connection= Druid.getConnection();
//        connection= DB.getConnection();
    }

    @Override
    public boolean register(User user) {
        String sql="insert into user(username,password) values(?,?)";
        boolean flag=false;
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            flag=ps.executeUpdate()>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public User queryUserById(int id) {
        return null;
    }

    @Override
    public User login(User u) {
        String sql="select * from user where username=? and password=?";
        ResultSet rs;
        User user=null;
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,u.getUsername());
            ps.setString(2,u.getPassword());
            rs=ps.executeQuery();
            while (rs.next()){
                user=new User();
                user.setId(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
