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
        //getURL()������һ��String����󣬴������ݿ��URL
        System.out.println(metadata.getURL());
        //getUserName()���������ӵ�ǰ���ݿ����ϵͳ���û���
        System.out.println(metadata.getUserName());
        //getDatabaseProductName()���������ݿ�Ĳ�Ʒ����
        System.out.println(metadata.getDatabaseProductName());
        //getDatabaseProductVersion()���������ݿ�İ汾��
        System.out.println(metadata.getDatabaseProductVersion());
        //getDriverName()�����������������������
        System.out.println(metadata.getDriverName());
        //getDriverVersion()��������������İ汾��
        System.out.println(metadata.getDriverVersion());
        //isReadOnly()������һ��booleanֵ��ָʾ���ݿ��Ƿ�ֻ���������
        System.out.println(metadata.isReadOnly());
        ConnectionFactory.closeConnection();
    }
}
