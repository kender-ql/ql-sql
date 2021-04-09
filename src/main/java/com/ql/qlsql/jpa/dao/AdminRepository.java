package com.ql.qlsql.jpa.dao;

import com.ql.qlsql.jpa.entity.Admin;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/4/12 20:07
 * @Description:
 */
@Repository
public interface AdminRepository extends PagingAndSortingRepository<Admin, Integer> {
    /**
     * 管理员登陆
     *
     * @param username 用户名
     * @param password 密码
     * @return 管理员信息
     */
    public Admin getAdminByUserNameAndAndPassword(String username, String password);

}
