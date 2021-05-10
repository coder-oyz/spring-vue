package com.yc.biz.impl;

import com.yc.bean.Resfood;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @ClassName: ResfoodImplTest
 * @Author: coder-oyz
 * @Date: 2021/5/4 19:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResfoodImplTest {

    @Autowired
    private ResfoodImpl foodBiz;

    @Test
    public void findAll() {
        List<Resfood> foods = foodBiz.findAll();
        System.out.println(foods);
    }

    @Test
    public void findByFid() {
        Resfood food = foodBiz.findByFid(1);
        System.out.println(food);
    }
}