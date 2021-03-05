package com.ql.qlsql.api;

import com.ql.qlsql.jpa.dao.AdminRepository;
import com.ql.qlsql.jpa.entity.Admin;
import com.ql.qlsql.mybatis.dao.UserDao;
import com.ql.qlsql.mybatis.entity.User;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/**
 * 数据生成初始化数据
 * 1. 注解@Order或者接口Ordered的作用是定义Spring IOC容器中Bean的执行顺序的优先级
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/12/8 15:25
 */
@Component
//@Order(2)
public class QlSqlApplicationRunner implements QlBaseDataInit, ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(QlSqlApplicationRunner.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private AdminRepository adminRepository;

    private final DataSource dataSource = (DataSource) SpringContext.getBean("dataSource");

    @Override
    public void run(ApplicationArguments args) throws Exception {
        runSqlByScriptRunner(DATA_FILE_NAME);
//        initUserData("user", "123456");
//        initAdminData("admin", "123456");
    }

    private void initUserData(String userName, String password) {
        User user = new User(userName, password);
        userDao.save(user);
    }

    private void initAdminData(String userName, String password) {
        Admin admin = new Admin(userName, password);
        adminRepository.save(admin);
    }

    /**
     * 执行sql脚本文件 使用ScriptRunner
     *
     * @param path SQL文件的路径：如：D:/TestProject/web/sql/脚本.Sql
     */
    public void runSqlByScriptRunner(String path) throws Exception {
        Resource[] resources;
        Connection connection;
        Statement statement;
        try {
            ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(null);
            resources = resolver.getResources(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + path);
            if (resources.length == 0) {
                return;
            }
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            for (Resource resource : resources) {
                addBatch(IOUtils.toString(resource.getInputStream(), "UTF-8"), statement);
                statement.executeBatch();
                statement.clearBatch();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void addBatch(String allSql, Statement statement) {

    }

}
