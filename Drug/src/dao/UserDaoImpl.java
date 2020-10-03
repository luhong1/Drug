package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import utils.DBUtil;
import utils.SqlUtils;

public class UserDaoImpl implements UserDao {

	Connection conn;
	SqlUtils su = new SqlUtils();
	private User userpass=new User();
	@Override
	public int loginUser(String user, String password) {
		ResultSet rs = su.query("select * from User");
		try {
			while(rs.next()){
				String duser = rs.getString("user");
				
				if(user.equals(duser)){
					String dpassword = rs.getString("password");
					if(password.equals(dpassword)){
						userpass.setUser(duser);
						userpass.setPassword(dpassword);
						return 1;
					}else{
						return 0;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return -1;
	}
	@Override
	public String registerUser(String user, String password) {
			   String sql="INSERT into User VALUES ('"+user+"','"+password+"')";
			   int result = su.update(sql);
			   if(result>0){
					System.out.println(result);
					return "1";
				}else {
					System.out.println("添加失败");
					
				}
		DBUtil.close(conn);
		return "0";
	}


}
