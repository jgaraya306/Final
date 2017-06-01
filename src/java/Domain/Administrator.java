/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Data.AdminData;

/**
 *
 * @author Esteban
 */
public class Administrator extends User implements Employee {

//    private Date startDate;
//    private HashMap schedule;
    AdminData adminData;

    public Administrator() {
        super();
        adminData = new AdminData();
    }

    public Administrator(String identification, String name, String username, String password, String address) {
        super(identification, name, username, password, address);

    }

    public AdminData getAdminData() {
        return adminData;
    }

    public void setAdminData(AdminData adminData) {
        this.adminData = adminData;
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
