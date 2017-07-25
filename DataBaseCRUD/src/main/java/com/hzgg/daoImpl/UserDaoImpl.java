package com.hzgg.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hzgg.Jdbc.JdbcTemplete;
import com.hzgg.base.ResultSetHandle;
import com.hzgg.dao.UserDao;
import com.hzgg.vo.User;

public class UserDaoImpl implements UserDao{

	@Override
	public void insert(User user) {
		String sql = "insert into t_uer(id,name,cardnum) values(?,?,?)";
		JdbcTemplete.update(sql, user.getId(),user.getName(),user.getCardNum());
	}

	@Override
	public void delete(User user) {
		
	}

	@Override
	public void update(User user) {
		
	}

	
	/**
	 * select 查询
	 * 1.有返回值
	 * 2.返回一条记录
	 * 3.返回多条记录
	 * 
	 */
	@Override
	public User select(int id) {
		
		String sql ="select id,name,age,hiredate,cardnum from t_user where id = ?";
		
		Object obj = JdbcTemplete.query(sql, new ResultSetHandle() {
			/**
			 * 这里才是真正的去处理结果
			 */
			@Override
			public Object doHandle(ResultSet rs) throws SQLException {
				User u = null;
				
				while(rs.next()){
					u =new User();
					
					u.setId(rs.getInt("id"));
					u.setName(rs.getString("name"));
					u.setAge(rs.getInt("age"));
					u.setCardNum(rs.getInt("cardNum"));
					u.setHiredate(rs.getDate("hiredate"));
				}
				
				return u;
			}
		}, id);
		
		
		User u = (User)obj;
		
		return u;
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAll() {
		String sql = "select id,name,cardnum from t_user";
		
		
		return (List<User>) JdbcTemplete.query(sql, new ResultSetHandle() {
			
			List<User> list = new ArrayList<>();
			User u = null;
			@Override
			public Object doHandle(ResultSet rs) throws SQLException {
				
				while(rs.next()){
					u =new User();
					u.setId(rs.getInt("id"));
					u.setName(rs.getString("name"));
					u.setAge(rs.getInt("age"));
					u.setCardNum(rs.getInt("cardNum"));
					u.setHiredate(rs.getDate("hiredate"));
					list.add(u);
				}
				
				return list;
			}
		});
		
		//List<User> list = (List<User>) obj;
		
		
		//return list;
	}

	
	
	
}
