package com.appcellon.coronatracker.models;

public class LocationStats {
    private String province;
    private String country;
    private int latestCaseTotal;
    private int prevDayTotal;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestCaseTotal() {
        return latestCaseTotal;
    }

    public void setLatestCaseTotal(int latestCaseTotal) {
        this.latestCaseTotal = latestCaseTotal;
    }

    public int getPrevDayTotal() {
        return prevDayTotal;
    }

    public void setPrevDayTotal(int prevDayTotal) {
        this.prevDayTotal = prevDayTotal;
    }

    @Override
    public String toString() {
        return "LocationStats{" + "province='" + province + '\'' + "country='" + country + '\'' + "latestCaseTotal='"
                + latestCaseTotal + '\'' + "}";
    }
}
