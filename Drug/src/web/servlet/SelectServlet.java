package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Drug;
import dao.DrugDaoImpl;
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null){
			session.setAttribute("returl",request.getRequestURI().toString());
			response.sendRedirect("login.jsp");
		}else{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		DrugDaoImpl ddi=new DrugDaoImpl();
		Drug drug=new Drug();
		String id=request.getParameter("id");
		drug=ddi.findDrug(id);
		PrintWriter out =response.getWriter();
		out.write(drug.getDrugId()+drug.getDrugName()+drug.getDrugJX()+drug.getDrugPingyin()+drug.getDrugSpecification()+drug.getDrugType()+drug.getDrugUnit()+drug.getDrugAmount());
		//response.sendRedirect("index");
	}
	}
}
