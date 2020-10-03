package service;


import bean.Drug;
import dao.DrugDao;
import dao.DrugDaoImpl;

public class DrugServiceimpl implements DrugService{
	

	private DrugDao dd = new DrugDaoImpl();
	private Drug drug;
	//查询
	@Override
	public void findDrug(String drugId) {
		drug = dd.findDrug(drugId);

	}
	//添加
	@Override
	public void addDrug(Drug drug) {
		dd.addDrug(drug);
		
	}

	@Override
	public void deleteDrug(String drugId) {
		dd.deleteDrug(drugId);
	}

	//drugId:修改的药品，alter：修改的参数名，alterResult：修改后的参�?
	@Override
	public void alterDrug(String drugId,String alter,String alterResult) {
		dd.alterDrug(drugId, alter, alterResult, alterResult, alterResult, alterResult, null, alterResult, 0);

		
	}
			

}


	
