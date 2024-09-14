package com.cybernetic;

public class CyberneticOrgan {
    int id;
    String model;
    String functionality;
    boolean isCompatible;
//
    public CyberneticOrgan(int organID, String organModel, String organFunctionality, boolean organIsCompatible){
        id = organID;
        model = organModel;
        functionality = organFunctionality;
        isCompatible = organIsCompatible;
    }

    public String getDetails(int id, String model, String functionality){
        this.id = id;
        this.model = model;
        this.functionality = functionality;
        return "Organ id: " + id +
                "\nOrgan model: " + model +
                "\nFunctionality: " + functionality;
    }

    public String isCompatible(String patientCompatibility){
        return "Organ is compatible!";
    }

    public String getFunctionality(String organFunction){
        return functionality;
    }

    public String getModel(CyberneticOrgan organ){
       return "Organ Model: ";
    }
}
