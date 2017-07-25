package com.hzgg.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hzgg.base.ResultSetHandle;

public class JdbcTemplete {
	
	
	/**
	 * 1.��ʹ��ƴ���ַ���
	 * 2.����(�ɱ䳤�ȵĲ���)
	 */
	
	/**
	 * �ɱ䳤�Ȳ���
	 * Object...objs
	 * @param args
	 */
	public static void update(String sql,Object...objs){

		//��Ҫ�����ݿ⽨������
		Connection conn = null;
		//ʹ��prepareStatement����Ԥ����sql���
		PreparedStatement ps = null;
		
		//String sql = insert into t_user(id,name,cardnum) values(?,?,?);
		
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			
			//�Ѵ��ݹ����Ĳ��������õ�sql����ȥ
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
			
			//�Ѵ��ݹ����Ĳ��������õ�sql����ȥ
			if(objs != null){
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i+1, objs[i]);
				}
			}
			//��Ϊ���ص�rs���������ǲ�ȷ����
			//����sql���Ĳ�ͬ��rs�Ľ��Ҳ�ǲ�ͬ��
			//˭�����������,˭��ȥ������������rs��
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
