package com.example.demo.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Service.LoginService;
import com.example.demo.entity.Glxt_User;
import com.example.demo.dao.LoginMapper;
import com.example.tool.R;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        boolean flage = false;
        System.out.println("正在验证登录密码");
        Map<String,Object> map = loginMapper.getPassword(username);
        if (map.get("isdisable") == Integer.valueOf(0)){
            if (password.equals(map.get("password"))){
                flage = true;
            }else {
                flage = false;
            }
        }else {
        }
        return flage;

    }


    @Override
    public boolean saveuser(String username,String password,String phone,String email) throws Exception {
        boolean flage = false;
        int num = loginMapper.getusercount(username);
        if (num > 0) {
            flage = false;
        } else {
            flage = loginMapper.saveuser(username, password, phone, email);
        }
        return flage;
    }

    @Override
    public boolean updatapassword(String username, String password) {
        boolean flage = false;
        int num = loginMapper.getusercount(username);
        if (num == 1) {
            flage = loginMapper.updatapassword(username, password);
        } else {
            flage = false;
        }
        return flage;
    }
}
