/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.VehicleData;
import Domain.Clerk;
import Domain.Customer;
import Domain.Vehicle;
import java.io.IOException;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Allan
 */
public class VehicleBusiness {

    VehicleData vehicleData;

    public VehicleBusiness() {
        vehicleData =new VehicleData();
    }

    public void insertVehicle(Vehicle vehicle) throws IOException {
        //regla de negocio de no permitir datos en blanco. Todos son requeridos.

        if (!vehicle.getVehicleType().equals("")&&!vehicle.getBrand().equals("") && !vehicle.getColor().equals("")
                && !vehicle.getModel().equals("") && !vehicle.getPlate().equals("")
                && !vehicle.getIdCustomer().equals("")) {
            vehicleData.insertVehicleJson(vehicle);
        }
    }

    public void deleteCustomer(String idCustomer) throws ParseException {
           vehicleData.deleteVehicle(idCustomer);
    }

   public LinkedList<Vehicle> getAllVehicles() throws ParseException, java.text.ParseException {
        return vehicleData.getAllVehicles();
    
   }
    public Vehicle getVehiclebyID(String idCustomer) throws ParseException {
       return vehicleData.getVehiclebyID(idCustomer);
    }

    public void modifyVehicle(String customerID, Vehicle vehicle) throws ParseException {
         vehicleData.modifyVehicleFromFile(customerID, vehicle);
    }
}
