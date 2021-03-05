package com.ql.qlsql.mybatis.dao;

import com.github.pagehelper.PageInfo;
import com.ql.qlsql.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
@Repository
public interface UserDao {

    PageInfo<User> findAll();

    User login(@Param("userName") String name, @Param("password") String password);

    void save(User user);
}
