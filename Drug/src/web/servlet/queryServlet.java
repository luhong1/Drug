package web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.PatientDaoImpl;
import service.GrantDrugServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Patient;

/**
 * Servlet implementation class queryServlet
 */
@WebServlet("/query")
public class queryServlet extends HttpServlet {
	Patient pat=new Patient();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null){
			session.setAttribute("returl",request.getRequestURI().toString());
			response.sendRedirect("login.jsp");
			return;
		}else{
		// TODO Auto-generated method stu
			String caseNum=request.getParameter("caseNum");
			String time=request.getParameter("date");
			pat.setCaseNum(caseNum);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			try {
				date = dateFormat.parse(time);	
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pat.setTime(date);
		System.out.println("caseNum="+caseNum+"   time="+date);
		System.out.println("病人信息查询测试:");
		GrantDrugServiceImpl pa = new GrantDrugServiceImpl();
		pat=pa.findQueryByCasenum(caseNum,date);
		session.setAttribute("drugNameList",pat.getDruglist());
		request.setAttribute("caseNum", pat.getCaseNum());
		request.setAttribute("time", time);
		request.setAttribute("name", pat.getName());
		request.setAttribute("gender", pat.getGender());
		request.setAttribute("age",pat.getAge());
		request.setAttribute("drugNameList",pat.getDruglist());
		String string=pat.isDrugType();
		String payType=pat.isPayType();
		if(payType.equals("1")){
			request.setAttribute("payType","是");
			}
			else{
				request.setAttribute("payType","否");
			}
		if(string.equals("1")){
		request.setAttribute("drugType","是");
		}
		else if(string.equals("-1")){
			request.setAttribute("drugType","已退药！！！");
		}else{
			request.setAttribute("drugType","否");
		}
//		request.setAttribute("message", message);
		
	    request.getRequestDispatcher("dispensingDrug.jsp").forward(request, response);
		
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null){
			session.setAttribute("returl",request.getRequestURI().toString());
			String caseNum=request.getParameter("caseNum");
			String time=request.getParameter("date");
			pat.setCaseNum(caseNum);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			try {
				date = dateFormat.parse(time);	
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pat.setTime(date);
			response.sendRedirect("login.jsp");
			return;
		}else{
		// TODO Auto-generated method stu
			String caseNum=pat.getCaseNum();
			Date date=pat.getTime();
		System.out.println("caseNum="+caseNum+"time="+date);
		System.out.println("病人信息查询测试:");
		GrantDrugServiceImpl pa = new GrantDrugServiceImpl();
		pat=pa.findQueryByCasenum(caseNum,date);
	
		session.setAttribute("drugNameList",pat.getDruglist());
		request.setAttribute("caseNum", pat.getCaseNum());
		request.setAttribute("time", date);
		request.setAttribute("name", pat.getName());
		request.setAttribute("gender", pat.getGender());
		request.setAttribute("age",pat.getAge());
		request.setAttribute("drugNameList",pat.getDruglist());
		request.setAttribute("payType",pat.isPayType());
		request.setAttribute("drugType",pat.isDrugType());
//		request.setAttribute("message", message);
		String string=pat.isDrugType();
		String payType=pat.isPayType();
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
	    request.getRequestDispatcher("outDrug.jsp").forward(request, response);
	}
	}
}
