package com.example.demo.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Service.LoginService;
import com.example.demo.entity.Glxt_User;
import com.example.demo.dao.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LoginServiceImpl extends ServiceImpl<LoginMapper, Glxt_User> implements LoginService {

    @Autowired(required = false)
    LoginMapper loginMapper;
    @Override
    public List<Glxt_User> grouser1() {
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
    public boolean saveuser(String username,String password,String phone,String email) throws Exception {
        boolean flage = false;
        int num = loginMapper.getusercount(username);
        if (num > 0){
            throw new Exception("这里有个错误异常");
        }else {
            flage = loginMapper.saveuser(username, password, phone, email);
            return flage;
        }
    }
}
