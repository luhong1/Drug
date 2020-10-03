package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.StringValueExp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Patient;
import dao.PatientDaoImpl;
import service.GrantDrugServiceImpl;

/**
 * Servlet implementation class rivivalServlet
 */
@WebServlet("/rivivalServlet")
public class rivivalServlet extends HttpServlet {
	private Patient patient=new Patient();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null){
			session.setAttribute("returl",request.getRequestURI().toString());
			response.sendRedirect("login.jsp");
		}else{
		String caseNum=request.getParameter("caseNum");
		 PatientDaoImpl pa = new PatientDaoImpl();
		    GrantDrugServiceImpl pat=new GrantDrugServiceImpl();
		String time=request.getParameter("time");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = dateFormat.parse(time);	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 patient=pat.findQueryByCasenum(caseNum,date);
			String payType=""+patient.isPayType();
		String drugType=""+patient.isDrugType();
		System.out.println(drugType);
		if(payType.equals("1")){
			if(drugType.equals("0")){
				 pa.alterPatien(1,patient.getCaseNum());
			     pat.grantDrug();
			     patient=pat.findQueryByCasenum(caseNum,date);
				request.setAttribute("cn", "发药成功");
			}else if(drugType.equals("1")){
				request.setAttribute("cn", "已经发药过！！！");
			}else{
				request.setAttribute("cn", "已退药！！！");
			}
		}else {
			request.setAttribute("cn", "请去缴费哦！！！");
		}
		 request.setAttribute("caseNum", patient.getCaseNum());
			request.setAttribute("time", time);
			request.setAttribute("name", patient.getName());
			request.setAttribute("gender", patient.getGender());
			request.setAttribute("age",patient.getAge());
			request.setAttribute("drugNameList",patient.getDruglist());
			String string=patient.isDrugType();
			if(payType.equals("1")){
				request.setAttribute("payType","是");
				}
				else{
					request.setAttribute("payType","否");
				}	
			if(string.equals("1")){
				request.setAttribute("drugType","是");
				}
				else{
					request.setAttribute("drugType","否");
				}
		 request.getRequestDispatcher("dispensingDrug.jsp").forward(request, response);
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
