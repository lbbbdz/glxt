package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.GlxtUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoginMapper  extends BaseMapper<GlxtUser> {

    public List<GlxtUser> getter1();

    Map<String,Object> getPassword(@Param("username") String username);

    boolean saveuser(@Param("username")String username,@Param("password")String password,@Param("phone")String phone,@Param("email") String email);

    int getusercount(@Param("username")String username);

    boolean updatapassword(@Param("username")String username,@Param("password")String password);
}
