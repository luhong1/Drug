package service;



import java.util.Date;

import bean.Drug;
import bean.Patient;
import dao.DrugDao;
import dao.DrugDaoImpl;
import dao.PatientDao;
import dao.PatientDaoImpl;

public  class GrantDrugServiceImpl implements GrantDrugService {
	
	private PatientDaoImpl rivivalDao;
	private Drug drug;
	private Patient query;
	private PatientDao pd = new PatientDaoImpl();
	private DrugDao dd = new DrugDaoImpl();
	private String[] drugName ; 

	@Override
	public Patient findQueryByCasenum(String caseNum, Date time) {
		//从数据库中查询患者信息
		
		query = pd.findPatien(caseNum,time);  //数据库中查询到的患者信息	
		drugName = query.getDruglist().split(",|，");
		query.setDrugName(drugName);
		 for(String s:query.getDrugName()){
				System.out.println(s);
			}
		System.out.println("查询药品信息");
		return query;		
	}
	
	//通过患者的处方进行发药操作
	@Override
	public void grantDrug() {
		for(String ss:query.getDrugName()){
			drug = dd.findDrugName(ss);
			//如果该药品存量大于1，则进行发药
			if(drug.getDrugAmount()>=1){
				String s=String.valueOf(drug.getDrugAmount()-1);
				dd.altreDrug(drug.getDrugId(), "drugAmount", s);  //库存-1
			}else{
				System.out.println("对不起，这种药品暂缺");
			}
		}

	}
	

}
