package com.slokam.patient.service;

import com.slokam.patient.entity.Patient;
import com.slokam.patient.exception.ValidationException;

public interface IPatientService {

	public void savePatient(Patient patient) throws ValidationException;
		

}
