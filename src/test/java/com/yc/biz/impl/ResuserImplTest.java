package com.yc.biz.impl;

import com.yc.bean.Resfood;
import com.yc.bean.Resuser;
import com.yc.biz.ResUserBiz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName: ResuserImplTest
 * @Author: coder-oyz
 * @Date: 2021/5/4 18:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResuserImplTest {

    @Autowired
    private ResUserBiz userBiz;

    @Test
    public void findResfoodById() {
        Resuser user = new Resuser();
        user.setUserid(1);

        user = userBiz.login(user);
        System.out.println(user);

    }
}