package com.hzgg.base;

import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * ʹ����ģ�����
 * ����һ�����������
 * @author Administrator
 *
 */
public interface ResultSetHandle {
	
	
	/**
	 * һ��ר�������������ķ���
	 * ��Ϊ���������������ǲ�ȷ���ģ�˭ȥ���ã�˭��ȥʵ������ӿ�
	 * @param rs
	 * @return
	 */
	public Object doHandle(ResultSet rs) throws SQLException;

}
