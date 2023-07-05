package com.example.demo.Service;

import com.example.demo.entity.GlxtUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LoginService extends IService<GlxtUser> {

    public List<GlxtUser> grouser1();

    boolean getflage(String username,String password);

    boolean saveuser(String username,String password,String phone,String email) throws Exception;

    boolean updatapassword(String username,String password);



}
