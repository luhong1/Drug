package service;

import bean.Drug;

public interface DrugService {

	//查找药品
	public void findDrug(String drugId);
	
	//增加药品信息，药品相同添加数量，新药增加记录
	public void addDrug(Drug drug);
	
	//删除整条药品信息�?
	public void deleteDrug(String drugId);
	
	//修改药品信息
	public void alterDrug(String drugId,String alter,String alterResult) ;
	

	
}
