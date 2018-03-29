package com.lyf.service;


import com.lyf.vo.User;

/**
 * Created by fangjiejie on 2017/11/17.
 */
public interface IUserService {
    boolean register(User user);
    User login(User user);
    User queryUserById(int id);
}
