package com.hzgg.base;

import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * 使用了模板策略
 * 构建一个结果处理器
 * @author Administrator
 *
 */
public interface ResultSetHandle {
	
	
	/**
	 * 一个专门来处理结果集的方法
	 * 因为这个结果集的内容是不确定的，谁去调用，谁就去实现这个接口
	 * @param rs
	 * @return
	 */
	public Object doHandle(ResultSet rs) throws SQLException;

}
