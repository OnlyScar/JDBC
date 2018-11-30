package com.dbutils.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.dbutils.domain.User;
import com.dbutils.util.JdbcUtils;

/**
 * @description
 * @author xiaomingHe
 * @date 2018��11��30�� ����1:40:09
 * ���Ա�
 * create table users(
           id int primary key auto_increment, 
           name varchar(40),
           password varchar(40), 
           email varchar(60), 
           birthday date 
       );
 */
public class QueryRunnerCRUDTest {
	
	 @Test
	    public void add() throws SQLException {
	        //������Դ���ݸ�QueryRunner��QueryRunner�ڲ�ͨ������Դ��ȡ���ݿ�����
	        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	        String sql = "insert into users(name,password,email,birthday) values(?,?,?,?)";
	        Object params[] = {"�°�����","123", "gacl@sina.com", new Date()};
	        //Object params[] = {"�׻����","123", "gacl@sina.com", "1988-05-07"};
	        qr.update(sql, params);
	    }
	    
	    @Test
	    public void delete() throws SQLException {

	        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	        String sql = "delete from users where id=?";
	        qr.update(sql, 1);

	    }

	    @Test
	    public void update() throws SQLException {
	        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	        String sql = "update users set name=? where id=?";
	        Object params[] = { "ddd", 5};
	        qr.update(sql, params);
	    }

	    @Test
	    public void find() throws SQLException {
	        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	        String sql = "select * from users where id=?";
	        Object params[] = {2};
	        User user = (User) qr.query(sql, params, new BeanHandler(User.class));
	        System.out.println(user.getBirthday());
	    }

	    @Test
	    public void getAll() throws SQLException {
	        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	        String sql = "select * from users";
	        List<User> list = (List<User>) qr.query(sql, new BeanListHandler(User.class));
	        System.out.println(list.size());
	    }

	    /**
	    * @Method: testBatch
	    * @Description:������
	    * @Anthor:�°�����
	    *
	    * @throws SQLException
	    */ 
	    @Test
	    public void testBatch() throws SQLException {
	        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	        String sql = "insert into users(name,password,email,birthday) values(?,?,?,?)";
	        Object params[][] = new Object[10][];
	        for (int i = 0; i < 10; i++) {
	            params[i] = new Object[] { "aa" + i, "123", "aa@sina.com",
	                    new Date() };
	        }
	        qr.batch(sql, params);
	    }
	    
	    //��dbutils��ɴ����ݣ��������ã�
	    /***************************************************************************
	     create table testclob
	     (
	         id int primary key auto_increment,
	         resume text
	     );
	     **************************************************************************/
	    /*@Test
	    public void testclob() throws SQLException, IOException{
	        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
	        String sql = "insert into testclob(resume) values(?)";  //clob
	        //���ַ�ʽ��ȡ��·�������еĿո�ᱻʹ�á�%20������
	        String path  = QueryRunnerCRUDTest.class.getClassLoader().getResource("data.txt").getPath();
	        //����%20���滻�ؿո�
	        path = path.replaceAll("%20", " ");
	        FileReader in = new FileReader(path);
	        char[] buffer = new char[(int) new File(path).length()];
	        in.read(buffer);
	        SerialClob clob = new SerialClob(buffer);
	        Object params[] = {clob};
	        runner.update(sql, params);
	    }*/
	
}