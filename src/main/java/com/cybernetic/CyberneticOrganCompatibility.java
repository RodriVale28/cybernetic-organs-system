package com.cybernetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CyberneticOrganCompatibility {
    private List<String> incompatibility;

    public CyberneticOrganCompatibility() {
        this.incompatibility = new ArrayList<>();
    }

    public boolean isCompatible(Patient patient, CyberneticOrgan organ, DiagnosticDecisionTree diagnosticTree) {
        Map<String, Double> patientMeasurements = patient.getMeasurements();
        String diagnosis = diagnosticTree.diagnosePatient(patientMeasurements);

        // Check the diagnostic outcome
        if ("Inconclusive".equals(diagnosis)) {
            incompatibility.add("Diagnostic Tree Result: Inconclusive");
        }

        for (Map.Entry<Object, Object> entry : organ.getRequiredRanges().entrySet()) {
            String measurementType = (String) entry.getKey();
            Double requiredValue = (Double) entry.getValue();
            if (!patientMeasurements.containsKey(measurementType) || patientMeasurements.get(measurementType) != requiredValue) {
                incompatibility.add(measurementType + " out of range: " + patientMeasurements.get(measurementType) + " (required: " + requiredValue + ")");
            }
        }

        return incompatibility.isEmpty();
    }

    public List<String> getIncompatibilityReasons() {
        return incompatibility;
    }
}
