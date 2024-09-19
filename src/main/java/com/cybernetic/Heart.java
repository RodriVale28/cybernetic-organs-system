package com.cybernetic;
import java.util.Random;
public class Heart extends CyberneticOrgan {
    static double currentHeartPumpRate;
    public Heart(int organID, String organModel, String organFunctionality, boolean organIsCompatible) {
        super(organID, organModel, organFunctionality, organIsCompatible);
        this.currentHeartPumpRate = 70;
    }

    public void pumpRateUpdate(Heart heart){
        int max= 3;
        int min= -4;
        Random random = new Random();
        int randomFluctuation = random.nextInt(max - min + 1) + min;
        this.currentHeartPumpRate = this.currentHeartPumpRate + (Brain.getBrainControlEfficiency() / 10) -5 + randomFluctuation;
    }

    public static double getCurrentHeartPumpRate() {
        return currentHeartPumpRate;
    }

    public void heartHealthUpdate(){
        double healthChange;
        healthChange = -1 + (Lung.getCurrentOxygenLevel() / 25) - 2;
        if ( healthChange == 0){
            System.out.println("Error!");
        }
        setHealth((int)(getHealth() + healthChange));//used ai
    }
}
