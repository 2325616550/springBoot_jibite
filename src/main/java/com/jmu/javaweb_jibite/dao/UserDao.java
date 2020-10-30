package com.jmu.javaweb_jibite.dao;

import com.jmu.javaweb_jibite.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by ShaoJ
 * Date: 2020/10/28
 * Time: 19:47
 */
@Mapper
@Repository
public interface UserDao {
    @Select("select name from user where name=#{name} and password=#{password}")
    String isUser(String name, String password);

    @Select("select name from user where name=#{name}")
    String checkName(String name);

    @Insert("insert into user(name,email,password) values(#{name},#{email},#{password}) ")
    Integer addUser(User user);

    @Select("select * from user where name=#{name}")
    User getUser(String name);
}
