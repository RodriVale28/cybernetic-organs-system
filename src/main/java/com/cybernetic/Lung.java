package com.cybernetic;

import java.util.Random;

public class Lung extends CyberneticOrgan {
    static double currentOxygenLevel;

    public Lung(int organID, String organModel, String organFunctionality, boolean organIsCompatible) {
        super(organID, organModel, organFunctionality, organIsCompatible);
        this.currentOxygenLevel = 95;
    }

    public void oxygenLevelUpdate(Lung lung){
        int max =1;
        int min = -2;
        Random random = new Random();
        int randomFluctuation = random.nextInt(max - min +1) + min;
        this.currentOxygenLevel = this.currentOxygenLevel + (Heart.getCurrentHeartPumpRate() + 20) -3 + randomFluctuation;
    }

    public static double getCurrentOxygenLevel() {
        return currentOxygenLevel;
    }

    public void lungHealthUpdate(){
        double healthChange;
        healthChange = -1 + (Heart.getCurrentHeartPumpRate() / 25) - 2;
        if ( healthChange == 0){
            System.out.println("Error!");
        }
        setHealth((int)(getHealth() + healthChange));//used ai
    }
}
