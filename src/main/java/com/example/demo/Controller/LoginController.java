package com.example.demo.Controller;

import com.example.demo.Service.LoginService;
import com.example.demo.entity.Glxt_User;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.netty.util.internal.StringUtil;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/test")
public class LoginController {


    @Resource
    LoginService loginService;
    @GetMapping("/test")
    public JSONPObject test() {
        List<Glxt_User> list = new ArrayList<>();

        list = loginService.grouser1();

        return new JSONPObject("list",list) ;
    }



    @GetMapping("/sign")
    public boolean Sign(String username,String password) {
        boolean flage;
        if (username.equals("")  || StringUtil.isNullOrEmpty(username) || password.equals("") || StringUtil.isNullOrEmpty(password)){
            return false;
        }

        flage = loginService.getflage(username,password);
        return flage;
    }

    @GetMapping("/zc")
    public boolean Zc(String username, String password, String phone, String email) throws Exception {

        return loginService.saveuser(username,password,phone,email) ;
    }
}
