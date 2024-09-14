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
        else{
            organsInInventory.add(organ);
            System.out.println("Organ added to the inventory!");
        }
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
        return "confirmation message";
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
        // Sort the list in place using a Comparator
        Collections.sort(organsInInventory, new Comparator<CyberneticOrgan>() {
            @Override
            public int compare(CyberneticOrgan o1, CyberneticOrgan o2) {
                return o1.getModel(organ).compareTo(o2.getModel(organ));//
            }
        });
        // Return the sorted list
        return organsInInventory;
    }

}