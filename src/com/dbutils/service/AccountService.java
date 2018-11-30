package com.dbutils.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.dbutils.dao.AccountDao;
import com.dbutils.domain.Account;
import com.dbutils.util.JdbcUtils;

public class AccountService {
	 /**
	    * @Method: transfer
	    * @Description:����������������������û�֮���ת��ҵ��
	    * @Anthor:�°�����
	    * @param sourceid
	    * @param tartgetid
	    * @param money
	    * @throws SQLException
	    */ 
	    public void transfer(int sourceid,int tartgetid,float money) throws SQLException{
	        Connection conn = null;
	        try{
	            //��ȡ���ݿ�����
	            conn = JdbcUtils.getConnection();
	            //��������
	            conn.setAutoCommit(false);
	            //����ȡ����Connection���ݸ�AccountDao����֤dao��ʹ�õ���ͬһ��Connection����������ݿ�
	            AccountDao dao = new AccountDao(conn);
	            Account source = dao.find(sourceid);
	            Account target = dao.find(tartgetid);
	            
	            source.setMoney(source.getMoney()-money);
	            target.setMoney(target.getMoney()+money);
	            
	            dao.update(source);
	            //ģ���������쳣������ع�
	            int x = 1/0;
	            dao.update(target);
	            //�ύ����
	            conn.commit();
	        }catch (Exception e) {
	            e.printStackTrace();
	            //�����쳣֮��ͻع�����
	            conn.rollback();
	        }finally{
	            conn.close();
	        }
	    }
}
