package com.yc.dao;

import com.yc.bean.Resfood;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: IResfoodDao
 * @Author: coder-oyz
 * @Date: 2021/4/29 19:07
 */
@Repository
public interface IResfoodDao extends JpaRepository<Resfood,Integer> {

}
