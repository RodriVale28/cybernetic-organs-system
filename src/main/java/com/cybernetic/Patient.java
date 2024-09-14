package com.cybernetic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Patient {
        String name;
        int age;
        String medicalHistory;
        CyberneticOrgan[] installedOrgans = {};
        CyberneticOrgan[] patientsOrgans;
        int organCount;


    public Patient(String patientName){
        installedOrgans = new CyberneticOrgan [5];
        this.name = patientName;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    public void addOrgan(CyberneticOrgan organ){
        if (organCount < installedOrgans.length) {
            installedOrgans[organCount++] = organ;
            System.out.println("Organ added successfully");
        } else {
            System.out.println("No space available to add more organs.");
        }
        }

    public ArrayList<CyberneticOrgan> getOrganList(){
        return new ArrayList<CyberneticOrgan>(List.of(installedOrgans));
    }

    public String getPatientInfo(String name, int age, String medicalHistory, CyberneticOrgan[] installedOrgans){
        return "Patient's name: " + name +
                "\nPatient's age: " + age +
                "\nMedical History: " + medicalHistory +
                "\nInstalled Organs: " + Arrays.toString(installedOrgans);

    }
}