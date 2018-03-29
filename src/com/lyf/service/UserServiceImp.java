package com.lyf.service;

import com.lyf.dao.UserDaoImp;
import com.lyf.vo.User;


/**
 * Created by fangjiejie on 2017/11/17.
 */
public class UserServiceImp implements IUserService{
    private UserDaoImp userDaoImp;

    public UserServiceImp() {
        userDaoImp = userDaoImp=new UserDaoImp();
    }

    @Override
    public boolean register(User user) {
        return userDaoImp.register(user);
    }

    @Override
    public User login(User user) {
        return userDaoImp.login(user);
    }

    @Override
    public User queryUserById(int id) {
        return userDaoImp.queryUserById(id);
    }
}
