package com.jmu.javaweb_jibite.service.impl;

import com.jmu.javaweb_jibite.dao.BookDao;
import com.jmu.javaweb_jibite.domain.Book;
import com.jmu.javaweb_jibite.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ShaoJ
 * Date: 2020/10/30
 * Time: 23:14
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
    @Override
    public List<Book> queryForPageItems(int begin, int pageSize){
       return bookDao.queryForPageItems(begin,pageSize);
    }
}
