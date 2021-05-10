package com.yc.biz.impl;

import com.yc.bean.Resuser;
import com.yc.biz.ResUserBiz;
import com.yc.dao.IResuserDao;
import com.yc.utils.Encrypt;
import com.yc.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.expression.Operation;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpSession;

import java.util.Optional;

import static com.yc.utils.YcConstants.LOGINUSER;

/**
 * @ClassName: ResuserImpl
 * @Author: coder-oyz
 * @Date: 2021/5/4 18:53
 */
@Component
public class ResuserImpl implements ResUserBiz {

    @Autowired
    private IResuserDao iResuserDao;

    @Override
    @Transactional(readOnly = true)
    public Resuser login(Resuser user) {
        if(user==null){
            System.out.println("user对象为空，无法登录");
        }
        user.setPwd(Encrypt.md5(user.getPwd()));
        Example example = Example.of(user);
        iResuserDao.findOne(example);
        Optional op =iResuserDao.findOne(example);
        Resuser userBean = (Resuser) op.get();// iResuserDao.findById(user.getUserid()).get();
        return userBean;
    }


}
