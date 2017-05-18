/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Esteban
 */
public class Clerk extends User implements Employee{

    private String dailySalary;

    public Clerk() {
    }
    
    
    
    public Clerk(String dailySalary, ParkingLot placeOfWork, String identification, String name, String username, String password, String address) {
        super(identification, name, username, password, address);
        this.dailySalary=dailySalary;
       
    }

    public String getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(String dailySalary) {
        this.dailySalary = dailySalary;
    }

    @Override
    public boolean verifyUserLogin(String[] loginDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float calculateSalary(float dailySalary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ParkingLot assignWorkplace(int parkingLotId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}