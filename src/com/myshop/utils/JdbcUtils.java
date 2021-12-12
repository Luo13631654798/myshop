package com.myshop.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DruidDataSource datasource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
    static {

        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            datasource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            System.out.println(datasource.getConnection());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = conns.get();
        if (conn == null) {
            try {
                conn = datasource.getConnection();
                conns.set(conn);
                conn.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return conn;
    }
//        Connection conn = null;
//        try {
//            conn = datasource.getConnection();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//    public static void close(Connection conn){
//        if(conn!=null){
//            try {
//                conn.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//    }
    public static void commitAndClose(){
        Connection connection = conns.get();
        if (connection!=null){
            try {
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();
    }
    public static void rollbackAndClose(){
        Connection connection = conns.get();
        if (connection!=null){
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();
    }

        public static void main(String[] args) {

    }
}
