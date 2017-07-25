package com.hzgg.dao;

import java.util.List;

import com.hzgg.vo.User;


public interface UserDao {
	
	
	public void insert(User user);
	
	public void delete(User user);
	
	public void delete(int id);
	
	public void update(User user);
	
	public void update(int id);
	
	
	/**
	 * ��ѯ�����û�
	 * @param id
	 * @return
	 */
	public User select(int id);
	
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<User> selectAll();
	
	

}
