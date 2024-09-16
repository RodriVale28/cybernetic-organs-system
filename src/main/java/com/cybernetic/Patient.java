package com.cybernetic;
import java.util.ArrayList;
import java.util.Arrays;

public class Patient {
    String name;
    int age;
    String medicalHistory;
    CyberneticOrgan[] installedOrgans = {};
    CyberneticOrgan[] patientsOrgans;
    int organCount;


    public Patient(String patientName) {
        this.installedOrgans = new CyberneticOrgan[5];
        this.name = patientName;
        this.age = age;
        this.medicalHistory = medicalHistory;
        organCount = 0;
    }

    public String addOrgan(CyberneticOrgan organ) {
            if (organCount < installedOrgans.length) {
                    installedOrgans[organCount] = organ;
                    organCount++;
                return "Successfully added: " + organ.getDetails(organ.id,organ.model, organ.functionality);
        }
        return "Not enough space!";
    }



        public ArrayList<CyberneticOrgan> getOrganList (){
            ArrayList<CyberneticOrgan> newList = new ArrayList<>(Arrays.asList(installedOrgans));
            for (int i = 0; i < newList.size(); i++) {
                newList.get(i);
            }
            return newList;
        }

        public String getPatientInfo (String name,int age, String medicalHistory, CyberneticOrgan[]installedOrgans){
            return "Patient's name: " + name +
                    "\nPatient's age: " + age +
                    "\nMedical History: " + medicalHistory +
                    "\nInstalled Organs: " + Arrays.toString(installedOrgans) +
                    "\n";

        }
    }
