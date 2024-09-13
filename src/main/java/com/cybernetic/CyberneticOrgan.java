package com.cybernetic;

public class CyberneticOrgan {
    //defining class with the following attributes
    int id;
    String model;
    String functionality;
    boolean isOrganCompatible;

    //method returning organs details
    public String getDetails(int id, String model, String functionality){
        this.id = id;
        this.model = model;
        this.functionality = functionality;
        String organDetails = "Organ id: " + id +
                "\nOrgan model: " + model +
                "\nFunctionality: " + functionality;
        return organDetails;
    }

    public String getModel() {
        return model;
    }

    public String getFunctionality() {
        return functionality;
    }

    //method to check if organ is compatible
    public void isCompatible(String patientCompatibility){
    }

}
