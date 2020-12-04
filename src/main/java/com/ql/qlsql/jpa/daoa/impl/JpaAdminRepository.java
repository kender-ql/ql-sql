package com.ql.qlsql.jpa.daoa.impl;

import com.ql.qlsql.jpa.daoa.AdminRepository;
import com.ql.qlsql.jpa.entity.Admin;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

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
