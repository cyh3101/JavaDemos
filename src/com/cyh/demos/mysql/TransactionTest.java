package com.cyh.demos.mysql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

public class TransactionTest {

	private static String driver;
	private static String url;
	private static String user;
	private static String pass;
	
	public void init() throws FileNotFoundException, IOException{
		Properties pros = new Properties();
		pros.load(new FileInputStream("mysql.ini"));
		driver = pros.getProperty("driver");
		url = pros.getProperty("url");
		user = pros.getProperty("user");
		pass = pros.getProperty("pass");
	}
	
	public void insertInTransaction(String[] sqls) throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		//开始事务
		conn.setAutoCommit(false);
		
		try {
			Statement stm = conn.createStatement();
			
			for (String sql : sqls) {
				stm.executeUpdate(sql);
			}
			//提交事务
			conn.commit();
			
		} catch (Exception e) {
			conn.rollback();
		}
		
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		TransactionTest tt = new TransactionTest();
		tt.init();
		String[] sqls = new String[]{
			"insert into student_table values(null,'aaa',1)",
			"insert into student_table values(null,'bbb',1)",
			"insert into student_table values(null,'ccc',2)",
			"insrt into student_table values(null,'ddd',4)"
		};
		
		tt.insertInTransaction(sqls);
	}

}
