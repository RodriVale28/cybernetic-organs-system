package com.cybernetic;

import java.util.ArrayList;
import java.util.Arrays;

public class Patient {
    //defining class with the following attributes
    String name;
    int age;
    String medicalHistory;
    String [] installedOrgans =new String[5];
    private CyberneticOrgan[] installedOrgans;
    private int organCount;

    public Patient() {
        installedOrgans = new CyberneticOrgan[5]; // Fixed capacity of 5 organs
        organCount = 0;
    }

    //methods that adds organ to patients list of organs
    public String addOrgan(CyberneticOrgan organ) {
        if (organCount < installedOrgans.length) {
            installedOrgans[organCount++] = organ;
            return "Organ added successfully.";
        } else {
            return "No space available to add more organs.";
        }
    }

    public ArrayList<CyberneticOrgan> getOrganList() {
        ArrayList<CyberneticOrgan> organList = new ArrayList<>();
        for (int i = 0; i < organCount; i++) {
            organList.add(installedOrgans[i]);
        }
        return organList;
    }

    //method with patients details
    public String getPatientInfo(String name, int age, String medicalHistory, String [] installedOrgans){
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.installedOrgans = installedOrgans;
        String patientDetails = "com.cyberorgansystem.Patient's name: " + name +
                "\ncom.cyberorgansystem.Patient's age: " + age +
                "\nMedical History: " + medicalHistory +
                "\nInstalled Organs: " + Arrays.toString(installedOrgans);
        return patientDetails;

    }
}

