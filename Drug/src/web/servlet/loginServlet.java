package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 String uriString=request.getRequestURI();
	 String pathinfoString=request.getPathInfo();
	 //System.out.println("url="+uriString+"  pathiinfo="+pathinfoString);
	 String requespath=uriString.substring(uriString.lastIndexOf("/")+1);
	 System.out.println("url="+requespath);
	 if(requespath.equals("login")){
		 login(request,response);
	 }
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		String userString=request.getParameter("username");
		  String passwordString=request.getParameter("password");
		  UserDao user=new UserDaoImpl();
		  String string=user.registerUser(userString, passwordString);
		  System.out.println("user="+userString+"  password="+passwordString);
		   if(string.equals("1")){
			   response.sendRedirect("login.jsp");
		   }else{
			   response.sendRedirect("register.jsp");
		   }
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
		String userString=request.getParameter("name");
		  String passwordString=request.getParameter("password");
		  UserDao user=new UserDaoImpl();
		  System.out.println("user="+userString+"  password="+passwordString);
		  HttpSession session=request.getSession();
		  int  s=user.loginUser(userString, passwordString);
		  User u=new User();
		   if(s==1){
			   request.getSession().setAttribute("user",u);
//				  String returl=(String)request.getSession().getAttribute("returl");
//				  String requespath=returl.substring(returl.lastIndexOf("/")+1);
//				  System.out.println(requespath);
//				  response.sendRedirect(requespath);
				  response.sendRedirect("index.jsp");
		   }else if(s==0){
			   session.setAttribute("login","密码错误");
			   response.sendRedirect("login.jsp");
		   }else {
			   session.setAttribute("login", "账号不存在，请去注册");
			   response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String uriString=request.getRequestURI();
		 String pathinfoString=request.getPathInfo();
		 //System.out.println("url="+uriString+"  pathiinfo="+pathinfoString);
		 String requespath=uriString.substring(uriString.lastIndexOf("/")+1);
		 System.out.println("url="+requespath);
		 if(requespath.equals("login")){
			 register(request,response);
		 }
	}
}
