package com.yc.controller;

import com.yc.bean.CartItem;
import com.yc.bean.Resfood;
import com.yc.biz.ResfoodBiz;
import com.yc.biz.ResorderBiz;
import com.yc.vo.JsonModel;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

import static com.yc.utils.YcConstants.CART;
import static com.yc.utils.YcConstants.RESFOODLIST;

/**
 * @ClassName: ResorderController
 * @Author: coder-oyz
 * @Date: 2021/5/4 20:56
 */
@RestController
@Slf4j
@Api(description = "订单系统")
public class ResorderController {
    @Autowired
    private ResorderBiz resorderBiz;

    @Autowired
    private ResfoodBiz foodBiz;

    @RequestMapping(value = "/getCartInfo", method = {RequestMethod.GET,RequestMethod.POST})
    public JsonModel getCartInfoOp(HttpServletRequest req, HttpSession session,JsonModel jm){
        List<CartItem> list = new ArrayList<>();
        if(session.getAttribute(CART)!=null){
            jm.setCode(1);
            //变更，将对象改为list，方便后面循环取值
            Map<Integer,CartItem> cart = null;
            cart = (Map<Integer, CartItem>)session.getAttribute(CART);
            Set<Integer> sets = cart.keySet();
            Iterator<Integer> iterator = sets.iterator();
            while(iterator.hasNext()){
                int x = iterator.next();
                list.add(cart.get(x));
            }

        }else {
            jm.setCode(0);
        }
        jm.setObj(list);
        return jm;
    }

    @RequestMapping(value = "delorder",method = RequestMethod.GET)
    public JsonModel delorder(JsonModel jm,HttpSession session,Resfood food){
        int fid = food.getFid();
        //购物车跟用户相关，所以存session
        Map<Integer,CartItem> cart = null;
        if(session.getAttribute(CART)!=null){
            cart = (Map<Integer,CartItem>) session.getAttribute(CART);
        }else{
            cart = new HashMap<>();
        }
        if(cart.containsKey(fid)){
            cart.remove(fid);
            jm.setCode(1);
        }else {
            jm.setCode(0);
        }
        //将cart存到session中
        session.setAttribute(CART,cart);
        return jm;
    }
    
    @RequestMapping(value = "/clearAll",method = {RequestMethod.GET,RequestMethod.POST})
    public JsonModel clearAllOp(HttpSession session,JsonModel jm){
        session.removeAttribute(CART);
        jm.setCode(1);
        return jm;
    }

    @RequestMapping(value = "/orderJson",method = {RequestMethod.GET,RequestMethod.POST})
    public JsonModel orderJsonOp(HttpServletRequest req,HttpSession session,JsonModel jm){
        commonOrder(req,session);
        jm.setCode(1);
        return jm;

    }

    private void commonOrder(HttpServletRequest req, HttpSession session) {
        ServletContext application = session.getServletContext();
        int fid = Integer.parseInt(req.getParameter("fid"));
        int num = Integer.parseInt(req.getParameter("num"));
        List<Resfood> list = null;
        if(application.getAttribute(RESFOODLIST)!=null){
            list = (List<Resfood>) application.getAttribute(RESFOODLIST);
        }else {
            //没有则查询
            list = foodBiz.findAll();
            application.setAttribute(RESFOODLIST,list);
        }
        Resfood food = null;
        for(Resfood r: list){
            if(r.getFid()==fid){
                food = r;
                break;
            }
        }
        //购物车与用户有关，存session
        Map<Integer,CartItem> cart = null;
        if(session.getAttribute(CART)!=null){
            cart = (Map<Integer, CartItem>) session.getAttribute(CART);
        }else {
            cart = new HashMap<>();
        }
        //查看这个购物车是否有fid
        CartItem ci = null;
        if(cart.containsKey(fid)){
            //证明已经购买这个商品，数量增加
            ci = cart.get(fid);
            int newnum = ci.getNum() + num;
            ci.setNum(newnum);
        }else {
            //没有买过 新建
            ci = new CartItem();
            ci.setFood(food);
            ci.setNum(num);

        }

        if(ci.getNum()<=0){
            cart.remove(fid);
        }else {
            ci.getSmallCount(); //计算小计
            //将cartitem存到map
            cart.put(fid,ci);
        }
        //cart存到session
        session.setAttribute(CART,cart);
    }

}
