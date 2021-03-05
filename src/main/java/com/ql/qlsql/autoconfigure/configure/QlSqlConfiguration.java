package com.ql.qlsql.autoconfigure.configure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/12/4 15:13
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {
        "com.ql.qlsql.controller",
        "com.ql.qlsql.service",
        "com.ql.qlsql.api"
})
@MapperScan(basePackages = {
        "com.ql.qlsql.mybatis.dao"
})
@EnableJpaRepositories(basePackages = {
        "com.ql.qlsql.jpa.dao"
})
@EntityScan(basePackages = {
        "com.ql.qlsql.jpa.entity"
})
public class QlSqlConfiguration {
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
