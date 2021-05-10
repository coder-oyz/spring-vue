package com.yc.dao;

import com.yc.bean.Resfood;
import jdk.nashorn.internal.runtime.options.Option;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName: IResfoodDaoTest
 * @Author: coder-oyz
 * @Date: 2021/4/29 20:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IResfoodDaoTest {

    @Autowired(required = false)
    private IResfoodDao iResfoodDao;



    @Test
    public void getAllFood() {
        List<Resfood> foods = iResfoodDao.findAll();
        System.out.println(foods);
    }

    @Test
    public void findResfoodById() {
        Resfood food = new Resfood();
        food.setFid(11);
        Example<Resfood> example = Example.of(food);
        Optional<Resfood> opt = iResfoodDao.findOne(example);
        //使用Optional处理查不到数据的情况
        /*opt.orElseGet(new Supplier<Resfood>() {
            @Override
            public Resfood get() {
                return new Resfood();
            }
        })*/
        Assert.assertNotNull(opt.get());
    }

    
}