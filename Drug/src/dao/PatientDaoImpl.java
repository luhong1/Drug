package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import bean.Patient;
import utils.DBUtil;
import utils.SqlUtils;

public class PatientDaoImpl implements PatientDao{

	Connection conn;
	Patient patient = new Patient();
	SqlUtils su = new SqlUtils();
	@Override
	public Patient findPatien(String caseNum,Date time) {
		


		try {
			
			
			String sql = "select * from patientcase";
			ResultSet rs = su.query(sql);
			while(rs.next()){
				//对比时间
				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(time);
				cal1.set(Calendar.HOUR_OF_DAY, 0);
				cal1.set(Calendar.MINUTE, 0);
				cal1.set(Calendar.SECOND, 0);
				cal1.set(Calendar.MILLISECOND, 0);
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(rs.getDate("time"));
				cal2.set(Calendar.HOUR_OF_DAY, 0);
				cal2.set(Calendar.MINUTE, 0);
				cal2.set(Calendar.SECOND, 0);
				cal2.set(Calendar.MILLISECOND, 0);

				if(caseNum.equals(rs.getString("caseNum"))&&cal1.getTime().equals(cal2.getTime())){
					patient.setCaseNum(caseNum);
					patient.setName(rs.getString("name"));
					patient.setGender(rs.getString("gender"));
					patient.setAge(rs.getInt("age"));
					patient.setPayType(rs.getString("payType"));
					patient.setDruglist(rs.getString("drugList"));
					patient.setTime(rs.getDate("time"));
					patient.setDrugType(rs.getString("drugType"));
					return patient;
				}
			}
			System.out.println("没有找到该病人");
			return patient;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return patient;
		
	}


	
	@Override
	public int alterPatien(int value,String caseNum) {
		try {

			//将病人的发药状态由0改为1
			String sql = "UPDATE patientcase set drugType = '"+value+"' WHERE caseNum = '"+caseNum+"'";
			//result为影响的行数，为0证明删除失败
			int result =su.update(sql);
			if(result>0){
				System.out.println(result);
				return result;
			}else {
				System.out.println("修改失败");
			}
		}finally{
			DBUtil.close(conn);
		}
		return 0;				
	}

	
   
}
