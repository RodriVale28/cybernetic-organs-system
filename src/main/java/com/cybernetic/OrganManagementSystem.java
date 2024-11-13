package com.cybernetic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

    public class OrganManagementSystem {
        private List<CyberneticOrgan> organs;
        private List<Patient> patients;

        public OrganManagementSystem(List<CyberneticOrgan> organs, List<Patient> patients) {
            this.organs = organs;
            this.patients = patients;
        }

        public Set<String> getUniqueBloodTypes() {
            //TODO: Implement this method
            Set<String> uniqueBloodTypes = new HashSet<>();

            // Add blood types from organs
            organs.forEach(organ -> uniqueBloodTypes.add(organ.getBloodType()));

            // Add blood types from patients
            patients.forEach(patient -> uniqueBloodTypes.add(patient.getBloodType()));

            return uniqueBloodTypes;
        }

        public Map<String, List<Patient>> groupPatientsByBloodType() {
            //TODO: Implement this method
            return patients.stream()
                    .collect(Collectors.groupingBy(Patient::getBloodType));
        }

        public List<CyberneticOrgan> sortOrgansByWeight() {
            //TODO: Implement this method
            return organs.stream()
                    .sorted(Comparator.comparingInt(CyberneticOrgan::getWeight))
                    .collect(Collectors.toList());
        }



        public List<CyberneticOrgan> getTopCompatibleOrgans(Patient patient, int n) {
            //TODO: Implement this method
            return organs.stream()
                    .map(organ -> new AbstractMap.SimpleEntry<>(organ, calculateCompatibilityScore(organ, patient)))
                    .sorted((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()))
                    .limit(n)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }

