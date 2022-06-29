package cn.edu.guet.service.impl;

import cn.edu.guet.service.INewsService;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements INewsService {
    @Override
    public void test() {
        System.out.println("testtestest");
    }
}
