package com.medicalApp.application.controllers;

import com.medicalApp.application.entities.Patient;
import com.medicalApp.application.repositories.PatientRepository;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return (List<Patient>) patientRepository.findAll();
    }

   @GetMapping("/patient")
    public Patient getPatient(@RequestBody int id) {
        return patientRepository.findById(Long.valueOf(id)).orElse(null);
    }

    @PostMapping("/patients")
    void addPatient(@RequestBody Patient patient) {
        patientRepository.save(patient);
    }

    @PostMapping("/patients/delete/{patientId}")
    void deletePatient(@RequestBody int id){
        Patient patient = getPatient(id);
        patientRepository.delete(patient);
    }

    @GetMapping("/patients/?name={term}")
    public List<Patient> searchPatients(@RequestBody String term){
        return (List<Patient>) patientRepository.findAll();
    }
}