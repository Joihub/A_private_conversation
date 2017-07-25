package com.hzgg.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {

	/**
	 * Java和数据库交互信息的步骤： 1.加载驱动 （只加载一次） 2.建立连接 （Connection） 3.创建执行的SQL语句
	 * 4.执行SQL语句 （Statement） 5.处理结果 6.释放资源
	 */

	// 链接字符串
//	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	// 驱动字符串
//	private static String dirver = "oracle.jdbc.driver.OracleDriver";
	// 连接数据库的用户名
//	private static String username = "scott";
	// 连接数据库的密码
//	private static String pwd = "tiger";

	
	private static String url="jdbc:mysql://localhost:3306/Test";
	
	private static String driver="com.mysql.jdbc.Driver";
	
	private static String username = "root";
	
	private static String pwd = "root";
	
	
	
	
	
	/**
	 * 1.加载驱动
	 */
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 2.创建连接 getConnection,负责和数据库创建连接，并且返回一个Connection对象
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public static void main(String[] args) {
		Connection conn = getConnection();
		JdbcUtil.close(conn,null,null);
	}

	/**
	 * 关闭资源
	 */

	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {

		/**
		 * 1.try--catch---finally
		 * 2.if( xxx != null)
		 */
		
		// 后打开的先关闭
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
