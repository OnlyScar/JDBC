package com.dbutils.dao;

import java.sql.SQLException;
import java.util.List;

import com.dbutils.domain.User;
import com.dbutils.util.BeanHandler;
import com.dbutils.util.BeanListHandler;
import com.dbutils.util.JdbcUtils;

public class UserDao {
	
	public void add(User user) throws SQLException{
		String sql = "insert into user_(id,name) values(?,?) ";
		Object params[] = {user.getId(),user.getName()};
		JdbcUtils.update(sql, params);
	}
	
	public void delete(int id) throws SQLException{
		String sql = "delete from user_ where id=?";
		Object params[] = {id};
		JdbcUtils.update(sql, params);
		
	}
	
	public void update(User user) throws SQLException{
		String sql = "update user_ set name=? where id=?";
		Object params[] = {user.getName(),user.getId()};
		JdbcUtils.update(sql, params);
	}
	
	public User find(int id) throws SQLException{
		String sql = "select * from user_ where id=?";
		Object params[] = {id};
		return (User) JdbcUtils.query(sql, params, new BeanHandler(User.class));
		
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAll() throws SQLException {
		String sql = "select * from user_";
		Object params[] = {};
		return (List<User>) JdbcUtils.query(sql, params, new BeanListHandler(User.class));
	}
	
	public static void main(String[] args) throws SQLException {
		UserDao dao = new UserDao();
		
		User find = dao.find(4);
		System.out.println(find);
		
		find.setName("modify");
		dao.update(find);
		
		User user = new User(2,"second");
		dao.add(user);
		
		List<User> list = dao.getAll();
		System.out.println(list);
	}
	
}
