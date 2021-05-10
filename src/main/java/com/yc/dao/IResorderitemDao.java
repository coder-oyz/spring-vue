package com.yc.dao;

import com.yc.bean.Resorderitem;
import com.yc.bean.Resuser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName: IResorderitemDao
 * @Author: coder-oyz
 * @Date: 2021/5/4 19:11
 */
public interface IResorderitemDao extends JpaRepository<Resorderitem,Integer> {
}
