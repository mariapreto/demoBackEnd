package com.medicalApp.application.repositories;

import com.medicalApp.application.entities.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>{}