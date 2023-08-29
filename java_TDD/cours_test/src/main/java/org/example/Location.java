package org.example;

import org.example.exception.ConditionException;

public class Location {

    public void dailyRoutine(Voiture voiture) {
        int c =0;
        if(voiture.getCondition()<=0 || voiture.getCondition()>=100){
            throw new ConditionException();
        }
        if(voiture.getType().equals("luxe")){
            c = -1;
        }else if(voiture.getType().equals("old")){
            if(voiture.getRentDueIn()<=0){
                c = (voiture.getCondition() >= 4)? 4 : voiture.getCondition();
            }else{
                c = (voiture.getCondition() >= 2)? 2 : voiture.getCondition();
            }
        }else{
            if(voiture.getRentDueIn()<=0){
                c = (voiture.getCondition() >= 2)? 2 : voiture.getCondition();
            }else{
                c = 1;
            }
        }


        voiture.setCondition(voiture.getCondition() - c);
        voiture.setRentDueIn(voiture.getRentDueIn() - 1);
    }
}