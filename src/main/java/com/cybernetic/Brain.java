package com.cybernetic;

import java.util.Random;

public class Brain extends CyberneticOrgan {
    static  double brainControlEfficiency;
    public Brain(int organID, String organModel, String organFunctionality, boolean organIsCompatible) {
        super(organID, organModel, organFunctionality, organIsCompatible);
        this.brainControlEfficiency = 90;
    }

    public void controlEfficiencyUpdate(Brain brain){
        int max =1;
        int min = -2;
        Random random = new Random();
        int randomFluctuation = random.nextInt(max - min + 1) + min;
        this.brainControlEfficiency = this.brainControlEfficiency +(Lung.getCurrentOxygenLevel() / 20) -3 + randomFluctuation;
    }

    public static double getBrainControlEfficiency() {
        return brainControlEfficiency;
    }

    public void brainHealthUpdate(){
        double healthChange;
        healthChange = -1 + (Lung.getCurrentOxygenLevel() / 25) - 2;
        if ( healthChange == 0){
            System.out.println("Error!");
        }
        setHealth((int)(getHealth() + healthChange));//used ai
    }
}

