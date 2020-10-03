package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtils {

	private  Connection conn;
	
	public ResultSet query(String sql){
		conn = DBUtil.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;		
	}
	
	public int update(String sql){
		conn = DBUtil.getConnection();
		Statement st;
		try {
			 st= conn.createStatement();
			 int rs = st.executeUpdate(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	



}
