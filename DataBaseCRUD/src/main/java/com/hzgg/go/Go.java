package com.hzgg.go;

import com.hzgg.daoImpl.UserDaoImpl;
import com.hzgg.vo.User;

public class Go {
	
	
	
	public static void main(String[] args) {
		//�û�������Ϣ
		//���뵽User��
		User u = new User();
		
		UserDaoImpl udao = new UserDaoImpl();
		
		udao.insert(u);
		
		
		//��ѯ����
		User uu = udao.select(8);
		
		
		
		
	}

}
