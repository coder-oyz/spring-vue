package com.yc.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName: CartItem
 * @Author: coder-oyz
 * @Date: 2021/5/4 18:45
 */
public class CartItem implements Serializable {
    private Resfood food;
    private int num;
    private BigDecimal smallCount;

    public Resfood getFood() {
        return food;
    }

    public void setFood(Resfood food) {
        this.food = food;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BigDecimal getSmallCount() {
        this.smallCount = food.getRealprice().multiply(new BigDecimal(num));
        return smallCount;
    }

    public void setSmallCount(BigDecimal smallCount) {
        this.smallCount = smallCount;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "food=" + food +
                ", num=" + num +
                ", smallCount=" + smallCount +
                '}';
    }
}
