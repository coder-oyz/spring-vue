package com.yc.dao;

import com.yc.bean.Resfood;
import com.yc.bean.Resorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @ClassName: IResorderDao
 * @Author: coder-oyz
 * @Date: 2021/4/29 19:08
 */
public interface IResorderDao extends JpaRepository<Resorder,Integer> {
}
