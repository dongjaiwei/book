package com.dongjiawei.tree_hold.service;

import com.dongjiawei.tree_hold.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("SELECT * FROM book_detail where status = 0 limit 2")
    List<Book> needScrapyBook();

    @Update("update book_detail set status = 1 where id = #{bookID}")
    void update(String bookID);
}
