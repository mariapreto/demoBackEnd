package com.medicalApp.application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String name;
    private final int age;
    
    public Patient() {
        this.name = "";
        this.age = 0;
    }
    
    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }
}