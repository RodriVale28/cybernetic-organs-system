package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrganCompatibilityAnalyzer {
    private List<CyberneticOrgan> organs;
    private List<Patient> patients;

    public OrganCompatibilityAnalyzer() {
        organs = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addOrgan(CyberneticOrgan organ) {
        organs.add(organ);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public int[][] createCompatibilityMatrix() {
        int[][] matrix = new int[organs.size()][patients.size() * 3]; // 3 factors: blood type, weight, HLA

        //TODO:  Calculate compatibility for each organ-patient pair
        for (int i = 0; i < organs.size(); i++) {
            CyberneticOrgan organ = organs.get(i);
            for (int j = 0; j < patients.size(); j++) {
                Patient patient = patients.get(j);
                //used ai
                matrix[i][j * 3] = calculateBloodTypeCompatibility(organ.getBloodType(), patient.getBloodType());
                matrix[i][j * 3 + 1] = calculateWeightCompatibility(organ.getWeight(), patient.getWeight());
                matrix[i][j * 3 + 2] = calculateHlaCompatibility(organ.getHlaType(), patient.getHlaType());
            }
        }
        return matrix;
    }

    private int calculateBloodTypeCompatibility(String donorType, String recipientType) {
        //TODO: Calculate compatibility for each organ-patient pair based on compatibility calculation rules.
        if (donorType.equals(recipientType)) {
            return 100;
        } else if (donorType.equals("O")) {
            return 80; // Universal donor, can donate to any
        } else if (donorType.equals("A") && (recipientType.equals("A") || recipientType.equals("AB"))) {
            return 80; // A can donate to A and AB
        } else if (donorType.equals("B") && (recipientType.equals("B") || recipientType.equals("AB"))) {
            return 80; // B can donate to B and AB
        } else if (donorType.equals("AB") && recipientType.equals("AB")) {
            return 80; // AB can only donate to AB
        }
        return 0;
    }

    private int calculateWeightCompatibility(int organWeight, int patientWeight) {
        //TODO: Calculate compatibility for each organ-patient pair based on compatibility calculation rules.
        int weight = organWeight / (patientWeight * 1000);
        if (weight >= 0.8 && weight <= 1.2) {
            return 100;
        } else if (weight >= 0.6 && weight <= 1.4) {
            return 50;
        }
        return 0;
    }

    private int calculateHlaCompatibility(String organHla, String patientHla) {
        //TODO: Calculate compatibility for each organ-patient pair based on compatibility calculation rules.
        int count = 0;
        for (int i = 0; i < Math.min(organHla.length(), patientHla.length()); i++) {
            if (organHla.charAt(i) == patientHla.charAt(i)) {
                count++;
            }
        }
        return (count * 100) / Math.max(organHla.length(), patientHla.length());
    }

    public double[][] calculateWeightedCompatibility(double[] weights) {
        int[][] compatibilityMatrix = createCompatibilityMatrix();
        double[][] resultMatrix = new double[organs.size()][patients.size()];

        //TODO: calculate the weighted compatibility for each organ-patient pair
        for (int i = 0; i < organs.size(); i++) {
            for (int j = 0; j < patients.size(); j++) {
                int bloodScore = compatibilityMatrix[i][j * 3];
                int weightScore = compatibilityMatrix[i][j * 3 + 1];
                int hlaScore = compatibilityMatrix[i][j * 3 + 2];

                resultMatrix[i][j] = (bloodScore * weights[0]) + (weightScore * weights[1]) + (hlaScore * weights[2]);
            }
        }
        return resultMatrix;
    }


    public void displayMatrix(int[][] matrix) {
        System.out.println("Initial Compatibility Matrix:");

        //TODO: complete the displayMatrix method to display the initial compatibility matrix
        System.out.print("     "); // Initial space for patient headers
        for (int j = 0; j < patients.size(); j++) {
            System.out.printf(j + 1);
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.printf(i + 1); // Organ header
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void displayWeightMatrix(double[] weights) {
        System.out.println("\nWeight Matrix:");
        for (double weight : weights) {
            System.out.printf(weight);
        }
        System.out.println();
    }

    public void displayWeightedMatrix(double[][] matrix) {
        System.out.println("\nFinal Weighted Compatibility Matrix:");
        System.out.print("     ");
        //TODO: complete the displayWeightedMatrix method to display the final weighted compatibility matrix
        for (int j = 0; j < patients.size(); j++) {
            System.out.printf(j + 1);
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.printf(i + 1); // Organ header
            for (double score : matrix[i]) {
                System.out.printf(score);
            }
            System.out.println();
        }
    }
}
