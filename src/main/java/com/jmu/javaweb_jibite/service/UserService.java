package com.jmu.javaweb_jibite.service;

import com.jmu.javaweb_jibite.domain.User;

/**
 * Created by ShaoJ
 * Date: 2020/10/28
 * Time: 18:37
 */

public interface UserService {
    boolean isUser(String name,String password);
    boolean checkName(String name);
    Integer addUser(User user);
    User getUser(String name);
}
