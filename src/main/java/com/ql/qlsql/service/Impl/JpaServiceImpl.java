package com.ql.qlsql.service.Impl;

import com.ql.qlsql.jpa.dao.AdminRepository;
import com.ql.qlsql.jpa.dao.impl.JpaAdminRepository;
import com.ql.qlsql.jpa.entity.Admin;
import com.ql.qlsql.service.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/12/4 16:06
 */
@Service
public class JpaServiceImpl implements JpaService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin login(Map<String, Object> params) {
        Object name = params.get("username");
        Object password = params.get("password");
        if (name != null&& password != null) {
            return adminRepository.getAdminByUserNameAndAndPassword(name.toString(), password.toString());
        }
        return null;
    }
}
