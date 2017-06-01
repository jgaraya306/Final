/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Allan
 */
public class Tariff {
private float priceHalfHour;
private float priceOneHour;
private float pricePerDay;
private float pricePerWeek;
private float pricePerMonth;
private float pricePerYear;
private int id;
private String vehicleType;
//private static int contador=1;
    public Tariff(int id, float priceHalfHour, float priceOneHour, float pricePerDay,float pricePerWeek, float pricePerMonth, float pricePerYear, String vehicleType) {
        this.priceHalfHour = priceHalfHour;
        this.priceOneHour = priceOneHour;
        this.pricePerDay = pricePerDay;
        this.pricePerWeek=pricePerWeek;
        this.pricePerMonth = pricePerMonth;
        this.pricePerYear = pricePerYear;
        this.vehicleType = vehicleType;
        this.id=id;
    }

    public Tariff() {
        
    }

    
    
    public float getPricePerWeek() {
        return pricePerWeek;
    }

    public void setPricePerWeek(float pricePerWeek) {
        this.pricePerWeek = pricePerWeek;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public float getPriceHalfHour() {
        return priceHalfHour;
    }

    public void setPriceHalfHour(float priceHalfHour) {
        this.priceHalfHour = priceHalfHour;
    }

    public float getPriceOneHour() {
        return priceOneHour;
    }

    public void setPriceOneHour(float priceOneHour) {
        this.priceOneHour = priceOneHour;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public float getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(float pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public float getPricePerYear() {
        return pricePerYear;
    }

    public void setPricePerYear(float pricePerYear) {
        this.pricePerYear = pricePerYear;
    }

    public String getVehicleType() {
    return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

}
