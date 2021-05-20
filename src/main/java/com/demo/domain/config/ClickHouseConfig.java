package com.demo.domain.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.settings.ClickHouseProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuxiansong
 * @desc 普通连接-测试
 */
@Component
public class ClickHouseConfig {
    private static String clickHouseAddress;

    private static String clickHouseUsername;

    private static String clickHousePassword;

    private static String clickHouseDB;

    private static Integer clickHouseSocketTimeout;

    @Value("${spring.oneself-custom.clickhouse.address}")
    public void setClickhouseAddress(String address) {
        ClickHouseConfig.clickHouseAddress = address;
    }

    @Value("${spring.oneself-custom.clickhouse.username}")
    public void setClickhouseUsername(String username) {
        ClickHouseConfig.clickHouseUsername = username;
    }

    @Value("${spring.oneself-custom.clickhouse.password}")
    public void setClickhousePassword(String password) {
        ClickHouseConfig.clickHousePassword = password;
    }

    @Value("${spring.oneself-custom.clickhouse.db}")
    public void setClickhouseDB(String db) {
        ClickHouseConfig.clickHouseDB = db;
    }

    @Value("${spring.oneself-custom.clickhouse.socketTimeout}")
    public void setClickhouseSocketTimeout(Integer socketTimeout) {
        ClickHouseConfig.clickHouseSocketTimeout = socketTimeout;
    }

    public static Connection getConn() {
        ClickHouseConnection conn = null;
        ClickHouseProperties properties = new ClickHouseProperties();
        properties.setUser(clickHouseUsername);
        properties.setPassword(clickHousePassword);
        properties.setDatabase(clickHouseDB);
        properties.setSocketTimeout(clickHouseSocketTimeout);
        ClickHouseDataSource clickHouseDataSource = new ClickHouseDataSource(clickHouseAddress, properties);
        try {
            conn = clickHouseDataSource.getConnection();
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Map<String, String>> exeSql(String sql) {
        System.out.println("cliockhouse 执行sql：" + sql);
        Connection connection = getConn();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            ResultSetMetaData rsmd = results.getMetaData();
            List<Map<String, String>> list = new ArrayList<>();
            while (results.next()) {
                Map<String, String> row = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.put(rsmd.getColumnName(i), results.getString(rsmd.getColumnName(i)));
                }
                list.add(row);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
