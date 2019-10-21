package com.dongjiawei.tree_hold.service;

import com.dongjiawei.tree_hold.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookSerivce {
    @Autowired
    private BookMapper bookMapper;


    public List<Book> needScrapyBook() {
        return bookMapper.needScrapyBook();
    }

    @Override
    public void updateStatus(String s) {
        bookMapper.update(s);
    }
}
