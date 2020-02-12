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
    public List<Patient> getUsers() {
        return (List<Patient>) patientRepository.findAll();
    }

    @PostMapping("/patients")
    void addUser(@RequestBody Patient patient) {
        patientRepository.save(patient);
    }
}