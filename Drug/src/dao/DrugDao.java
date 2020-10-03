package dao;

import java.util.ArrayList;

import bean.Drug;
import bean.User;

public interface DrugDao {
	
	//查找药品
	Drug findDrug(String drugId);
	//药名药品
	Drug findDrugName(String drugName);
	
	//增加药品信息
	void addDrug(Drug drug);
	
	//删除药品信息
	void deleteDrug(String drugId);
	
	//修改药品信息
	void alterDrug(String drugId,String drugName,String drugPingyin,String drugSpecification,String drugUnit,String drugType,Double drugPrice,String drugPacking,int drugAmount) ;
    
	//查询药品信息
		ArrayList<Drug> findAllDrug();

		void altreDrug(String drugId, String alter, String alterResult);

		
}
