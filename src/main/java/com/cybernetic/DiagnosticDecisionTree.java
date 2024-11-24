package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DiagnosticDecisionTree {
    private DiagnosticNode root;
    private List<String> diagnosticPath;

    public DiagnosticDecisionTree() {
        this.root = null;
        this.diagnosticPath = new ArrayList<>();
    }

    public void addDiagnosticCriteria(String measurementType, double threshold, String diagnosis) {
        root = addDiagnosticCriteriaRecursive(root, measurementType, threshold, diagnosis);
    }

    private DiagnosticNode addDiagnosticCriteriaRecursive(DiagnosticNode node, String measurementType, double threshold, String diagnosis) {
        if (node == null) {
            return new DiagnosticNode(measurementType, threshold, diagnosis);
        }

        if (threshold < node.thresholdValue) {
            node.left = addDiagnosticCriteriaRecursive(node.left, measurementType, threshold, diagnosis);
        } else {
            node.right = addDiagnosticCriteriaRecursive(node.right, measurementType, threshold, diagnosis);
        }

        return node;
    }

    public String diagnosePatient(Map<String, Double> measurements) {
        diagnosticPath.clear();
        return diagnosePatientRecursive(root, measurements);
    }

    private String diagnosePatientRecursive(DiagnosticNode node, Map<String, Double> measurements) {
        if (node == null) {
            return "Inconclusive";
        }

        String measurementType = node.measurementType;
        double measurement = measurements.getOrDefault(measurementType, Double.NaN);

        diagnosticPath.add("Level " + (diagnosticPath.size() + 1) + ": " + measurementType + " = " + measurement + (measurement < node.thresholdValue ? " < " : " ≥ ") + node.thresholdValue);

        if (node.diagnosis != null) {
            return node.diagnosis;
        }

        if (measurement < node.thresholdValue) {
            return diagnosePatientRecursive(node.left, measurements);
        } else {
            return diagnosePatientRecursive(node.right, measurements);
        }
    }

    public List<String> getDiagnosticPath() {
        return diagnosticPath;
    }

    public void printTree() {
        printTreeRecursive(root, "", true);
    }

    private void printTreeRecursive(DiagnosticNode node, String indent, boolean last) {
        if (node == null) return;

        System.out.println(indent + (last ? "└── " : "├── ") + node.measurementType + " (" + node.thresholdValue + ")");
        printTreeRecursive(node.left, indent + (last ? "    " : "│   "), false);
        printTreeRecursive(node.right, indent + (last ? "    " : "│   "), true);
    }

}
