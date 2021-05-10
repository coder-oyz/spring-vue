package com.yc.biz.impl;

import com.yc.bean.Resfood;
import com.yc.biz.ResfoodBiz;
import com.yc.dao.IResfoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: ResfoodImpl
 * @Author: coder-oyz
 * @Date: 2021/5/4 18:52
 */
@Component
public class ResfoodImpl implements ResfoodBiz {

    @Autowired
    private IResfoodDao iResfoodDao;

    @Override
    public List<Resfood> findAll() {
        List<Resfood> list = iResfoodDao.findAll();
        return list;
    }

    @Override
    public Resfood findByFid(Integer fid) {
        Resfood food = iResfoodDao.findById(fid).get();
        return food;
    }
}
