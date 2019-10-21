package com.dongjiawei.tree_hold.service;

import com.dongjiawei.tree_hold.entity.Book;

import java.util.List;

public interface BookSerivce {

    List<Book> needScrapyBook();

    void updateStatus(String s);
}
