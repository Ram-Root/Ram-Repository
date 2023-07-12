package com.slokam.patient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.patient.entity.Patient;
import com.slokam.patient.exception.ValidationException;
import com.slokam.patient.service.IPatientService;

@RestController
@RequestMapping("patient")
public class PatientController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private IPatientService patientService;
	
	@Autowired
	private MailSender mailsender;
	
	@PostMapping()
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) throws ValidationException{
		
		LOGGER.trace("Enter into savePatient");
		patientService.savePatient(patient);
		ResponseEntity<Patient> re  = ResponseEntity.ok().body(patient);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo("ramramkrishna350@gmai.com");
		mailMessage.setSubject("Testing");
		mailMessage.setText("Hello how are you I am from Slokam Tech.");
		mailsender.send(mailMessage);
		
		LOGGER.trace("Exit from savePatient");
		return re;
	}
	
}
