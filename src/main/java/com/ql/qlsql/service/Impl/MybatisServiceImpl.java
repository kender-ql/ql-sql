package com.ql.qlsql.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.ql.qlsql.mybatis.dao.UserDao;
import com.ql.qlsql.mybatis.entity.User;
import com.ql.qlsql.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
@Service
public class MybatisServiceImpl implements MybatisService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(JSONObject params) {
        Object name = params.get("username");
        Object password = params.get("password");
        if (name != null&& password != null) {
            return userDao.login(name.toString(), password.toString());
        }
        return null;
    }
}
