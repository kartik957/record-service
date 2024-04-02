package com.nagarro.recordservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nagarro.recordservice.entity.PatientRecord;
import com.nagarro.recordservice.exceptions.CustomizedException;
import com.nagarro.recordservice.repository.RecordRepository;
import com.nagarro.recordservice.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {

	private final RecordRepository recordRepository;

	public RecordServiceImpl(RecordRepository recordRepository) {
		this.recordRepository = recordRepository;
	}

	@Override
	public PatientRecord createRecord(PatientRecord record) {
		return recordRepository.save(record);
	}

	@Override
	public List<PatientRecord> getRecordByPatientId(int patientId) {

		return recordRepository.findByPatientId(patientId);

	}

	@Override
	public PatientRecord getRecordByRecordId(int recordId) throws CustomizedException {
		try {
			Optional<PatientRecord> record = recordRepository.findById(recordId);
			return record.get();

		} catch (Exception e) {
			throw new CustomizedException("No record exist with"+ recordId);
		}
	}

	@Override
	public PatientRecord updateRecord(PatientRecord record) throws CustomizedException {
		try {
			Optional<PatientRecord> newRecord = recordRepository.findById(record.getRecordId());
			PatientRecord updatedRecord=newRecord.get();
			updatedRecord.setAppointmentId(record.getAppointmentId());
			updatedRecord.setDiagnostics(record.getDiagnostics());
			updatedRecord.setPatientId(record.getPatientId());
			updatedRecord.setPrescription(record.getPrescription());

			return updatedRecord;

		} catch (Exception e) {
			throw new CustomizedException("No record exist with"+ record.getRecordId());
		}
	}

	@Override
	public void deleteRecord(int recordId) throws CustomizedException {
		try {
			Optional<PatientRecord> newRecord = recordRepository.findById(recordId);
			if(newRecord.isPresent())
			{
				recordRepository.deleteById(recordId);
			}
			
		} catch (Exception e) {
			throw new CustomizedException("No record exist with");
		}
	}

}
