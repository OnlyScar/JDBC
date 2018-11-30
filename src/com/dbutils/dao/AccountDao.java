package com.dbutils.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.dbutils.domain.Account;

public class AccountDao {
	
	 //����service�㴫�ݹ�����Connection����
    private Connection conn = null;
    
    public AccountDao(Connection conn){
        this.conn = conn;
    }
    
    public AccountDao(){
        
    }
    
    /**
    * @Method: update
    * @Description:����
    * @Anthor:�°�����
    *
    * @param account
    * @throws SQLException
    */ 
    public void update(Account account) throws SQLException{
        
        QueryRunner qr = new QueryRunner();
        String sql = "update account set name=?,money=? where id=?";
        Object params[] = {account.getName(),account.getMoney(),account.getId()};
        //ʹ��service�㴫�ݹ�����Connection����������ݿ�
        qr.update(conn,sql, params);
        
    }
    
    /**
    * @Method: find
    * @Description:����
    * @Anthor:�°�����
    *
    * @param id
    * @return
    * @throws SQLException
    */ 
    public Account find(int id) throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "select * from account where id=?";
        //ʹ��service�㴫�ݹ�����Connection����������ݿ�
        return (Account) qr.query(conn,sql, id, new BeanHandler(Account.class));
    }
	
	
}
