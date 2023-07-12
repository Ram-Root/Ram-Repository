package com.slokam.patient.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.patient.entity.Patient;
import com.slokam.patient.exception.ValidationException;
import com.slokam.patient.repo.PatientRepo;
import com.slokam.patient.service.IPatientService;
@Service
public class PatientServiceImpl implements IPatientService{
	
	private static Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);
	
	@Autowired
	private PatientRepo patientrepo;
	
	@Override
	public void savePatient(Patient patient) throws ValidationException{
		
		LOGGER.trace("Entered into savePatient");
		
		Patient  patient2 = patientrepo.findByNameAndPhone(patient.getName(), patient.getPhone());
		
		LOGGER.debug("PatientData:"+patient2);
		if(patient2==null  || (patient.getId()!=null && (patient2.getId() == patient.getId()))) {
			LOGGER.info("validation pass, saving the data");
		patientrepo.save(patient);
	}
		else {
			LOGGER.warn("Validation fail, raising the exception.");
			throw new ValidationException("patient details existed.");
		}
		LOGGER.trace("Exit from savePatient");
	}

	
}
