package com.example.demo.Controller;


import com.alibaba.fastjson.JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.Service.HomeService;
import com.example.demo.entity.GlxtBooks;
import com.example.tool.PageST;
import com.example.tool.R;
import com.example.tool.ResultMsg;
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
        List<GlxtBooks> books = new ArrayList<>();
        books = homeService.getBooks();
        map.put("code",1);
        map.put("msg","加载成功");
        map.put("data",books);
        return R.ok(map);
    }


    @PostMapping("/tslb1")
    public ResultMsg Tslb1(@RequestBody PageST jsonObject) throws Exception {

        Page<GlxtBooks> page = homeService.getBooks1(jsonObject);

        return new ResultMsg(200,page,"查询成功");
    }







    @PostMapping("/addbook1")
    public R Xzsj(@RequestBody GlxtBooks book) throws Exception {
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

        List<GlxtBooks> list = homeService.selectbook(bookname);
        Map<String,Object> map = new HashMap<>();
        map.put("code",1);
        map.put("msg","加载成功");
        map.put("data",list);
        return R.ok(map);
    }


    @PostMapping("/selectbook1")
    public ResultMsg selectbook1(@RequestBody PageST jsonObject) throws Exception {
        Page<GlxtBooks> page = homeService.selectbook1(jsonObject);


        return new ResultMsg(200,page,"查询成功");
    }

}
