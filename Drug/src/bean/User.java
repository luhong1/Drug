package bean;

public class User {
	private String user;//用户名
	   private String password;//密码
	   
	   public User(){}
	   public User(String user,String password){
		   this.password=password;
		   this.user=user;
	   }
   public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
