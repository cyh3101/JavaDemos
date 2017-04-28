package com.cyh.demos.mysql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;


public class CallableStatementTest {

	private String driver;
	private String url;
	private String user;
	private String pass;
	
	public void initParam(String paraFile) throws FileNotFoundException, IOException{
		Properties props = new Properties();
		props.load(new FileInputStream(paraFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	
	public void callProcedure() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url , user , pass);
		CallableStatement cstmt = conn.prepareCall("call add_pro(?,?,?)");
		cstmt.setInt(1, 4);;
		cstmt.setInt(2, 5);
		cstmt.registerOutParameter(3, Types.INTEGER);
		cstmt.execute();
		System.out.println("执行结果:" + cstmt.getInt(3));
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		CallableStatementTest ct = new CallableStatementTest();
		ct.initParam("mysql.ini");
		ct.callProcedure();

	}

}
