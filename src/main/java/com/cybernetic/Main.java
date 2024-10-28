package com.cybernetic;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args){
        OrganInventory inventory = new OrganInventory();

        CyberneticOrgan heart = new CyberneticOrgan(001, "CyberHeart", "Pumps blood",true);
        CyberneticOrgan eye = new CyberneticOrgan(002,"CyberEye", "Enhanced vision",true);
        CyberneticOrgan lungs = new CyberneticOrgan(003,"CyberLung", "Filters Air",false);
        inventory.addOrgan(heart);
        inventory.addOrgan(eye);
        inventory.addOrgan(lungs);

        System.out.println("Adding organs to inventory...");
        inventory.addOrgan(heart);
        System.out.println("Added: " + inventory.getOrgan("CyberHeart") + " to inventory.");
        inventory.addOrgan(eye);
        System.out.println("Added: " + inventory.getOrgan("CyberEye") + " to inventory.");
        inventory.addOrgan(lungs);
        System.out.println("Added: " + inventory.getOrgan("CyberLung") + " to inventory.");


        Patient patient = new Patient("John Doe", 55);
        System.out.println("Adding organs to patient " + patient.name + "...");
        System.out.println(patient.addOrgan(heart));
        System.out.println(patient.addOrgan(eye));
        System.out.println(patient.addOrgan(lungs));


        System.out.println("Listing installed organs for " + patient.name + ":");
        ArrayList<CyberneticOrgan> installedOrgans = patient.getOrganList();
        if (installedOrgans.isEmpty()) {
            System.out.println("No organs installed.");
        } else {
            for (CyberneticOrgan organ : installedOrgans) {
                System.out.println("- " + organ.getModel() + ": " + organ.getFunctionality());
            }
        }

        System.out.println("Searching for organs with functionality 'Enhanced vision'...");
        ArrayList<CyberneticOrgan> organSearch = inventory.searchOrganByFunctionality("Enhanced vision");
        System.out.println("Found " + inventory.getOrgan("CyberEye") + ": "+eye.getFunctionality());

        System.out.println("Sorting organs by model name in inventory...");
        ArrayList<CyberneticOrgan> sortedOrgans = inventory.sortOrgansByModel();
        System.out.println("Sorted organs!");
        for (CyberneticOrgan organ : sortedOrgans) {
            System.out.println("- " + organ.getModel() + ": " + organ.getFunctionality());
        }
    }
}
