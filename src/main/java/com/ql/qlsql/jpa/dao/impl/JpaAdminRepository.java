package com.ql.qlsql.jpa.dao.impl;

import com.ql.qlsql.jpa.dao.AdminRepository;
import com.ql.qlsql.jpa.entity.Admin;
import org.springframework.context.annotation.Profile;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/12/4 14:55
 */

@Profile({"mysql", "h2"})
public interface JpaAdminRepository extends AdminRepository {

    /**
     * 管理员登陆
     *
     * @param username 用户名
     * @param password 密码
     * @return 管理员信息
     */
    @Override
    public Admin getAdminByUserNameAndAndPassword(String username, String password);
}
