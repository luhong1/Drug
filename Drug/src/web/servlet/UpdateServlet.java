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
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null){
			session.setAttribute("returl",request.getRequestURI().toString());
			response.sendRedirect("login.jsp");
		}else{
		request.setCharacterEncoding("utf-8");
		DrugDaoImpl ddi=new DrugDaoImpl();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String pingying=request.getParameter("pingying");
		String spec=request.getParameter("spec");
		String unit=request.getParameter("unit");
		String type=request.getParameter("type");
		double price=Double.parseDouble(request.getParameter("price"));
		String packing=request.getParameter("packing");
		int amount=Integer.parseInt(request.getParameter("amount"));
		ddi.alterDrug(id,name,pingying,spec,unit,type,price,packing,amount);
		response.sendRedirect(request.getContextPath()+"/drugManage.jsp");
		//String id=request.getParameter("id");
		//ddi.deleteDrug(id);
		//PrintWriter out =response.getWriter();
		//response.sendRedirect("index");
	}
	}
}
