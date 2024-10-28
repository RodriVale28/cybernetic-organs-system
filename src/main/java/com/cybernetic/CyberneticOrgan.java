package com.cybernetic;

public class CyberneticOrgan {
    int id;
    String model;
    String functionality;
    boolean isCompatible;
    String name;
    String compatibility;

    public CyberneticOrgan(int id, String model, String functionality, boolean isCompatible) {
        this.id = id;
        this.model = model;
        this.functionality = functionality;
        this.isCompatible = isCompatible;
        this.name = name;
        this.compatibility = compatibility;
    }

    public String getDetails(int id, String model, String functionality) {
        String details = "Organ ID: " + this.id +
                "\n Model: " + this.model +
                "\nFunctionality: " + this.functionality;
        return details;
    }

    public void isCompatible(){
        if(!isCompatible){
            System.out.println("Organ is not compatible!");
        }
        else{
            System.out.println("Organ is compatible!");
        }
    }

    public String getFunctionality(){
        return functionality;
    }

    public String getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public String getCompatibility() {
        return compatibility;
    }
}


