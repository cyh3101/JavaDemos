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
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.sun.crypto.provider.RSACipher;

public class CachedRowSetTest {

	private static String driver;
	private static String url;
	private static String user;
	private static String pass;
	
	public void init() throws IOException{
		Properties pros = new Properties();
		FileInputStream fis = new FileInputStream("mysql.ini");
		pros.load(fis);
		driver = pros.getProperty("driver");
		url = pros.getProperty("url");
		user = pros.getProperty("user");
		pass = pros.getProperty("pass");
		
	}
	
	public CachedRowSet query(String sql) throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pass);
		Statement stm = conn.createStatement();
		ResultSet res = stm.executeQuery(sql);
		
		RowSetFactory factory = RowSetProvider.newFactory();
		CachedRowSet cachedRs = factory.createCachedRowSet();
		cachedRs.populate(res);
		
		res.close();
		stm.close();
		conn.close();
		return cachedRs;
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		CachedRowSetTest ct = new CachedRowSetTest();
		ct.init();
		CachedRowSet cachedRs = ct.query("select * from student_table");
		cachedRs.afterLast();
		
		while(cachedRs.previous()){
			System.out.println(cachedRs.getString(1)
					+ "\t" + cachedRs.getString(2)
					+ "\t" + cachedRs.getString(3));
			if(cachedRs.getInt("student_id") == 3){
				cachedRs.updateString("student_name", "蔡于慧");
				cachedRs.updateRow();
			}
		}
		
		Connection conn = DriverManager.getConnection(url,user,pass);
		
		conn.setAutoCommit(false);
		cachedRs.acceptChanges(conn);
		
	}

}
