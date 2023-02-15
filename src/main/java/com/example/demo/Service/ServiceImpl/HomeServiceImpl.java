package com.example.demo.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Service.HomeService;
import com.example.demo.dao.HomeMapper;
import com.example.demo.entity.Glxt_Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl extends ServiceImpl<HomeMapper, Glxt_Books> implements HomeService {

@Autowired(required = false)
HomeMapper homeMapper;
    @Override
    public List<Glxt_Books> getBooks() {
        return homeMapper.getBooks();
    }
}
