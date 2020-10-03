package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bean.Drug;
import bean.Patient;
import dao.DrugDaoImpl;
import dao.DrugDao;
import dao.PatientDaoImpl;
import service.GrantDrugService;
import service.GrantDrugServiceImpl;

//数据库查询
public class text {

	public static void main(String[] args) throws ParseException {
//		DrugDuo dd = new DrugDaoImpl();
//		
//		Drug drug = dd.findDrug("86979474000208 ");
//		System.out.println(drug.getDrugName());
//		
//		
//		PatientDaoImpl pa = new PatientDaoImpl();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = dateFormat.parse("2020-02-25 10:01:00");
//		Patient pat = pa.findPatien("010101",date);
//		System.out.println(pat.getCaseNum()+"  "+pat.getName());
		
		System.out.println("药品管理功能测试:");
		DrugDao dd = new DrugDaoImpl();
		
		System.out.println("查询测试：");
		Drug drug = dd.findDrug("86979474000208 ");
		System.out.println(drug.getDrugId()+"  "+drug.getDrugName());
		
//		System.out.println("增加测试：");
//		dd.addDrug(drug);
		
		System.out.println("删除测试：");
		dd.deleteDrug(drug.getDrugId());
		
		System.out.println("修改测试：");
		dd.altreDrug("86979474000208", "drugName", "注射用甲氨喋呤修改版");
		
		System.out.println("查询测试：");
		Drug drug1 = dd.findDrug("86979474000208 ");
		System.out.println(drug1.getDrugId()+"  "+drug1.getDrugName());
		
		
		System.out.println("病人信息查询测试:");
		PatientDaoImpl pa = new PatientDaoImpl();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = dateFormat.parse("2020-02-25 12:43:43");
		Patient pat = pa.findPatien("010101",date);
		System.out.println(pat.getCaseNum()+"  "+pat.getName());
		GrantDrugServiceImpl gran=new GrantDrugServiceImpl();
		System.out.println("修改病人信息测试:");
		pa.alterPatien(0,"010101");
		gran.grantDrug();
		
		
	}

}
