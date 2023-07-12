package com.slokam.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.patient.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long>{

	public Patient findByNameAndPhone(String name,Long phone); //this query used to validate data.
}
