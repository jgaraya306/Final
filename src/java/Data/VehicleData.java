/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Customer;
import Domain.ParkingLot;
import Domain.Vehicle;
import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class VehicleData {

    static ArrayList<Vehicle> vehicles;

    public VehicleData() {

        vehicles = new ArrayList<>();
    }

    public Vehicle insertVehicle(Vehicle vehicle) {

        vehicles.add(vehicle);

        return vehicle;
    }

    public void removeVehicle(Vehicle vehicle) {

        vehicles.remove(vehicle);

    }

    public ArrayList<Vehicle> getAllVehicles() {

        return vehicles;
    }

    //este método encuentra el vehicle de un cliente
    public Vehicle findVehicleByCustomer(Customer customer) {

        Vehicle vehicle = new Vehicle();

        for (int i = 0; i < vehicles.size(); i++) {

            //comparamos cada cliente de los vehículos
            //con el cliente pasado por parámetro
            if (vehicles.get(i).getCustomer().equals(customer)) {

                //cliente asociado al vehículo fue encontrado
                //por ende, vamos a retornar el vehículo
                vehicle = vehicles.get(i);

            }
        }

        /* for (Vehicle currentVehicle : vehicles) {
            
            if (currentVehicle.getCustomer().equals(customer)) {
                
                //cliente asociado al vehículo fue encontrado
                //por ende, vamos a retornar el vehículo
                vehicle=currentVehicle;
                   
            }
        }*/
        return vehicle;

    }

    public ArrayList<Vehicle> findVehiclesByParkingLot(ParkingLot parkingLot) {

        return parkingLot.getVehicles();
    }

}
