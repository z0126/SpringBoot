package com.example.springbootdata2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringBootData2ApplicationTests {

    //一开始默认，项目启动的时候便被spring管理了
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        //查看一下数据源   class com.zaxxer.hikari.HikariDataSource
        System.out.print(dataSource.getClass());

        //获取链接
        Connection connection = dataSource.getConnection();
        System.out.print(connection);

        //xxxx Template:spring boot已经配置好的模板bean,拿来即用 CRUD
        //关闭
        connection.close();
    }

}
