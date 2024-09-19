package com.cybernetic;
import java.util.ArrayList;
import java.util.Arrays;

//
public class Main {
    public static void main(String[] args) {
        OrganInventory inventory = new OrganInventory();


        CyberneticOrgan heart = new CyberneticOrgan(001, "CyberHeart", "Pumps blood",true);
        CyberneticOrgan eye = new CyberneticOrgan(002,"CyberEye", "Enhanced vision",true);
        CyberneticOrgan lungs = new CyberneticOrgan(003,"CyberLung", "Filters Air",false);
        //inventory.addOrgan(heart);
        //inventory.addOrgan(eye);
        //inventory.addOrgan(lungs);

        System.out.println("Adding organs to inventory...");
        inventory.addOrgan(heart);
        System.out.println("Added: " + inventory.getOrgan("CyberHeart") + " to inventory.");
        inventory.addOrgan(eye);
        System.out.println("Added: " + inventory.getOrgan("CyberEye") + " to inventory.");
        inventory.addOrgan(lungs);
        System.out.println("Added: " + inventory.getOrgan("CyberLung") + " to inventory.");


        Patient patient = new Patient("John Doe");
        System.out.println("Adding organs to patient " + patient.name + "...");
        System.out.println(patient.addOrgan(heart));
        System.out.println(patient.addOrgan(eye));
        System.out.println(patient.addOrgan(lungs));


        System.out.println("Listing installed organs for " + patient.name + ":");
        System.out.println(patient.getOrganList());

        System.out.println("Searching for organs with functionality 'Enhanced vision'...");
        ArrayList<CyberneticOrgan> organSearch = inventory.searchOrganByFunctionality("Enhanced vision");
        System.out.println("Found " + inventory.getOrgan("CyberEye") + ": "+eye.getFunctionality(": Enhanced Vision"));

        System.out.println("Sorting organs by model name in inventory...");
        //inventory.sortOrgansByModel();
        System.out.println("Sorted organs!");

        OrganSimulation simulation = new OrganSimulation();
        System.out.println("Initial States:");
        System.out.printf("Heart Health: "+ simulation.getHeart().getHealth());
        System.out.printf("Lung Health: "+ simulation.getLung().getHealth());
        System.out.printf("Brain Health: "+ simulation.getBrain().getHealth());
        System.out.println();

        simulation.run(0);


    }
}
