package com.yc.bean;

import lombok.Getter;

/**
 * @ClassName: OrderStatusEnum
 * @Author: coder-oyz
 * @Date: 2021/5/4 19:42
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"), withdraw(1,"已完结"),CANCEL(2,"已取消");


    private  Integer code;
    private  String message;

    OrderStatusEnum(Integer code, String message) {
        this.message = message;
        this.code = code;
    }


}
