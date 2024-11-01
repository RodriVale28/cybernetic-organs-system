package com.cybernetic;

class CyberneticOrgan {
    private String name;
    private String bloodType;
    private static int weight;
    private String hlaType;

    public CyberneticOrgan(String name, String bloodType, int weight, String hlaType) {
        this.name = name;
        this.bloodType = bloodType;
        this.weight = weight;
        this.hlaType = hlaType;
    }



    public String getName() { return name; }
    public String getBloodType() { return bloodType; }
    public static int getWeight() { return weight; }
    public String getHlaType() { return hlaType; }


    public void getId() {
        int id;
    }

    public void getFunctionality() {
        String functionality;
    }
}

