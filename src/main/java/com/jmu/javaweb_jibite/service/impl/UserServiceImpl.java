package com.jmu.javaweb_jibite.service.impl;

import com.jmu.javaweb_jibite.dao.UserDao;
import com.jmu.javaweb_jibite.domain.User;
import com.jmu.javaweb_jibite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ShaoJ
 * Date: 2020/10/28
 * Time: 18:38
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean isUser(String name, String password) {
       return userDao.isUser(name,password)!=null;
    }

    @Override
    public boolean checkName(String name) {
        return userDao.checkName(name)==null;
    }

    @Override
    @Transactional
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User getUser(String name) {
        return userDao.getUser(name);
    }
}
