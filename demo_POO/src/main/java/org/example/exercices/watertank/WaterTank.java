package org.example.exercices.watertank;

public class WaterTank {
    private double poids;
    private double volumeMax;
    private double volume;

    public static double volumeTotal = 0;


    public WaterTank(double poids, double volumeMax, double volume) {
        this.poids = poids;
        this.volumeMax = volumeMax;
        this.volume = volume;
        WaterTank.volumeTotal += volume;
    }

    public void remplir(double volume){
        if((volume + this.volume) <= volumeMax){
            this.volume += volume;
            WaterTank.volumeTotal += volume;
        }
    }

    public void vider(double volume){
        if(this.volume >= volume){
            this.volume -= volume;
            WaterTank.volumeTotal -= volume;
        }

    }

    public double getVolume() {
        return volume;
    }

    public double poidTotal(){
        return poids + volume;
    }


}
