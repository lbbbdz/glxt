package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginMapper  extends BaseMapper<User1> {

    public List<User1> getter1();

    String getPassword(@Param("username") String username);

    boolean saveuser(@Param("username")String username,@Param("password")String password,@Param("nikename")String nikename,@Param("age") String age,@Param("sex") String sex,@Param("address") String address);
}
