package com.cybernetic;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        OrganInventory inventory = new OrganInventory();
        Patient patient = new Patient("Jane Doe");

        // Create some CyberneticOrgans
        CyberneticOrgan heart = new CyberneticOrgan("CyberHeartX1", "Pumps blood");
        CyberneticOrgan eye = new CyberneticOrgan("CyberEyeV2", "Enhanced vision");

        // Add organs to the inventory
        System.out.println("Adding organs to inventory...");
        inventory.addOrgan(heart);
        System.out.println("Added " + heart.getModel() + " to inventory.");
        inventory.addOrgan(eye);
        System.out.println("Added " + eye.getModel() + " to inventory.");

        // Add organs to the patient
        System.out.println("Adding organs to patient " + patient.getName() + "...");
        String addResult = patient.addOrgan(heart);
        System.out.println("Added " + heart.getModel() + " to " + patient.getName() + "'s installed organs.");
        addResult = patient.addOrgan(eye);
        System.out.println("Added " + eye.getModel() + " to " + patient.getName() + "'s installed organs.");

        // List installed organs for the patient
        System.out.println("Listing installed organs for " + patient.getName() + ":");
        ArrayList<CyberneticOrgan> installedOrgans = patient.getOrganList();
        for (CyberneticOrgan organ : installedOrgans) {
            System.out.println("- " + organ.getModel() + ": " + organ.getFunctionality());
        }

        // Search for organs with specific functionality
        System.out.println("Searching for organs with functionality 'Enhanced vision'...");
        ArrayList<CyberneticOrgan> searchResult = inventory.searchOrganByFunctionality("Enhanced vision");
        System.out.println("Found " + searchResult.size() + " organ(s):");
        for (CyberneticOrgan organ : searchResult) {
            System.out.println("- " + organ.getModel() + ": " + organ.getFunctionality());
        }

        // Sort organs by model name
        System.out.println("Sorting organs by model name in inventory...");
        inventory.sortOrgansByModel();
        System.out.println("Sorted organs:");
        ArrayList<CyberneticOrgan> sortedOrgans = inventory.getOrganList();
        for (CyberneticOrgan organ : sortedOrgans) {
            System.out.println("- " + organ.getModel());
        }

    }
}
