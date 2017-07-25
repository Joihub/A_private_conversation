package com.hzgg.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {

	/**
	 * Java�����ݿ⽻����Ϣ�Ĳ��裺 1.�������� ��ֻ����һ�Σ� 2.�������� ��Connection�� 3.����ִ�е�SQL���
	 * 4.ִ��SQL��� ��Statement�� 5.������ 6.�ͷ���Դ
	 */

	// �����ַ���
//	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	// �����ַ���
//	private static String dirver = "oracle.jdbc.driver.OracleDriver";
	// �������ݿ���û���
//	private static String username = "scott";
	// �������ݿ������
//	private static String pwd = "tiger";

	
	private static String url="jdbc:mysql://localhost:3306/Test";
	
	private static String driver="com.mysql.jdbc.Driver";
	
	private static String username = "root";
	
	private static String pwd = "root";
	
	
	
	
	
	/**
	 * 1.��������
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
	 * 2.�������� getConnection,��������ݿⴴ�����ӣ����ҷ���һ��Connection����
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
	 * �ر���Դ
	 */

	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {

		/**
		 * 1.try--catch---finally
		 * 2.if( xxx != null)
		 */
		
		// ��򿪵��ȹر�
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
