package com.dbutils.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.dbutils.domain.Account;

public class AccountDao {
	
	 //接收service层传递过来的Connection对象
    private Connection conn = null;
    
    public AccountDao(Connection conn){
        this.conn = conn;
    }
    
    public AccountDao(){
        
    }
    
    /**
    * @Method: update
    * @Description:更新
    * @Anthor:孤傲苍狼
    *
    * @param account
    * @throws SQLException
    */ 
    public void update(Account account) throws SQLException{
        
        QueryRunner qr = new QueryRunner();
        String sql = "update account set name=?,money=? where id=?";
        Object params[] = {account.getName(),account.getMoney(),account.getId()};
        //使用service层传递过来的Connection对象操作数据库
        qr.update(conn,sql, params);
        
    }
    
    /**
    * @Method: find
    * @Description:查找
    * @Anthor:孤傲苍狼
    *
    * @param id
    * @return
    * @throws SQLException
    */ 
    public Account find(int id) throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "select * from account where id=?";
        //使用service层传递过来的Connection对象操作数据库
        return (Account) qr.query(conn,sql, id, new BeanHandler(Account.class));
    }
	
	
}
