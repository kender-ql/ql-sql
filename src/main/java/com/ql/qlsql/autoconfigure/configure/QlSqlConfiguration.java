package com.ql.qlsql.autoconfigure.configure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/12/4 15:13
 */
@Configuration
@ComponentScan(basePackages = {
        "com.ql.qlsql.controller",
        "com.ql.qlsql.service"
})
@MapperScan(basePackages = {
        "com.ql.qlsql.mybatis.dao"
})
@EnableJpaRepositories(basePackages = {
        "com.ql.qlsql.jpa.daoa"
})
@EntityScan(basePackages = {
        "com.ql.qlsql.jpa.entity"
})
public class QlSqlConfiguration {

}
