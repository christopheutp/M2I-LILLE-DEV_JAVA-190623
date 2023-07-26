package org.example;

import org.example.exercices.watertank.WaterTank;

public class AppWaterTank {
    public static void main(String[] args) {
        WaterTank waterTank1 = new WaterTank(100,10,5);
        WaterTank waterTank2 = new WaterTank(70,25,15);
        System.out.println("Poid total watertank 1 : "+waterTank1.poidTotal());
        System.out.println("Poid total watertank 2 : "+waterTank2.poidTotal());
        System.out.println(WaterTank.volumeTotal);


       // waterTank1.getVolume();
        System.out.println(waterTank1.getVolume());
        System.out.println(waterTank2.getVolume());

        waterTank1.remplir(35);
        waterTank2.vider(20);

        System.out.println(WaterTank.volumeTotal);
        System.out.println(waterTank1.getVolume());
        System.out.println(waterTank2.getVolume());


        waterTank1.remplir(5);
        waterTank2.vider(10);

        System.out.println(WaterTank.volumeTotal);
        System.out.println(waterTank1.getVolume());
        System.out.println(waterTank2.getVolume());
        System.out.println("Poid total watertank 1 : "+waterTank1.poidTotal());
        System.out.println("Poid total watertank 2 : "+waterTank2.poidTotal());



    }


}
