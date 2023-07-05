package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.GlxtBooks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface HomeMapper extends BaseMapper<GlxtBooks> {

    List<GlxtBooks> getBooks();

    boolean addbook(Map<String,Object> map);

    boolean removebook(@Param("id") String id);

    List<GlxtBooks> selectbook(@Param("bookname")String bookname);

}
