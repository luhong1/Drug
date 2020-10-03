package bean;

import java.util.Date;
import java.util.List;

public class Patient {
	private	String caseNum;//病历号
	private	String gender;//病人的性别
	private	String name;//病人的姓名
 	private	Integer age;//病人的年龄
 	private String drugNameList;//药品信息
 	private String payType;//缴费状态
 	private Date time;//最新病历更新时间״̬
 	private String drugType;//是否已经发药
 	private String[] drugName;
  	public String getDrugNameList() {
		return drugNameList;
	}

	public void setDrugNameList(String drugNameList) {
		this.drugNameList = drugNameList;
	}

	public String[] getDrugName() {
		return drugName;
	}

	public void setDrugName(String[] drugName) {
		this.drugName = drugName;
	}

	public Patient(){}

	public Patient(String caseNum, String gender, String name, Integer age, String 
			drugNameList, String payType,
			String drugType,String[] drugName) {
		this.caseNum = caseNum;
		this.gender = gender;
		this.name = name;
		this.age = age;
		this.drugNameList = drugNameList;
		this.payType = payType;
		this.drugType = drugType;
		this.drugName=drugName;
	}
	public String getCaseNum() {
		return caseNum;
	}
	public void setCaseNum(String caseNum) {
		this.caseNum = caseNum;
	}
	public String isPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDruglist() {
		return drugNameList;
	}
	public void setDruglist(String drugNameList) {
		this.drugNameList = drugNameList;
	}
	public String isDrugType() {
		return drugType;
	}
	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	
}


