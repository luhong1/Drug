package dao;

import java.util.Date;

import bean.Patient;

public interface PatientDao {

	Patient findPatien(String caseNum,Date time);
	int alterPatien(int value,String caseNum);
}
