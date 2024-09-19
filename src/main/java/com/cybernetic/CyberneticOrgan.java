package com.cybernetic;

public class CyberneticOrgan {
    int id;
    String model;
    String functionality;
    boolean isCompatible;
    double health;


    public CyberneticOrgan(int organID, String organModel, String organFunctionality, boolean organIsCompatible){
        id = organID;
        model = organModel;
        functionality = organFunctionality;
        isCompatible = organIsCompatible;
        this.health = 100;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, Math.min(100, health)); // Ensure health is within bounds
    }

    public String getDetails(int id, String model, String functionality){
        this.id = id;
        this.model = model;
        this.functionality = functionality;
        return "Organ model: " + model +
                "\nOrgan ID: " + id +
                "\nFunctionality: " + functionality;
    }

    public String isCompatible(String patientCompatibility){
        return "Organ is compatible!";
    }

    public String getFunctionality(String organFunction){
        return functionality;
    }

    public String getModel(CyberneticOrgan organ){
        String organModel = organ.toString();
        return organModel;
    }
}
