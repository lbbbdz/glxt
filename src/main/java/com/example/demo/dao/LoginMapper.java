package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Glxt_User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginMapper  extends BaseMapper<Glxt_User> {

    public List<Glxt_User> getter1();

    String getPassword(@Param("username") String username);

    boolean saveuser(@Param("username")String username,@Param("password")String password,@Param("phone")String phone,@Param("email") String email);
}
