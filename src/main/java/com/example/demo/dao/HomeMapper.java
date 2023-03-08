package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Glxt_Books;
import com.example.demo.entity.Glxt_User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface HomeMapper extends BaseMapper<Glxt_Books> {

    List<Glxt_Books> getBooks();

    boolean addbook(Map<String,Object> map);

    boolean removebook(@Param("id") String id);

    List<Glxt_Books> selectbook(@Param("bookname")String bookname);
}
