package com.cybernetic;
import java.util.ArrayList;
import java.util.Collections;

public class OrganInventory {
    //defining with attributes
    //int [] inventory = {};
    ArrayList<String> organs = new ArrayList<>();

    //method to add new organ to inventory
    public String addOrgan(CyberneticOrgan organ){
        organs.add(String.valueOf(organ));
        return "Organ added to the inventory!";
    }

    //method to retrieve organ from inventory
    public String getOrgan(String model){
        for(int i= 0 ; i < organs.size(); i++) {
            if (!organs.contains(model)) {
                System.out.println("Organ not found!");
            } else {
                organs.remove(model);
            }
        }
        return "Organ found and successfully removed!";
    }

    public ArrayList<CyberneticOrgan> searchOrganByFunctionality(String functionality) {
        ArrayList<CyberneticOrgan> organFunctionality = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (organs.getFunctionality().equalsIgnoreCase(functionality)) {
                organFunctionality.add(organs);
            }
        }
        return organFunctionality;
    }



    public String sortOrgansByModel(){
        Collections.sort(organs);
        return String.valueOf(organs);
    }

        }