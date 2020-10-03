package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBUtil {
	//数据库url、用户名和密码
    static final String url="jdbc:mysql://localhost:3306/hospital_pharmacy?useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT%2B8&useSSL=true";
    static final String user="root";
    static final String pass="root";
    
//    static{
//		//加载数据库驱动
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * 连接数据库
	 * @return conn
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			BasicDataSource dataSource=new BasicDataSource();
			dataSource.setUrl(url);
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUsername(user);
			dataSource.setPassword(pass);
			dataSource.setInitialSize(3);
			dataSource.setMaxIdle(10);
			dataSource.setMinIdle(3);
			dataSource.setMaxConnLifetimeMillis(5000);
			 conn=dataSource.getConnection();
			//conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭数据库
	 * @param conn
	 */
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	// 测试数据库连接
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
