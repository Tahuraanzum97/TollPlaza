package com.example.tollplazamanagmentsystem;

public class TollRate {
    private String vehicleType;
    private String rate ;

    public TollRate(String vehicleType, String rate) {
        this.vehicleType = vehicleType;
        this.rate = rate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "TollRate{" +
                "vehicleType='" + vehicleType + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
