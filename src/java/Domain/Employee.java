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
public interface Employee {
    
    
     float calculateSalary(float dailySalary);
     ParkingLot assignWorkplace(int parkingLotId);
    
    
}
