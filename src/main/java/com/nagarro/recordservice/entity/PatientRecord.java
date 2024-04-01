package com.nagarro.recordservice.entity;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class PatientRecord 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recordId;               ///have choose wrapper class coz we cant have 0 but can have null val

    private int appointmentId;

    private int patientId;

    private String prescription;

    private String diagnostics;
}
