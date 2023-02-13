package com.example.demo.Controller;

import com.example.demo.Service.LoginService;
import com.example.demo.entity.Glxt_User;
import com.example.tool.R;
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
    public R Sign(String username,String password) {
        boolean flage;
        if (username.equals("")  || StringUtil.isNullOrEmpty(username) || password.equals("") || StringUtil.isNullOrEmpty(password)){
            flage = false;
        }
        flage = loginService.getflage(username,password);
        return flage ? R.ok("“登录成功") : R.error(1,"请联系管理员查看是否禁用或密码输入错误");
    }

    @GetMapping("/zc")
    public R Zc(String username, String password, String phone, String email) throws Exception {
        boolean flage =false;
        flage = loginService.saveuser(username,password,phone,email);
        return  flage ? R.ok("注册成功") : R.error(1,"用户名被占用");
    }

    @GetMapping("/cz")
    public R Cz(String username, String password) throws Exception {
        boolean flage =false;
        flage = loginService.updatapassword(username,password);
        return  flage ? R.ok("修改成功") : R.error(1,"请确认用户名是否存在");
    }
}
