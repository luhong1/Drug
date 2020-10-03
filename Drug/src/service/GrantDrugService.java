package service;

import java.util.Date;

import bean.Drug;
import bean.Patient;

public interface GrantDrugService {
	 //1.查询患者信息，获取患者药单
	Patient findQueryByCasenum(String caseNum,Date time);
	//2.根据药单进行发药操作
	void grantDrug();
   
}
