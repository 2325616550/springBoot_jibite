package com.jmu.javaweb_jibite.dao;

import com.jmu.javaweb_jibite.domain.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ShaoJ
 * Date: 2020/10/30
 * Time: 23:12
 */
@Mapper
@Repository
public interface BookDao {
    @Insert("insert into book(`name`,`author`,`price`,`sales`,`stock`,`imgpath`) values(#{name},#{author},#{price},#{sales},#{stock},#{imgpath})")
    public int addBook(Book book);

    @Delete("delete from book where id = #{id}")
    public int deleteBookById(Integer id);

    @Update("update book set `name`=#{name},`author`=#{author},`price`=#{price},`sales`=#{sales},`stock`=#{stock},`imgpath`=#{imgpath} where id = #{id}")
    public int updateBook(Book book);

    @Select("select `id` , `name` , `author` , `price` , `sales` , `stock` , `imgpath` imgPath from book where id =#{id}")
    public Book queryBookById(Integer id);

    @Select("select * from book")
    public List<Book> queryBooks();

    @Select("select * from book limit #{begin},#{pageSize}")
    public List<Book> queryForPageItems(int begin, int pageSize);
}
