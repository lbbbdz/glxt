package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.GlxtBooks;
import com.example.tool.PageST;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface HomeService extends IService<GlxtBooks> {


    List<GlxtBooks> getBooks();

    Page<GlxtBooks> getBooks1(PageST jsonObject) throws JSONException;

    boolean addbook(Map<String,Object> map);

    boolean removebook(String id);

    List<GlxtBooks> selectbook(String bookname);

    Page<GlxtBooks> selectbook1(PageST jsonObject);
}
