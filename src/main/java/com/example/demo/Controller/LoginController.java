package com.example.demo.Controller;

import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.example.demo.Service.LoginService;
import com.example.demo.entity.User1;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.netty.util.internal.StringUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class LoginController {

    @Resource
    LoginService loginService;
    @GetMapping("/test")
    public JSONPObject test() {
        List<User1> list = new ArrayList<>();

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
    public boolean Zc(String username,String password,String nikename,String age,String address,String sex){
        return loginService.saveuser(username,password,nikename,age,sex,address);
    }
}
