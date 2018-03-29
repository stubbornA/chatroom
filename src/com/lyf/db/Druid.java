package com.lyf.db;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by fangjiejie on 2017/4/10.
 */
public class Druid {
    private static Connection conn=null;
    private static DataSource ds=null;
    static {
        Properties pro =new Properties();
        try {
            pro.load(Druid.class.getClassLoader().getResourceAsStream("druid.ini"));
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            conn=ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
