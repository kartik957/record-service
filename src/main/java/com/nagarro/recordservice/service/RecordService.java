package com.nagarro.recordservice.service;

import java.util.List;

import com.nagarro.recordservice.entity.PatientRecord;
import com.nagarro.recordservice.exceptions.CustomizedException;

public interface RecordService 
{
	public PatientRecord createRecord(PatientRecord patientRecord);
	
	public List<PatientRecord> getRecordByPatientId(int patientId);
	
	public PatientRecord getRecordByRecordId(int recordId) throws CustomizedException;
	
	public PatientRecord updateRecord(PatientRecord record) throws CustomizedException;
	
	public void deleteRecord(int recordId) throws CustomizedException;
	
	
}
