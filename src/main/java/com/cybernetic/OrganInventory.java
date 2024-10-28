package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrganInventory {
    ArrayList<CyberneticOrgan> organInventory = new ArrayList<>();

    public OrganInventory() {
        this.organInventory = new ArrayList<>();
    }

    public void addOrgan(CyberneticOrgan organ){
        if(organInventory == null){
            System.out.println("Cannot add organ to the inventory!");
        }
        organInventory.add(organ);
    }

    public String getOrgan(String model){
        return  model;
    }

    public ArrayList<CyberneticOrgan> getOrganList(){
        return organInventory;
    }

    public String removeOrgan(String model){
        for(int i = 0; i < organInventory.size(); i++){
            if(organInventory.contains(model)){
                organInventory.remove(model);
            }
            else{
                System.out.println("Organ not found in Inventory!");
            }
        }
        return "Organ successfully removed!";
    }

    public ArrayList<CyberneticOrgan> searchOrganByFunctionality(String functionality){
        ArrayList<CyberneticOrgan> organsByFunctionality = new ArrayList<>();
        for(int i = 0; i < organInventory.size(); i++){
            CyberneticOrgan organ = organInventory.get(i);
            if(organ.getFunctionality().equals(functionality)){
                organsByFunctionality.add(organ);
            }

        }
        return organsByFunctionality;
    }

    public ArrayList<CyberneticOrgan> sortOrgansByModel() {
        Collections.sort(organInventory, new Comparator<CyberneticOrgan>() {
            @Override
            public int compare(CyberneticOrgan o1, CyberneticOrgan o2) {
                return o1.getModel().compareTo(o2.getModel());
            }
        });
        return organInventory; // Return the sorted list
    }


    //assignment 5
    public void sortOrganByNameModelAndCompatibilityUsingBuiltInSort() {
        Collections.sort(organInventory, new Comparator<CyberneticOrgan>() {
            @Override
            public int compare(CyberneticOrgan o1, CyberneticOrgan o2) {
                int nameComparison = o1.getName().compareTo(o2.getName());
                if (nameComparison != 0) {
                    return nameComparison;
                }
                int modelComparison = o1.getModel().compareTo(o2.getModel());
                if (modelComparison != 0) {
                    return modelComparison;
                }
                return o1.getCompatibility().compareTo(o2.getCompatibility());
            }
        }
        );
    }

    public void quickSortOrganByNameModelAndCompatibility(ArrayList<CyberneticOrgan> unmodifiableOrganList){

    }

}
