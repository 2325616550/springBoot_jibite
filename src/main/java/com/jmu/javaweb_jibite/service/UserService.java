package com.jmu.javaweb_jibite.service;

import com.jmu.javaweb_jibite.domain.User;

/**
 * Created by ShaoJ
 * Date: 2020/10/28
 * Time: 18:37
 */

public interface UserService {
    //判断账号密码是否正确
    boolean isUser(String name,String password);
    //判断账号是否已经注册
    boolean checkName(String name);
    //注册成功后添加用户
    Integer addUser(User user);
    User getUser(String name);
}
