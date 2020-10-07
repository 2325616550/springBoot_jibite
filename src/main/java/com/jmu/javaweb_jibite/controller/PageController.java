package com.jmu.javaweb_jibite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ShaoJ
 * Date: 2020/10/7
 * Time: 19:11
 */

@Controller
public class PageController {
    @RequestMapping(value = "home")
    public String home(Model model) {
        return "home";
    }
    @RequestMapping(value = "index")
    public String index(Model model) {
        return "index";
    }
    @RequestMapping(value = "about")
    public String about(Model model) {
        return "about";
    }
    @RequestMapping(value = "wait")
    public String wait(Model model) {
        return "wait";
    }
    @RequestMapping(value = "login")
    public String login(Model model) {
        return "login";
    }
    @RequestMapping(value = "regist")
    public String regist(Model model) {
        return "regist";
    }
    @RequestMapping(value = "myInfo")
    public String myinfo(Model model) {
        return "myInfo";
    }
    @RequestMapping(value = "qustionnaire")
    public String qustionnaire(Model model) {
        return "qustionnaire";
    }
}
