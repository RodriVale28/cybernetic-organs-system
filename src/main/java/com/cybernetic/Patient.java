package com.cybernetic;

import java.util.ArrayList;

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
        organCount =0;
    }

    public String addOrgan(CyberneticOrgan organ) {
        if (organCount < installedOrgans.length) {
            installedOrgans[organCount] = organ;
            organCount++;
            return "Successfully added: " + organ.getDetails(organ.id,organ.model, organ.functionality);
        }
        return "Not enough space!";
    }

    public String patientInfo(){
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
}
