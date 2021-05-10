package com.yc.controller;

import com.yc.bean.Resuser;
import com.yc.biz.ResUserBiz;
import com.yc.biz.ResorderBiz;
import com.yc.vo.JsonModel;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static com.yc.utils.YcConstants.*;

/**
 * @ClassName: ResuserController
 * @Author: coder-oyz
 * @Date: 2021/5/4 20:51
 */
@RestController
@Slf4j
@Api(description = "用户系统")
public class ResuserController {
    @Autowired
    private ResUserBiz userBiz;

    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public JsonModel loginOp(HttpSession session,JsonModel jm,String valcode,String username,String pwd){
        if(valcode==null || "".equals(valcode)){
            jm.setCode(0);
            jm.setMsg("验证码不能为空");
            return jm;
        }
        String validateCode = (String) session.getAttribute("validateCode");
        if(!valcode.equalsIgnoreCase(validateCode)){//不相等
            jm.setCode(0);
            jm.setMsg("验证码输入错误");
            return jm;
        }

        Resuser u = new Resuser();
        u.setUsername(username);
        u.setPwd(pwd);
        Resuser users = userBiz.login(u);
        if(users!=null){
            session.setAttribute(LOGINUSER,users);
            jm.setCode(1);
            //再看地址判断
            if(session.getAttribute(LASTVISITEDADDR)!=null){
                jm.setUrl((String) session.getAttribute(LASTVISITEDADDR));
            }else {
                jm.setUrl(HOMEPAGE); //没有历史页面，进入首页
            }

        }else {
            jm.setCode(0);
            jm.setMsg("错误的名字或密码");
        }
        return jm;
    }

    @RequestMapping(value = "/logout",method = {RequestMethod.GET,RequestMethod.POST})
    public JsonModel logout(JsonModel jm, HttpSession session){
        session.removeAttribute(LOGINUSER);
        jm.setCode(1);
        return jm;
    }

    @RequestMapping(value = "/checkLogin",method = {RequestMethod.GET,RequestMethod.POST})
    public JsonModel checkLogin(JsonModel jm,HttpSession session){
        if(session.getAttribute(LOGINUSER)==null){
            jm.setCode(0);
            jm.setMsg("用户没有登录");
        }else {
            jm.setCode(1);
            Resuser user = (Resuser) session.getAttribute(LOGINUSER);
            jm.setObj(user);
        }
        return jm;
    }
}
