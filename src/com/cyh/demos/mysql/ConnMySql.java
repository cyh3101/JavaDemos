package com.cyh.demos.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnMySql {

	public static void main(String[] args) throws ClassNotFoundException {
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			//利用DriverManger来获取数据库连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/select_test"
					, "root" , "root");
			//利用数据库连接来创建一个Statement对象
			Statement stmt = conn.createStatement();
			//执行sql语句
			ResultSet rs = stmt.executeQuery("select s.*,teacher_name"
					+ " from student_table s , teacher_table t"
					+ " where t.teacher_id = s.java_teacher");
			while(rs.next()){
				System.out.println(rs.getInt(1) + "\t"
						+ rs.getString(2) + "\t"
						+ rs.getString(3) + "\t"
						+ rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
