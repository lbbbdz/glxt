package com.example.demo.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.Service.LoginService;
import com.example.demo.entity.Glxt_Books;
import com.example.demo.entity.Glxt_User;
import com.example.tool.R;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.netty.util.internal.StringUtil;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        if (username.equals("") || StringUtil.isNullOrEmpty(username)){
            return R.error(1,"用户名不能为空");
        }else if (password.equals("") || StringUtil.isNullOrEmpty(password)){
            return R.error(1,"密码不能为空");
        }
        boolean flage;
        if (username.equals("")  || StringUtil.isNullOrEmpty(username) || password.equals("") || StringUtil.isNullOrEmpty(password)){
            flage = false;
        }
        flage = loginService.getflage(username,password);
        return flage ? R.ok("“登录成功") : R.error(1,"请联系管理员查看是否禁用或密码输入错误");
    }

    @GetMapping("/zc")
    public R Zc(String username, String password, String email) throws Exception {
        if (username.equals("") || StringUtil.isNullOrEmpty(username)){
            return R.error(1,"用户名不能为空");
        }else if (password.equals("") || StringUtil.isNullOrEmpty(password)){
            return R.error(1,"密码不能为空");
        }else if (email.equals("") || StringUtil.isNullOrEmpty(email)){
            return R.error(1,"邮箱不能为空");
        }
        String phone = "00000000000";
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
