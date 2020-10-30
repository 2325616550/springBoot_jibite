package com.jmu.javaweb_jibite.service;

import com.jmu.javaweb_jibite.domain.Book;

import java.util.List;

/**
 * Created by ShaoJ
 * Date: 2020/10/30
 * Time: 23:12
 */
public interface BookService {
    //添加书本
    public void addBook(Book book);
    //删除书本
    public void deleteBookById(Integer id);
    //更新书本
    public void updateBook(Book book);
    //通过id查询书本
    public Book queryBookById(Integer id);
    //获取所有书本
    public List<Book> queryBooks();
    //根据分页获得书本
    public List<Book> queryForPageItems(int begin, int pageSize);
}
