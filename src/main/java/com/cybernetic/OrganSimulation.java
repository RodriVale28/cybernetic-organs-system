package com.cybernetic;

import java.util.Random;

public class OrganSimulation {
    final int max_steps = 100;
    Heart heart;
    Lung lung;
    Brain brain;

    public OrganSimulation() {
        heart = new Heart(1, "Heart", "Pumps blood", true);
        lung = new Lung(2, "Lung", "Filters air", true);
        brain = new Brain(3, "Brain", "Control Center", true);
    }

    public Heart getHeart() {
        return heart;
    }

    public Brain getBrain(){
        return brain;
    }

    public Lung getLung(){
        return lung;
    }

    //used ai for the run method and recursive method
    public void run(int steps){
        if(max_steps > 100){
            System.out.println("Simulation Ended!");
        }

        heart.pumpRateUpdate(brain.getBrainControlEfficiency());
        lung.oxygenLevelUpdate(heart);
        brain.controlEfficiencyUpdate(lung);

        heart.heartHealthUpdate(lung);
        lung.lungHealthUpdate(heart);
        brain.brainHealthUpdate(lung);

        if (new Random().nextDouble() < 0.10) {
            RandomEventNotification(steps);
        }
        perStepOutput(steps);
        run(steps + 1);

    }

    public void RandomEventNotification(int steps) {
        Random random = new Random();
        int organSelection = random.nextInt(3);
        int randomHealthChange = random.nextInt(21) - 10;

        //used ai for switch statement
        switch (organSelection) {
            case 0:
                heart.setHealth(heart.getHealth() + randomHealthChange);
                break;
            case 1:
                lung.setHealth(lung.getHealth() + randomHealthChange);
                break;
            case 2:
                brain.setHealth(brain.getHealth() + randomHealthChange);
                break;
        }
        System.out.println("Random Event!");
        System.out.println("At time step: " + steps);
        System.out.println("For organ: " + organSelection);
        System.out.println("Health change: " + randomHealthChange);
    }

    public void HealthCheck(){
        if(lung.getHealth() < 25){
            System.out.println("Lung health in critical condition!" + lung.getHealth());
        }
        if(heart.getHealth() < 25){
            System.out.println("Heart health in critical condition!" + heart.getHealth());
        }
        if(brain.getHealth() < 25){
            System.out.println("Brain health in critical condition!" + brain.getHealth());
            System.out.println();
        }
    }

    private void perStepOutput(int steps) {
        System.out.println("Time: "+ steps);
        System.out.println("Heart Health: " + heart.getHealth() + "| Pump Rate: "+ heart.getCurrentHeartPumpRate());
        System.out.println("Lung Health: " + lung.getHealth() + "| Oxygen Level: " + lung.getCurrentOxygenLevel());
        System.out.println("Brain Health: " + brain.getHealth() +  "| Control Efficiency: " + brain.getBrainControlEfficiency());
    }

    private void printFinalSummary(int step) {
        System.out.println("Simulation Ended:");
        System.out.println("Time: "+ step);
        System.out.println("Heart Health: "+ heart.getHealth());
        System.out.println("Lung Health: "+ lung.getHealth());
        System.out.println("Brain Health: "+ brain.getHealth());

        if ((heart.getHealth() <= 0) || (lung.getHealth() <= 0) || (brain.getHealth() <= 0)) {
            System.out.println("Simulation Result: Failure");
        } else {
            System.out.println("Simulation Result: Success");
        }
    }
}

