package com.example.demo.Controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.Service.HomeService;
import com.example.demo.entity.Glxt_Books;
import com.example.tool.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @PostMapping("/tslb")
    public R Tslb() throws Exception {
        Map<String,Object> map = new HashMap<>();
        List<Glxt_Books> books = new ArrayList<>();
        books = homeService.getBooks();
        map.put("code",1);
        map.put("msg","加载成功");
        map.put("data",books);
        return R.ok(map);
    }



    @PostMapping("/addbook1")
    public R Xzsj(@RequestBody Glxt_Books book) throws Exception {
        boolean flage =false;
        Map<String,Object> map = new HashMap<>();
        map.put("author",book.getAuthor());
        map.put("bookname",book.getBookname());
        map.put("bookprice",book.getBookprice());
        map.put("press",book.getPress());
        map.put("serialnumber",book.getSerialnumber());

        flage = homeService.addbook(map);
        return  flage ? R.ok("新增成功！") : R.error(1,"新增失败请联系管理员");
    }


    @GetMapping("/removebook")
    public R removebook(String id) throws Exception {
        boolean flage;
        flage = homeService.removebook(id);
        return  flage ? R.ok("删除成功！") : R.error(1,"删除失败请联系管理员");
    }

    @GetMapping("/selectbook")
    public R selectbook(String bookname) throws Exception {

        List<Glxt_Books> list = homeService.selectbook(bookname);
        Map<String,Object> map = new HashMap<>();
        map.put("code",1);
        map.put("msg","加载成功");
        map.put("data",list);
        return R.ok(map);
    }

}
