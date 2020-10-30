package com.jmu.javaweb_jibite.controller;

import com.jmu.javaweb_jibite.domain.Book;
import com.jmu.javaweb_jibite.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ShaoJ
 * Date: 2020/10/30
 * Time: 23:29
 */
@Controller
public class ShopController {
    @Autowired
    private BookServiceImpl bookService;

    @RequestMapping("/shopIndex")
    public String eachList(Model model){
        List<Book> books = bookService.queryForPageItems(0,3);
        model.addAttribute("bookList",books);
        return "shop/shopIndex";
    }
}
