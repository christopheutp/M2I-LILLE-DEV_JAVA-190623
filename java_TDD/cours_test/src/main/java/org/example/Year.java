package org.example;

public class Year {

    public boolean isLeap(int year) {
        /*if((year % 400) == 0 || (year%4==0 && year%100 != 0) || (year%4000==0)) {
            return true;
        }
        return false;*/
        return (year % 400) == 0 || (year%4==0 && year%100 != 0) || (year%4000==0);
    }
}
