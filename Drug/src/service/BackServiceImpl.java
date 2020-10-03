package service;

import java.util.Date;

import bean.Drug;
import bean.Patient;
import dao.DrugDao;
import dao.DrugDaoImpl;
import dao.PatientDao;
import dao.PatientDaoImpl;

public class BackServiceImpl implements BackService{
	
	private Patient query=new Patient();
	private PatientDao pd = new PatientDaoImpl();
	private DrugDao dd = new DrugDaoImpl();
	private String[] drugName ; 
	private Drug backDrug=new Drug();
	@Override
	public Patient findQuery(String caseNum, Date time) {
		//从数据库中查询患者信息
		
		query = pd.findPatien(caseNum,time);  //数据库中查询到的患者信息
		drugName = query.getDruglist().split(",|，");//将患者处方的药品整个string分解成string[]
		//查询药品信息
		query.setDrugName(drugName);
		return query;
	}
	
	//通过患者的处方进行退药操作
	@Override
	public void backDrug() {
		for(String ss:query.getDrugName()){
			backDrug = dd.findDrugName(ss);
			//如果该药品存量大于1，则进行发药
				String s=String.valueOf(backDrug.getDrugAmount()+1);
				dd.altreDrug(backDrug.getDrugId(), "drugAmount", s);  //库存+1
			}
		}

	}
