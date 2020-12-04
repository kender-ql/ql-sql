package com.ql.qlsql.service;


import com.alibaba.fastjson.JSONObject;
import com.ql.qlsql.mybatis.entity.User;

import java.util.Map;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public interface MybatisService extends BaseService{
    /**
     * 用户登录
     * @param params 账号密码
     * @return 用户信息
     */
    User login(JSONObject params);
}
