package com.example.demo.Controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.Service.HomeService;
import com.example.demo.entity.Glxt_Books;
import com.example.tool.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
