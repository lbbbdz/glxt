package com.example.demo.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Service.LoginService;
import com.example.demo.entity.User1;
import com.example.demo.dao.LoginMapper;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class LoginServiceImpl extends ServiceImpl<LoginMapper, User1> implements LoginService {

    @Autowired(required = false)
    LoginMapper loginMapper;
    @Override
    public List<User1> grouser1() {
        System.out.println("sql查询.....");
        return loginMapper.getter1();
    }

    @Override
    public boolean getflage(String username,String password) {
        System.out.println("正在验证登录密码");
        String zqpassword = loginMapper.getPassword(username);
        if (password.equals(zqpassword)){
            return true;
        }else {
            return false;
        }
    }


    @Override
    public boolean saveuser(String username,String password,String nikename,String age,String address,String sex) {
        boolean flage = false;
        flage = loginMapper.saveuser(username,password,nikename,age,sex,address);
        return flage;
    }
}
