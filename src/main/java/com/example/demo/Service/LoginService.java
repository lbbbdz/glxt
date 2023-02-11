package com.example.demo.Service;

import com.example.demo.entity.User1;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface LoginService extends IService<User1> {

    public List<User1> grouser1();

    boolean getflage(String username,String password);

    boolean saveuser(String username,String password,String nikename,String age,String address,String sex);
}
