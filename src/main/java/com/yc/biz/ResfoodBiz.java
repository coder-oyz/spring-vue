package com.yc.biz;

import com.yc.bean.Resfood;

import java.util.List;

/**
 * @ClassName: ResfoodBiz
 * @Author: coder-oyz
 * @Date: 2021/4/29 20:10
 */
public interface ResfoodBiz {
    /**
     * 查找所有的菜
     * @return
     */
    public List<Resfood>  findAll();

    /**
     * 根据fid查找
     * @param fid
     * @return
     */
    public Resfood findByFid(Integer fid);
}
