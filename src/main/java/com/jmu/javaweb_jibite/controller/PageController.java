package com.jmu.javaweb_jibite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ShaoJ
 * Date: 2020/10/7
 * Time: 19:11
 */

@Controller
public class PageController {
    @RequestMapping(value = "home")
    public String home() {
        return "home";
    }
    @RequestMapping(value = "index")
    public String index() {
        return "index";
    }
    @RequestMapping(value = "about")
    public String about() {
        return "about";
    }
    @RequestMapping(value = "wait")
    public String waithtml() {
        return "wait";
    }
    @RequestMapping(value = "login")
    public String login() {
        return "user/login";
    }
    @RequestMapping(value = "regist")
    public String regist() {
        return "user/regist";
    }
    @RequestMapping(value = "myInfo")
    public String myinfo() {
        return "myInfo";
    }
    @RequestMapping(value = "qustionnaire")
    public String qustionnaire() {
        return "qustionnaire";
    }
    @RequestMapping(value = "smallFeature")
    public String smallFeature() {
        return "smallFeature";
    }
    @RequestMapping(value = "login_success")
    public String login_success() {
        return "user/login_success";
    }
    @RequestMapping(value = "regist_success")
    public String regist_success() {
        return "user/regist_success";
    }
    @RequestMapping(value = "remind")
    public String remind() {
        return "user/remind";
    }

}
