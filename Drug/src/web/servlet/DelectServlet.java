package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DrugDaoImpl;
@WebServlet("/DelectServlet")
public class DelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DelectServlet() {
        super();
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null){
			session.setAttribute("returl",request.getRequestURI().toString());
			response.sendRedirect("login.jsp");
		}else{
		request.setCharacterEncoding("utf-8");
		DrugDaoImpl ddi=new DrugDaoImpl();
		String id=request.getParameter("id");
		ddi.deleteDrug(id);
		response.sendRedirect(request.getContextPath()+"/drugManage.jsp");
		//PrintWriter out =response.getWriter();
		//response.sendRedirect("index");
	}
	}
}
