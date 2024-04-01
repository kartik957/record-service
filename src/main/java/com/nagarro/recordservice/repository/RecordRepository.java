package com.nagarro.recordservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.recordservice.entity.PatientRecord;

public interface RecordRepository extends JpaRepository<PatientRecord, Integer>
{
    public List<com.nagarro.recordservice.entity.PatientRecord> findByPatientId(int patientId);
}
