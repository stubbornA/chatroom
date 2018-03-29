package com.lyf.dao;


import com.lyf.vo.User;

/**
 * Created by fangjiejie on 2017/11/17.
 */
public interface IUserDao {
    boolean register(User user);
    User login(User user);
    User queryUserById(int id);
}
