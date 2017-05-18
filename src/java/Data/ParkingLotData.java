/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Customer;
import Domain.ParkingLot;
import Domain.Space;
import Domain.Vehicle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParkingLotData {

    static LinkedList<ParkingLot> parkingLots;
    static int parkingLotId = 1;
    final String jsonFilePath = "C:\\Users\\Julio\\Documents\\Base de datos parqueo\\parkingLots.json";

    public ParkingLotData() {

        parkingLots = new LinkedList<>();
    }

    public ParkingLot registerParkingLot(String nameOfParkingLot, Space spaces[]) {

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(parkingLotId);
        parkingLotId++;
        parkingLot.setName(nameOfParkingLot);
        parkingLot.setSpaces(spaces);

        parkingLots.add(parkingLot);

        return parkingLot;

    }

//    public void registerParkingLot(ParkingLot parkingLot) {
//
//        parkingLots.add(parkingLot);
//
//    }
    public int registerVehicleInParkingLot(Vehicle vehicle, ParkingLot parkingLot) {

        ArrayList<Vehicle> vehiclesInParkingLot = parkingLot.getVehicles();
        Space spaces[] = parkingLot.getSpaces();
        int spaceId = 0;
        //recorre la lista de vehículos para ver en qué posición
        //podemos ingresar al vehículo actual
        for (int i = 0; i < spaces.length; i++) {

            if (spaces[i].isSpaceTaken() == false) {

                //preguntamos si el cliente presenta una capacidad particular
                //y requiere de un espacio adaptado
                if (vehicle.getCustomer().getIsDisabilityPresented()) {

                    if (spaces[i].isDisabilityAdaptation()) {

                        //compara el tipo de vehículo del espacio y del vehículo que se va a 
                        //estacionar (tipos: moto, automóvil, bus, etc)
                        if (spaces[i].getVehicleType().getId() == vehicle.getVehiculeType().getId()) {
                            vehiclesInParkingLot.add(vehicle);
                            spaces[i].setSpaceTaken(true);
                            //este es el número del espacio que se va a retornar
                            spaceId = spaces[i].getId();
                            break;
                        }

                    }

                } else if (!spaces[i].isDisabilityAdaptation()) {
                    //compara el tipo de vehículo del espacio y del vehículo que se va a 
                    //estacionar (tipos: moto, automóvil, bus, etc)
                    if (spaces[i].getVehicleType().getId() == vehicle.getVehiculeType().getId()) {

                        vehiclesInParkingLot.add(vehicle);
                        spaces[i].setSpaceTaken(true);
                        //este es el número del espacio que se va a retornar
                        spaceId = spaces[i].getId();
                        break;
                    }

                }

            }

        }

        //*************actualizamos los espacios tomados
        //y los vehículos registrados en el parqueo
        parkingLot.setSpaces(spaces);
        parkingLot.setVehicles(vehiclesInParkingLot);

        return spaceId;
    }

    public void removeVehicleFromParkingLot(Vehicle vehicle, ParkingLot parkingLot) {

        ArrayList<Vehicle> vehiclesInParkingLot = parkingLot.getVehicles();
        Space spaces[] = parkingLot.getSpaces();
        int spaceId = 0;
        //recorre la lista de vehículos para ver en qué posición
        //debemos retirar al vehículo actual
        for (int i = 0; i < vehiclesInParkingLot.size(); i++) {

            if (vehiclesInParkingLot.get(i) == vehicle) {

                vehiclesInParkingLot.remove(vehicle);
                spaces[i].setSpaceTaken(false);
                break;
            }

        }
        //*************actualizamos los espacios liberados
        //y los vehículos registrados en el parqueo

        parkingLot.setSpaces(spaces);
        parkingLot.setVehicles(vehiclesInParkingLot);

    }

    public LinkedList<ParkingLot> getAllParkingLots() throws ParseException, org.json.simple.parser.ParseException {

        LinkedList<ParkingLot> parkingLotss = new LinkedList<>();
        ArrayList<JSONObject> jsonArray = new ArrayList<>();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(jsonFilePath);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);
                jsonArray.add(jsonObject);
                ParkingLot parkingLot = new ParkingLot();
                parkingLot.setName(jsonObject.get("name").toString());
                parkingLot.setId(1);
                parkingLot.setNumberOfSpaces(1);

                parkingLotss.add(parkingLot);
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + jsonFilePath + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + jsonFilePath + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return parkingLotss;
    }

    public ParkingLot findParkingLotById(int parkingLotId) {

        ParkingLot parkingLot = new ParkingLot();

        for (ParkingLot currentParkingLot : parkingLots) {

            if (currentParkingLot.getId() == parkingLotId) {

                parkingLot = currentParkingLot;
            }
        }
        return parkingLot;
    }

    public void insertParkingLotJSon(ParkingLot parkingLot) throws IOException {
        JSONObject customerObject = new JSONObject();
        customerObject.put("name", parkingLot.getName());
        customerObject.put("numberOfSpaces", parkingLot.getNumberOfSpaces());

        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(jsonFilePath, true)) {
            file.write(customerObject.toJSONString() + "\r\n");
        }

    }

    public void deleteParkingLot(String parkingLotName) throws ParseException {
        ///String ID = String.valueOf(id);
        try {

            JSONObject parkingLotObject;

            File file = new File(jsonFilePath);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("parkingLotsTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;

                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {

                    parkingLotObject = (JSONObject) new JSONParser().parse(line);

                    if (!parkingLotObject.get("name").toString().equals(parkingLotName)) {

                        printWriter.println(line);
                        printWriter.flush();
                    }
                }

                bufferedReader.close();
            }

            //Delete the original file
            if (!file.delete()) {

                //no se pudo eliminar el archivo
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(file)) {

            }

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    public ParkingLot getParkingLotByName(String name) throws ParseException {
        ParkingLot parkingLot = new ParkingLot();
        JSONObject jsonObject;
        //ParkingtLot parkingLot=new ParkingtLot();
        //  This will reference one line at a time
        String line = null;

        try {
            //FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(jsonFilePath);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);

                if (jsonObject.get("name").toString().equals(name)) {
                    parkingLot.setName(jsonObject.get("name").toString());
                    parkingLot.setId((int) (jsonObject.get("ID")));
                    parkingLot.setNumberOfSpaces((int) (jsonObject.get("numberOfSpaces")));

//                    parkingLotObject.put("spaces", parkingLot.getSpaces());
//                    parkingLotObject.put("vehicles", parkingLot.getVehicles()); //definir como implementar
                    System.out.println(parkingLot.toString());
                }

            }
            //  Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + jsonFilePath + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + jsonFilePath + "'");
            //  Or we could just do this: 
            ex.printStackTrace();
        }
        return parkingLot;
    }

    public void modifyParkingLotFromFile(String name, ParkingLot parkingLot) throws ParseException {
        try {

            JSONObject parkingLotObject;

            File file = new File(jsonFilePath);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("customersTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new 
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {

                parkingLotObject = (JSONObject) new JSONParser().parse(line);

                if (!parkingLotObject.get("name").toString().equals(name)) {

                    printWriter.println(line);
                    printWriter.flush();
                } else {

                    parkingLotObject.put("name", parkingLot.getName());
                    parkingLotObject.put("ID", parkingLot.getId());
                    parkingLotObject.put("numberOfSpaces", parkingLot.getNumberOfSpaces());

//                    parkingLotObject.put("spaces", parkingLot.getSpaces());
//                    parkingLotObject.put("vehicles", parkingLot.getVehicles()); //definir como implementar
//                    customerObject.put("password", customer.getPassword());
                    //customerObject.put("isGoldenCiticen", customer.getIsIsGoldenCiticen());
                    //customerObject.put("isDisabilityPresented", customer.getIsDisabilityPresented());
                    printWriter.println(parkingLotObject.toJSONString());
                }
            }

            bufferedReader.close();
            printWriter.close();

            //Delete the original file
            if (!file.delete()) {
                //no se pudo eliminar el archivo
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(file)) {

                //no se pudo renombrar el archivo
            }

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    public void insertParkingLotJson(ParkingLot parkingLot) throws IOException {
        JSONObject parkingLotObject = new JSONObject();
        parkingLotObject.put("name", parkingLot.getName());
        parkingLotObject.put("ID", parkingLot.getId());
        parkingLotObject.put("numberOfSpaces", parkingLot.getNumberOfSpaces());

        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(jsonFilePath, true)) {
            file.write(parkingLotObject.toJSONString() + "\r\n");
        }
        System.out.println("ALAN");
        System.out.println("ALAN");
        System.out.println("ALAN");
        System.out.println("ALAN");
        System.out.println("ALAN");
        System.out.println("ALAN");

    }

}
