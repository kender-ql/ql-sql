package com.ql.qlsql.service;


import com.ql.qlsql.jpa.entity.Admin;

import java.util.Map;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/12/4 16:05
 */
public interface JpaService extends BaseService{
    /**
     * 管理员登录
     * @param params 账号密码
     * @return 用户信息
     */
    Admin login(Map<String, Object> params);
}
