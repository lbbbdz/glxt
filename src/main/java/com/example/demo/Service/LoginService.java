package com.example.demo.Service;

import com.example.demo.entity.Glxt_User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface LoginService extends IService<Glxt_User> {

    public List<Glxt_User> grouser1();

    boolean getflage(String username,String password);

    boolean saveuser(String username,String password,String phone,String email) throws Exception;

    boolean updatapassword(String username,String password);



}
