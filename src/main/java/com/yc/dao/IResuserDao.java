package com.yc.dao;

import com.yc.bean.Resfood;
import com.yc.bean.Resuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @ClassName: IResuserDao
 * @Author: coder-oyz
 * @Date: 2021/4/29 19:10
 */
public interface IResuserDao extends JpaRepository<Resuser,Integer> {

}
