package com.cyh.demos.mysql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseMetaDataTest {

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
	
	public void info() throws Exception{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		//获取DatabaseMetaData对象
		DatabaseMetaData dbmd = conn.getMetaData();
		ResultSet rs = dbmd.getTableTypes();
		System.out.println("--MySQL支持的表类型信息--");
		printResultSet(rs);
		
		//获取当前数据库的全部数据表
		rs = dbmd.getTables(null, null, "%", new String[]{"TABLE"});
		System.out.println("--当前数据库的数据表信息--");
		printResultSet(rs);
		
	}
	
	public void printResultSet(ResultSet rs) throws SQLException{
		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i + 1) + "\t");
		}
		System.out.println();
		while(rs.next()){
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				System.out.print(rs.getString(i + 1) + "\t");
			}
			System.out.println();
		}
		rs.close();
	}
	public static void main(String[] args) throws Exception {
		DatabaseMetaDataTest dmdt = new DatabaseMetaDataTest();
		dmdt.init();
		dmdt.info();
	}

}
