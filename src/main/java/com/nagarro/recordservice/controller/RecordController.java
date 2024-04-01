package com.nagarro.recordservice.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.recordservice.entity.PatientRecord;
import com.nagarro.recordservice.exceptions.CustomizedException;
import com.nagarro.recordservice.service.impl.RecordServiceImpl;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordServiceImpl recordService;

    public  RecordController(RecordServiceImpl recordService) {
        this.recordService = recordService;
    }
    
    @PostMapping
    public ResponseEntity<PatientRecord> createRecord(@RequestBody PatientRecord record) {
    	PatientRecord recordResponse = recordService.createRecord(record);
		return new ResponseEntity<PatientRecord>(recordResponse, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<PatientRecord>> fetchRecordForPatient(@PathVariable int patientId) {
        List<PatientRecord> patientRecords =recordService.getRecordByPatientId(patientId);
        return new ResponseEntity<>(patientRecords, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<PatientRecord> getRecordById(@PathVariable int recordId) throws CustomizedException {
        PatientRecord record = recordService.getRecordByRecordId(recordId);
        return new ResponseEntity<>(record, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PatientRecord> updateRecord(@RequestBody PatientRecord record) throws CustomizedException {
        PatientRecord updatedRecord = recordService.updateRecord(record);
        return new ResponseEntity<>(updatedRecord, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{recordId}/delete")
    public ResponseEntity<Void> deleteRecord(@PathVariable int recordId) throws CustomizedException {
        recordService.deleteRecord(recordId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
