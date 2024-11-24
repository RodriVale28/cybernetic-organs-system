package com.cybernetic;

import java.util.ArrayList;
import java.util.Map;

public class Patient {
    String name;
    int age;
    String medicalHistory;
    CyberneticOrgan[] installedOrgans = {};
    int organCount;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.installedOrgans = new CyberneticOrgan[5];
        organCount = 0;
    }

    public String addOrgan(CyberneticOrgan organ) {
        if (organCount < installedOrgans.length) {
            installedOrgans[organCount] = organ;
            organCount++;
            return "Successfully added: " + organ.getDetails(organ.id, organ.model, organ.functionality);
        }
        return "Not enough space!";
    }

    public String patientInfo() {
        String details = "Patient's name: " + name +
                "\n Patient age: " + age +
                "\n Installed organs: " + installedOrgans;
        return details;
    }

    public ArrayList<CyberneticOrgan> getOrganList() {
        ArrayList<CyberneticOrgan> organList = new ArrayList<>();
        for (int i = 0; i < organCount; i++) {
            organList.add(installedOrgans[i]);
        }
        return organList;
    }

    public String getBloodType() {
        String bloodType = "";
        return bloodType;
    }

    public int getWeight() {
        int weight = 0;
        return weight;

    }

    public String getHlaType() {
        String hlaType = " ";
        return hlaType;
    }

    public void getName() {
        String name;
    }

    public void getId() {
        int id;
    }

    @Setter(AccessLevel.NONE)
    private PatientHistory history;
    public void addMedicalEvent(String medicalEvent) {
        this.history.addMedicalEvent(medicalEvent);
    }

    public String removeMostRecentEvent() {
        return this.history.removeMostRecentEvent();
    }


    public PatientHistory getHistory() {
        PatientHistory medHistory = null;
        return medHistory;
    }

    public Map<String, Double> getMeasurements() {
    }
}

