package web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Patient;
import dao.PatientDaoImpl;
import service.BackServiceImpl;
import service.GrantDrugServiceImpl;

/**
 * Servlet implementation class medecineServlet
 */
@WebServlet("/medecineServlet")
public class medecineServlet extends HttpServlet {
	private PatientDaoImpl pa = new PatientDaoImpl();
   private BackServiceImpl pat=new BackServiceImpl();
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
		Patient patient=new Patient();
		String drugType=request.getParameter("drugType");
		String time=request.getParameter("time");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = dateFormat.parse(time);	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String caseNum=request.getParameter("caseNum");
		 patient=pat.findQuery(caseNum,date);
		 String string2=patient.isPayType();
		 String string1=patient.isDrugType();
		System.out.println(drugType);
		if(string2.equals("1")){
			if(string1.equals("1")){
				 pa.alterPatien(-1,patient.getCaseNum());
			     pat.backDrug();
			     patient=pat.findQuery(caseNum,date);
				request.setAttribute("cn", "退药成功");
			}else if(string1.equals("0")){
				pa.alterPatien(-1,patient.getCaseNum());
				 patient=pat.findQuery(caseNum,date);
					request.setAttribute("cn", "退药成功");
			}else{
				 patient=pat.findQuery(caseNum,date);
				request.setAttribute("cn", "已退药过！！！");
			}
		}else {
			request.setAttribute("cn", "未查询到该患者的药品信息！！！");
		}
		 request.setAttribute("caseNum", patient.getCaseNum());
			request.setAttribute("time", time);
			request.setAttribute("name", patient.getName());
			request.setAttribute("gender", patient.getGender());
			request.setAttribute("age",patient.getAge());
			request.setAttribute("drugNameList",patient.getDruglist());
			String string=patient.isDrugType();
			String payType=patient.isPayType();
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
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
