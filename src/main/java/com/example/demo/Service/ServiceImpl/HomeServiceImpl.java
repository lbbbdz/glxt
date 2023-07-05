package com.example.demo.Service.ServiceImpl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Service.HomeService;
import com.example.demo.dao.HomeMapper;
import com.example.demo.entity.GlxtBooks;
import com.example.tool.PageST;
import com.sun.javafx.util.Logging;
import lombok.extern.log4j.Log4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class HomeServiceImpl extends ServiceImpl<HomeMapper, GlxtBooks> implements HomeService {

@Autowired(required = false)
HomeMapper homeMapper;
    @Override
    public List<GlxtBooks> getBooks() {
        return homeMapper.getBooks();
    }

    @Override
    public Page<GlxtBooks> getBooks1(PageST JsonObject) throws JSONException {

        Long pagenum = Long.valueOf(String.valueOf(JsonObject.getPageNum()));
        Long pagesize = Long.valueOf(String.valueOf(JsonObject.getPageSize()));

        QueryWrapper<GlxtBooks> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("serialnumber");
        Page<GlxtBooks> page = (Page<GlxtBooks>) homeMapper.selectPage(new Page<>(pagenum,pagesize),queryWrapper);
        return page;
    }


    @Override
    public boolean addbook(Map<String, Object> map) {
        return homeMapper.addbook(map);
    }

    @Override
    public boolean removebook(String id) {
        return homeMapper.removebook(id);
    }

    @Override
    public List<GlxtBooks> selectbook(String bookname) {
        return homeMapper.selectbook(bookname);
    }

    @Override
    public Page<GlxtBooks> selectbook1(PageST JsonObject) {
        Long pagenum = Long.valueOf(String.valueOf(JsonObject.getPageNum()));
        Long pagesize = Long.valueOf(String.valueOf(JsonObject.getPageSize()));
        String bookName = JsonObject.getBookName();
        QueryWrapper<GlxtBooks> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("BookName",bookName);
        queryWrapper.orderByAsc("serialnumber");
        Page<GlxtBooks> page = (Page<GlxtBooks>) homeMapper.selectPage(new Page<>(pagenum,pagesize),queryWrapper);
        System.out.print("搜索框输入:‘"+bookName+"’  查询出结果第‘"+pagenum+"’页,每页‘"+pagesize+"’条数据       ");
        System.out.println("共:‘"+page.getTotal()+"’  条数据,目前显示第‘"+page.getCurrent()+"’页,本页‘"+page.getSize()+"’条数据");
        return page;
    }
}
