package com.yc.biz;

import com.yc.bean.CartItem;
import com.yc.bean.Resorder;

import java.util.Map;

/**
 * @ClassName: ResorderBiz
 * @Author: coder-oyz
 * @Date: 2021/5/4 18:44
 */
public interface ResorderBiz {
    /**
     * 下订单
     * @param resorder
     * @param shopCart
     */
    public Integer completeOrder(Resorder resorder, Map<Integer, CartItem> shopCart);
}
