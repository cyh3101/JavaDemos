package com.cyh.demos.mysql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetPage {

	private static String driver;
	private static String url;
	private static String user;
	private static String pass;
	
	//通过mysql.ini文件初始化数据库相关的信息
	public void init() throws IOException{
		Properties pros = new Properties();
		FileInputStream fis = new FileInputStream("mysql.ini");
		pros.load(fis);
		driver = pros.getProperty("driver");
		url = pros.getProperty("url");
		user = pros.getProperty("user");
		pass = pros.getProperty("pass");
	}
	
	//通过传入sql语句、页大小、页码来获得CachedRowSet
	public CachedRowSet query(String sql , int pageSize 
			, int page) throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pass);
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		CachedRowSet cachedRs = RowSetProvider.newFactory().createCachedRowSet();
		cachedRs.populate(rs, (page - 1) * pageSize + 1);
		return cachedRs;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		CachedRowSetPage cp = new CachedRowSetPage();
		cp.init();
		CachedRowSet crs = cp.query("select * from student_table", 3, 2);
		
		while(crs.next()){
			System.out.println(crs.getString(1)
					+ "\t" + crs.getString(2)
					+ "\t" + crs.getString(3));
		}
	}

}
