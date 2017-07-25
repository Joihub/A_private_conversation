package com.hzgg.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hzgg.base.ResultSetHandle;

public class JdbcTemplete {
	
	
	/**
	 * 1.不使用拼接字符串
	 * 2.参数(可变长度的参数)
	 */
	
	/**
	 * 可变长度参数
	 * Object...objs
	 * @param args
	 */
	public static void update(String sql,Object...objs){

		//先要和数据库建立连接
		Connection conn = null;
		//使用prepareStatement可以预处理sql语句
		PreparedStatement ps = null;
		
		//String sql = insert into t_user(id,name,cardnum) values(?,?,?);
		
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			
			//把传递过来的参数，设置到sql里面去
			if(objs != null){
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i+1, objs[i]);
				}
			}
			
			ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps, null);
		}
	}
	
	
	
	
	
	public static Object query(String sql,ResultSetHandle handle,Object...objs){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			
			//把传递过来的参数，设置到sql里面去
			if(objs != null){
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i+1, objs[i]);
				}
			}
			//因为返回的rs这个结果集是不确定的
			//根据sql语句的不同，rs的结果也是不同的
			//谁调用这个方法,谁就去处理这个结果（rs）
			rs = ps.executeQuery();
			
			
			return handle.doHandle(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			JdbcUtil.close(conn, ps, rs);
		}
		
	}
	
	
}
