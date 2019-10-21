package com.dongjiawei.tree_hold.server;


import com.dongjiawei.tree_hold.dto.MyResponse;
import com.dongjiawei.tree_hold.entity.Book;
import com.dongjiawei.tree_hold.service.BookSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableAutoConfiguration
@RequestMapping("/bookApi")
public class BookScrapy {
    @Autowired
    private BookSerivce bookSerivce;

    @RequestMapping(value = "requestBookList", method = RequestMethod.GET)
    public MyResponse<List<Book>> addMessage() {
        List<Book> books = bookSerivce.needScrapyBook();
        return new MyResponse<>(200, "添加成功", books);
    }

    @RequestMapping(value = "updateBook", method = RequestMethod.GET)
    public MyResponse<Integer> addSuccess(@RequestBody Map<String, String> json) {
        String bookID = json.get("bookID");
        String[] split = bookID.split(",");
        for (String s : split) {
            bookSerivce.updateStatus(s);
        }
        return new MyResponse<>(200, "添加成功", 1);
    }


}
