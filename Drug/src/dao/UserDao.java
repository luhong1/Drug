package dao;

import bean.User;

public interface UserDao {
	//User登录
		int loginUser(String user,String password);
		//User注册
		String registerUser(String user,String password);
}
