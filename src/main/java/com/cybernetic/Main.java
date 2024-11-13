package com.cybernetic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //A S S I G N M E N T 5
        // Create an instance of OrganInventory and add organs
/*
        System.out.println("Adding organs to inventory...");

        // build the organ inventory from buildOrganInventory method then add the organs to the inventory
        List<CyberneticOrgan> organs = buildOrganInventory();
        OrganInventory inventory = new OrganInventory();
        for (CyberneticOrgan organ : organs) {
            inventory.addOrgan(organ);
        }

        System.out.println("Sorting inventory by name, model, and compatibility...Using Collection.sort");
        long startTime = System.nanoTime();
        List<CyberneticOrgan> sortedOrgans = inventory.sortOrganByNameModelAndCompatibilityUsingBuiltInSort();
        System.out.println("Time taken to sort using collection.sort: " + (System.nanoTime() - startTime) + "ns");

        System.out.println("Sorting inventory by name, model, and compatibility...Using QuickSort");
        startTime = System.nanoTime();
        sortedOrgans = inventory.quickSortOrganByNameModelAndCompatibility(inventory.getOrganList());
        System.out.println("Time taken to sort using quicksort: " + (System.nanoTime() - startTime) + "ns");
        //Then write the sorted inventory to the new csv file.
        writeOrganInventory(sortedOrgans);

        System.out.println("Sorted inventory written to file.");


    }

    private static void writeOrganInventory(List<CyberneticOrgan> sortedOrgans) {
        //write the sorted inventory to a new csv file
        String csvFile = "src/main/resources/sorted-organ-list.csv";
        try (PrintWriter writer = new PrintWriter(csvFile)) {
            writer.write("Model,Name,Functionality,Compatibility\n");
            for (CyberneticOrgan organ : sortedOrgans) {
                //write in this order name,model,functionality,compatibility
                writer.write(organ.getName() + "," + organ.getModel() + "," + organ.getFunctionality() + "," + organ.getCompatibility() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static List<CyberneticOrgan> buildOrganInventory() {
        //read the csv file
        String csvFile = "src/main/resources/sample-organ-list.csv";
        String line;
        String cvsSplitBy = ",";
        List<CyberneticOrgan> inventory = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // skip the header
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] organ = line.split(cvsSplitBy);
                CyberneticOrgan newOrgan = new CyberneticOrgan(organ[1].trim(), organ[0].trim(), organ[2].trim(), organ[3].trim());
                inventory.add(newOrgan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }
*/
        //ASSIGNMENT 6
        OrganCompatibilityAnalyzer inventory = new OrganCompatibilityAnalyzer();

        // Add sample organs
        inventory.addOrgan(new CyberneticOrgan("O1", "A+", 300, "1-2-3-4-5-6"));
        inventory.addOrgan(new CyberneticOrgan("O2", "O-", 280, "1-3-5-7-9-11"));

        // Add sample patients
        inventory.addPatient(new Patient("P1", "A+", 70, "1-2-3-4-5-6"));
        inventory.addPatient(new Patient("P2", "B-", 80, "2-4-6-8-10-12"));
        inventory.addPatient(new Patient("P3", "O+", 65, "1-3-5-7-9-11"));

        int[][] compatibilityMatrix = inventory.createCompatibilityMatrix();
        inventory.displayMatrix(compatibilityMatrix);

        double[] weights = {0.4, 0.3, 0.3}; // Blood type, Weight, HLA
        inventory.displayWeightMatrix(weights);

        double[][] weightedMatrix = inventory.calculateWeightedCompatibility(weights);
        inventory.displayWeightedMatrix(weightedMatrix);

        System.out.println("\nIn this output:");
        System.out.println("- Rows represent organs (O1, O2, ...)");
        System.out.println("- Columns represent patients (P1, P2, ...)");
        System.out.println("- In the initial matrix, every 3 columns represent blood type, weight, and HLA compatibility for each patient");
        System.out.println("- In the final matrix, each cell represents the overall weighted compatibility score between an organ and a patient");
        System.out.println("- The weighted compatibility score is calculated by multiplying each factor's score by its corresponding weight and summing the results");
    }
}



