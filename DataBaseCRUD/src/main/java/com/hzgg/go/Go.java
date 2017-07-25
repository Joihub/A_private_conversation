package com.hzgg.go;

import com.hzgg.daoImpl.UserDaoImpl;
import com.hzgg.vo.User;

public class Go {
	
	
	
	public static void main(String[] args) {
		//用户输入信息
		//存入到User中
		User u = new User();
		
		UserDaoImpl udao = new UserDaoImpl();
		
		udao.insert(u);
		
		
		//查询数据
		User uu = udao.select(8);
		
		
		
		
	}

}
