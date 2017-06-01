/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.ParkingLot;
import Domain.Space;
import Domain.Vehicle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParkingLotData {

    SpaceData spaceData;
    static LinkedList<ParkingLot> parkingLots;
    static int parkingLotId = 1;
    final String jsonFilePath = "C:\\Users\\Julio\\Documents\\Base de datos parqueo\\parkingLots.json";

    public ParkingLotData() {
        spaceData = new SpaceData();
        parkingLots = new LinkedList<>();
    }

    public ParkingLot registerParkingLot(String nameOfParkingLot, LinkedList<Space> spaces) {

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(parkingLotId);
        parkingLotId++;
        parkingLot.setName(nameOfParkingLot);
        parkingLot.setSpaces(spaces);

        parkingLots.add(parkingLot);

        return parkingLot;

    }

    public int registerVehicleInParkingLot(Vehicle vehicle, ParkingLot parkingLot) {

        ArrayList<Vehicle> vehiclesInParkingLot = parkingLot.getVehicles();
        LinkedList<Space> spaces = parkingLot.getSpaces();
        int spaceId = 0;
        //recorre la lista de vehículos para ver en qué posición
        //podemos ingresar al vehículo actual
        for (int i = 0; i < spaces.size(); i++) {

            if (spaces.get(i).isSpaceTaken() == false) {

                //preguntamos si el cliente presenta una capacidad particular
                //y requiere de un espacio adaptado
                //***************Preguntamos si el customer ocupa un espacio preferencial
                if (vehicle.getIdCustomer().equals("")) {

                    if (spaces.get(i).isDisabilityAdaptation()) {

                        //compara el tipo de vehículo del espacio y del vehículo que se va a 
                        //estacionar (tipos: moto, automóvil, bus, etc)
                        //************************El veihcle type de space es un string
//                        if (spaces.get(i).getVehicleType().getId() == vehicle.getVehiculeType().getId()) {
//                            vehiclesInParkingLot.add(vehicle);
//                            spaces.get(i).setSpaceTaken(true);
//                            //este es el número del espacio que se va a retornar
//                            spaceId = spaces.get(i).getId();
//                            break;
//                        }
                    }

                } else if (!spaces.get(i).isDisabilityAdaptation()) {
                    //compara el tipo de vehículo del espacio y del vehículo que se va a 
                    //estacionar (tipos: moto, automóvil, bus, etc)

                    //************************El veihcle type de space es un string
//                    if (spaces.get(i).getVehicleType().getId() == vehicle.getVehiculeType().getId()) {
//
//                        vehiclesInParkingLot.add(vehicle);
//                        spaces.get(i).setSpaceTaken(true);
//                        //este es el número del espacio que se va a retornar
//                        spaceId = spaces.get(i).getId();
//                        break;
//                    }
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
        LinkedList<Space> spaces = parkingLot.getSpaces();
        int spaceId = 0;
        //recorre la lista de vehículos para ver en qué posición
        //debemos retirar al vehículo actual
        for (int i = 0; i < vehiclesInParkingLot.size(); i++) {

            if (vehiclesInParkingLot.get(i) == vehicle) {

                vehiclesInParkingLot.remove(vehicle);
                spaces.get(i).setSpaceTaken(false);
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
                parkingLot.setId(Integer.parseInt(jsonObject.get("ID").toString()));
                parkingLot.setNumberOfSpaces(Integer.parseInt(jsonObject.get("numberOfSpaces").toString()));
                parkingLot.setCeiling(Boolean.parseBoolean(jsonObject.
                        get("ceiling").toString()));

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

    public void insertParkingLotJSon(ParkingLot parkingLot) throws IOException {
        JSONObject customerObject = new JSONObject();
        customerObject.put("name", parkingLot.getName());
        customerObject.put("numberOfSpaces", parkingLot.getNumberOfSpaces());
        customerObject.put("ID", parkingLot.getId());
        customerObject.put("cieling", parkingLot.isCeiling());

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
                    parkingLot.setId(Integer.parseInt(jsonObject.get("ID").toString()));
                    parkingLot.setNumberOfSpaces(Integer.parseInt(jsonObject.get("numberOfSpaces").toString()));

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

    public ParkingLot getParkingLotById(String id) throws ParseException {
        ParkingLot parkingLot = new ParkingLot();
        JSONObject jsonObject;
        String line = null;

        try {
            //FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(jsonFilePath);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);

                if (jsonObject.get("ID").toString().equals(id)) {
                    parkingLot.setName(jsonObject.get("name").toString());
                    parkingLot.setId(Integer.parseInt(jsonObject.get("ID").toString()));
                    parkingLot.setNumberOfSpaces(Integer.parseInt(jsonObject.get("numberOfSpaces").toString()));
                    // parkingLot.set

//                    parkingLotObject.put("spaces", parkingLot.getSpaces());
//                    parkingLotObject.put("vehicles", parkingLot.getVehicles()); //definir como implementar
                    // System.out.println(parkingLot.toString());
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
                    parkingLotObject.put("ceiling", parkingLot.isCeiling());
                    parkingLotObject.put("numberOfSpaces", parkingLot.getNumberOfSpaces());

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
        parkingLotObject.put("ceiling", parkingLot.isCeiling());

        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(jsonFilePath, true)) {
            file.write(parkingLotObject.toJSONString() + "\r\n");
        }

    }

    public LinkedList<Space> createSpaces(int id, int numberOfSpaces, int spacesDisability) {

        LinkedList<Space> spacesOfParkingLot = new LinkedList<>();
        for (int i = 1; i <= numberOfSpaces; i++) {
            Space space = new Space();
            if (i <= spacesDisability) {
                space.setDisabilityAdaptation(true);
            } else {
                space.setDisabilityAdaptation(false);
            }
            space.setId(i);
            space.setIdParking(id);
            space.setIdCustomer(0);
            spacesOfParkingLot.add(space);
            try {
                spaceData.insertSpaceJSon(space);
            } catch (IOException ex) {
                Logger.getLogger(ParkingLotData.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return spacesOfParkingLot;
    }

    public void PrintParkingLotPDF() throws FileNotFoundException, DocumentException, ParseException {
        System.out.println("Entro a imprimir PDF");
        String FilePath = "C:\\Users\\Allan\\Desktop\\customers";
        JFileChooser dlg = new JFileChooser(FilePath);
        File f = dlg.getSelectedFile();
        String f1 = String.valueOf(f);
        String contenido = PrintParkingLots();
        FileOutputStream fos = new FileOutputStream("parqueos .pdf");
        Document doc = new Document();
        PdfWriter.getInstance(doc, fos);
        doc.open();
        doc.add(new Paragraph(contenido));

        //llena el pdf con el TextArea
        doc.close();
    }

    public ParkingLot[] getAllParkingLotsArray() throws ParseException {

        ParkingLot[] parkingLotsArray = new ParkingLot[getAllParkingLots().size()];

        for (int i = 0; i < parkingLotsArray.length; i++) {

            parkingLotsArray[i] = getAllParkingLots().get(i);
        }
        return parkingLotsArray;

    }

    public String PrintParkingLots() throws ParseException, FileNotFoundException, DocumentException {
        ParkingLot parkingLotArry[] = getAllParkingLotsArray();
        String output = "\n\n\nInformación de los clientes registrados\n\n";
        int num = 1;
        for (ParkingLot parkingLotsArray : parkingLotArry) {
            ParkingLot parkingLot = (ParkingLot) parkingLotsArray;

            output += num + "- " + parkingLot.getName() + "\t" + parkingLot.getId() + "\t" + parkingLot.getNumberOfSpaces() + "\t" + "\n";

            num++;
        }
        return output;
    }
}
