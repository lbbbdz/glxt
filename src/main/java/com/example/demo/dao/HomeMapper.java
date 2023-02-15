package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Glxt_Books;
import com.example.demo.entity.Glxt_User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper extends BaseMapper<Glxt_Books> {

    List<Glxt_Books> getBooks();
}
