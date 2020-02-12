package com.medicalApp.application;

import com.medicalApp.application.entities.Patient;
import com.medicalApp.application.repositories.PatientRepository;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(PatientRepository userRepository) {
        return args -> {
            Stream.of("Maria", "Prof Manuel", "Soraia").forEach(name -> {
                Patient patient = new Patient(name, 60);
                userRepository.save(patient);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
}