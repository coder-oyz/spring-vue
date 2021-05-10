package com.yc.biz.impl;

import com.yc.bean.CartItem;
import com.yc.bean.OrderStatusEnum;
import com.yc.bean.Resorder;
import com.yc.bean.Resorderitem;
import com.yc.biz.ResorderBiz;
import com.yc.dao.IResorderDao;
import com.yc.dao.IResorderitemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName: ResorderImpl
 * @Author: coder-oyz
 * @Date: 2021/5/4 18:53
 */
@Component
public class ResorderImpl implements ResorderBiz {

    @Autowired
    private IResorderitemDao itemDao;

    @Autowired
    private IResorderDao orderDao;

    @Override
    @Transactional
    public Integer completeOrder(Resorder resorder, Map<Integer, CartItem> shopCart) {
        resorder.setStatus(OrderStatusEnum.NEW.getCode());
        resorder.setOrdertime(new Timestamp(System.currentTimeMillis()));
        resorder.getDeliveryTime();
        Resorder orderResult = orderDao.save(resorder);
        if(shopCart!=null && shopCart.size()>0){
            for(Map.Entry<Integer,CartItem> entry: shopCart.entrySet()){
                System.out.println(entry.getValue());
                Resorderitem ri = new Resorderitem();
                ri.setRoid(orderResult.getRoid());
                ri.setNum(entry.getValue().getNum());
                ri.setFid(entry.getKey());
                ri.setDealprice(entry.getValue().getFood().getRealprice());
                itemDao.save(ri);
            }
        }
        return orderResult.getRoid();
    }
}
