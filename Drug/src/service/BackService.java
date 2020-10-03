package service;

import java.util.Date;

import bean.Drug;
import bean.Patient;

public interface BackService {
    //1.查询患者信息，获取患者药单
	Patient findQuery(String caseNum,Date time);
	//2.进行退药操作
	void backDrug();

}
