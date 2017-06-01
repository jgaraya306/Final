/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.CustomerData;
import Data.ParkingLotData;
import Domain.Customer;
import Domain.ParkingLot;
import Domain.Space;
import java.io.IOException;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Allan
 */
public class ParkingLotBusiness {

    ParkingLotData parkingLotData;

    public ParkingLotBusiness() {
        parkingLotData = new ParkingLotData();
    }

    public void insertCustomer(ParkingLot parkingLot) throws IOException {
        String numberTxt = Integer.toString(parkingLot.getNumberOfSpaces());
        String numberId = Integer.toString(parkingLot.getId());
        //regla de negocio de no permitir datos en blanco. Todos son requeridos.
        // if (!parkingLot.getName().equals("")&&!numberTxt.equals("")&&!numberId.equals("") ) {

        parkingLotData.insertParkingLotJSon(parkingLot);
        // }
    }

    public LinkedList<ParkingLot> getAllParkingLots() throws ParseException {
        return parkingLotData.getAllParkingLots();
    }

    public void deleteParkingLots(String parkingLotName) throws ParseException {
        parkingLotData.deleteParkingLot(parkingLotName);//hacer el delete parking
    }

    public ParkingLot getParkingLotByName(String parkingLotName) throws ParseException {

        ParkingLot parkingLot = new ParkingLot();
        parkingLot = parkingLotData.getParkingLotByName(parkingLotName);// hacer metodo getParkingLot
        return parkingLot;
    }

    public void modifyParkingLot(String name, ParkingLot parkingLot) throws ParseException {
        parkingLotData.modifyParkingLotFromFile(name, parkingLot);//to do metodo modify
    }

    public void insertParkingLot(ParkingLot parkingLot) throws IOException {
        parkingLotData.insertParkingLotJson(parkingLot);
        String id = String.valueOf(parkingLot.getId());
        String numberOfSpaces = String.valueOf(parkingLot.getNumberOfSpaces());

        if (!id.equals("") && parkingLot.getName().equals("") && numberOfSpaces.equals("")) {
            
        }
    }
    
    public LinkedList<Space> createSpaces(int id,int numberOfSpaces, int spacesDisability){
        return parkingLotData.createSpaces(id, numberOfSpaces, spacesDisability);
    }
}
