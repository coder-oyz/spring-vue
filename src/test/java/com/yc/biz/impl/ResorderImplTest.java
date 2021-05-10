package com.yc.biz.impl;

import com.yc.bean.CartItem;
import com.yc.bean.OrderStatusEnum;
import com.yc.bean.Resorder;
import com.yc.biz.ResfoodBiz;
import com.yc.biz.ResorderBiz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName: ResorderImplTest
 * @Author: coder-oyz
 * @Date: 2021/5/4 19:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResorderImplTest {

    @Autowired
    private ResorderBiz orderBiz;

    @Autowired
    private ResfoodBiz foodBiz;

    @Test
    public void completeOrder() {
        Resorder o = new Resorder();
        o.setUserid(1);
        o.setStatus(OrderStatusEnum.NEW.getCode());
        o.setTel("135455566");
        o.setPs("加急");
        o.setAddress("傻子冲冲冲");
        o.setOrdertime(new Timestamp(new Date().getTime()));

        //购物车
        Map<Integer, CartItem> cart = new HashMap<>();
        Integer fid1 =11;
        CartItem ci1= new CartItem();
        ci1.setFood(foodBiz.findByFid(fid1));
        ci1.setNum(1);

        Integer fid2 =10;
        CartItem ci2= new CartItem();
        ci2.setFood(foodBiz.findByFid(fid2));
        ci2.setNum(1);

        cart.put(fid1,ci1);
        cart.put(fid2,ci2);
        orderBiz.completeOrder(o,cart);
    }
}