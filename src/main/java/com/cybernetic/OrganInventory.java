package com.cybernetic;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrganInventory {
        ArrayList<CyberneticOrgan> organsInInventory = new ArrayList<>();

    public OrganInventory(){
        //organsInInventory = organListing;
        this.organsInInventory = new ArrayList<>();
    }

    public void addOrgan(CyberneticOrgan organ){
        if(organsInInventory == null){
            System.out.println("Cannot add organ to the inventory!");
        }
            organsInInventory.add(organ);
    }

    public ArrayList<CyberneticOrgan> getOrganList(){
        return new ArrayList<CyberneticOrgan>(organsInInventory);
    }

    public String removeOrgan(String model){
        for(int i = 0; i < organsInInventory.size(); i++){
            if(organsInInventory.contains(model)){
                organsInInventory.remove(model);
            }
            else{
                System.out.println("Organ not found in Inventory!");
            }
        }
        return "Organ successfully removed!";
    }

    public String getOrgan(String model){
        return  model;
    }

    //USED AI TOOL(CHATGPT) FOR THE IF CONDITION OF THE SEARCHORGANSBYFUNCTIONALITY 09/13*******
    public ArrayList<CyberneticOrgan> searchOrganByFunctionality(String functionality){
        ArrayList<CyberneticOrgan> organsByFunctionality = new ArrayList<>();
        for(int i = 0; i < organsInInventory.size(); i++){
            CyberneticOrgan organ = organsInInventory.get(i);
            if(organ.getFunctionality(" ").equals(functionality)){
                organsByFunctionality.add(organ);
            }

        }
        return organsByFunctionality;
    }

    //USED AI Tool (ChatGPT) FOR THE SORTORGANSBYMODEL METHOD 09/13********
    public ArrayList<CyberneticOrgan> sortOrgansByModel() {
        Collections.sort(organsInInventory, new Comparator<CyberneticOrgan>() {
            @Override
            public int compare(CyberneticOrgan o1, CyberneticOrgan o2) {
                // Comparing the model of o1 with respect to o2
                return o1.getModel(o1).compareTo(o2.getModel(o2));
            }
        });

        return organsInInventory;
    }
    }

