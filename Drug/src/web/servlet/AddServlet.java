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
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
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
		String name=request.getParameter("name");
		String pingying=request.getParameter("pingying");
		String spec=request.getParameter("spec");
		String unit=request.getParameter("unit");
		String type=request.getParameter("type");
		double price=Double.parseDouble(request.getParameter("price"));
		String packing=request.getParameter("packing");
		int amount=Integer.parseInt(request.getParameter("amount"));
		drug.setDrugId(id);
		drug.setDrugName(name);
		drug.setDrugPingyin(pingying);
		drug.setDrugSpecification(spec);
		drug.setDrugUnit(unit);
		drug.setDrugType(type);
		drug.setDrugPrice(price);
		drug.setDrugPacking(packing);
		drug.setDrugAmount(amount);
		ddi.addDrug(drug);
		response.sendRedirect(request.getContextPath()+"/drugManage.jsp");
		//String id=request.getParameter("id");
		//ddi.deleteDrug(id);
		//PrintWriter out =response.getWriter();
		//response.sendRedirect("index");
	}
	}
}
