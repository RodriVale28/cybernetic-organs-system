package com.cybernetic;

class CyberneticOrgan {
    private String name;
    private String bloodType;
    private int weight;
    private String hlaType;

    public CyberneticOrgan(String name, String bloodType, int weight, String hlaType) {
        this.name = name;
        this.bloodType = bloodType;
        this.weight = weight;
        this.hlaType = hlaType;
    }

    public String getName() { return name; }
    public String getBloodType() { return bloodType; }
    public int getWeight() { return weight; }
    public String getHlaType() { return hlaType; }
}

