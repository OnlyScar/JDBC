package com.dbutils.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.dbutils.db.ConnectionFactory;
import com.mysql.jdbc.DatabaseMetaData;

public class TestDataBaseMetaData {
	@Test
    public void testDataBaseMetaData() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        DatabaseMetaData metadata = (DatabaseMetaData) conn.getMetaData();
        //getURL()：返回一个String类对象，代表数据库的URL
        System.out.println(metadata.getURL());
        //getUserName()：返回连接当前数据库管理系统的用户名
        System.out.println(metadata.getUserName());
        //getDatabaseProductName()：返回数据库的产品名称
        System.out.println(metadata.getDatabaseProductName());
        //getDatabaseProductVersion()：返回数据库的版本号
        System.out.println(metadata.getDatabaseProductVersion());
        //getDriverName()：返回驱动驱动程序的名称
        System.out.println(metadata.getDriverName());
        //getDriverVersion()：返回驱动程序的版本号
        System.out.println(metadata.getDriverVersion());
        //isReadOnly()：返回一个boolean值，指示数据库是否只允许读操作
        System.out.println(metadata.isReadOnly());
        ConnectionFactory.closeConnection();
    }
}
