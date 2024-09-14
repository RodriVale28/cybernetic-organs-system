package com.cybernetic;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        OrganInventory inventory = new OrganInventory();

        CyberneticOrgan heart = new CyberneticOrgan(001, "CyberHeart", "Pumps blood",true);
        CyberneticOrgan eye = new CyberneticOrgan(002,"CyberEye", "Enhanced vision",true);
        CyberneticOrgan lungs = new CyberneticOrgan(003,"CyberLung", "Filters Air",false);
        inventory.addOrgan(heart);
        inventory.addOrgan(eye);
        inventory.addOrgan(lungs);

        System.out.println("Adding organs to inventory...");
        inventory.addOrgan(heart);
        System.out.println("Added " + heart.getModel(heart) + " to inventory.");
        inventory.addOrgan(eye);
        System.out.println("Added " + eye.getModel(eye) + " to inventory.");
        inventory.addOrgan(lungs);
        System.out.println("Added " + eye.getModel(lungs) + " to inventory.");

        Patient patient = new Patient("John Doe");
        System.out.println("Adding organs to patient " + patient.name + "...");
        System.out.println("Added " + heart.getModel(heart) + " to " + patient.name + "'s installed organs.");
        System.out.println("Added " + eye.getModel(eye) + " to " + patient.name + "'s installed organs.");

        System.out.println("Listing installed organs for " + patient.name + ":");
        ArrayList<CyberneticOrgan> installedOrgans = patient.getOrganList();

        System.out.println("Searching for organs with functionality 'Enhanced vision'...");
        ArrayList<CyberneticOrgan> organSearch = inventory.searchOrganByFunctionality("Enhanced vision");
        System.out.println("Found " + organSearch.size() + " organ(s):");

        System.out.println("Sorting organs by model name in inventory...");
        System.out.println("Sorted organs:");
        inventory.sortOrgansByModel();

    }
}
