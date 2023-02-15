package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Glxt_Books;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HomeService extends IService<Glxt_Books> {


    List<Glxt_Books> getBooks();
}
