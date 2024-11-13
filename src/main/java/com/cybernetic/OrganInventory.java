package com.cybernetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    public List<CyberneticOrgan> sortOrganByNameModelAndCompatibilityUsingBuiltInSort() {
        List<CyberneticOrgan> sortedList = new ArrayList<>(organInventory);
        Collections.sort(sortedList, new Comparator<CyberneticOrgan>() {
            @Override
            public int compare(CyberneticOrgan o1, CyberneticOrgan o2) {
                return 0;
            }

            @Override
            public int compare(CyberneticOrgan o1, CyberneticOrgan o2) {
                int nameCompare = o1.getName().compareTo(o2.getName());
                if (nameCompare != 0) return nameCompare;
                int modelCompare = o1.getModel().compareTo(o2.getModel());
                if (modelCompare != 0) return modelCompare;
                return o1.getCompatibility().compareTo(o2.getCompatibility());
            }
        });
        return sortedList;
    }

    // QuickSort
    public List<CyberneticOrgan> quickSortOrganByNameModelAndCompatibility(List<CyberneticOrgan> unmodifiableOrganList) {
        List<CyberneticOrgan> organList = new ArrayList<>(unmodifiableOrganList); // Copy to mutable list
        quickSort(organList, 0, organList.size() - 1);
        return organList; // Return sorted list
    }

    private void quickSort(List<CyberneticOrgan> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private int partition(List<CyberneticOrgan> list, int low, int high) {
        CyberneticOrgan pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compareOrgan(list.get(j), pivot) <= 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }



    private int compareOrgan(CyberneticOrgan o1, CyberneticOrgan o2) {
        int nameCompare = o1.getName().compareTo(o2.getName());
        if (nameCompare != 0) return nameCompare;
        int modelCompare = o1.getModel().compareTo(o2.getModel());
        if (modelCompare != 0) return modelCompare;
        return o1.getCompatibility().compareTo(o2.getCompatibility());
    }

}
