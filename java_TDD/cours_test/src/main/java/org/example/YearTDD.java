package org.example;

public class YearTDD {
    boolean isLeap(int year) {
        if(year%400 == 0)
            return true;
        if(year%4 == 0 && year%100 != 0)
            return true;
        return false;
    }
}
