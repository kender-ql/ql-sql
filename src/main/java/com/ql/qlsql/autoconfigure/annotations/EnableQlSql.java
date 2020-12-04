package com.ql.qlsql.autoconfigure.annotations;

import com.ql.qlsql.autoconfigure.configure.QlSqlConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/12/4 16:36
 */

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
@Import({QlSqlConfiguration.class})
public @interface EnableQlSql {
}
