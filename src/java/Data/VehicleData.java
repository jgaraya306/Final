/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import static Data.CustomerData.customers;
import Domain.Customer;
import Domain.ParkingLot;
import Domain.Vehicle;
import Domain.VehicleType;
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

/**
 *
 * @author Esteban
 */
public class VehicleData {

    final String jsonFilePath = "C:\\Users\\Julio\\Documents\\Base de datos parqueo\\vehicles.json";
    static ArrayList<Vehicle> vehicles;
    VehicleType vehicleType;

    Customer customer;

    public VehicleData() {
        vehicleType = new VehicleType();
        vehicles = new ArrayList<>();

        customer = new Customer();
    }

    public void insertVehicleJson(Vehicle vehicle) throws IOException {
        JSONObject vehicleObject = new JSONObject();
        vehicleObject.put("type", vehicle.getVehicleType());
        vehicleObject.put("plate", vehicle.getPlate());
        vehicleObject.put("color", vehicle.getColor());
        vehicleObject.put("brand", vehicle.getBrand());
        vehicleObject.put("model", vehicle.getModel());
        vehicleObject.put("idCustomer", vehicle.getIdCustomer());

        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(jsonFilePath, true)) {
            file.write(vehicleObject.toJSONString() + "\r\n");
        }
    }

    public Vehicle insertVehicle(Vehicle vehicle) {

        vehicles.add(vehicle);

        return vehicle;
    }

    public LinkedList<Vehicle> getAllVehicles() throws ParseException {
        LinkedList<Vehicle> vehicles = new LinkedList<>();
        // ArrayList<JSONObject> jsonArray = new ArrayList<>();
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
                //jsonArray.add(jsonObject);

                Vehicle vehicle = new Vehicle();

                vehicle.setIdCustomer(jsonObject.get("idCustomer").toString());
                vehicle.setVehicleType(jsonObject.get("type").toString());
                vehicle.setPlate(jsonObject.get("plate").toString());
                vehicle.setColor(jsonObject.get("color").toString());
                vehicle.setBrand(jsonObject.get("brand").toString());
                vehicle.setModel(jsonObject.get("model").toString());

                vehicles.add(vehicle);
            }
            bufferedReader.close();
            // Always close files.
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VehicleData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VehicleData.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Or we could just do this:
        // ex.printStackTrace();
        return vehicles;
    }

    //este método encuentra el vehicle de un cliente
    public Vehicle findVehicleByCustomer(Customer customer) {

        Vehicle vehicle = new Vehicle();

        for (int i = 0; i < vehicles.size(); i++) {

            //comparamos cada cliente de los vehículos
            //con el cliente pasado por parámetro
            if (vehicles.get(i).getIdCustomer().equals(customer)) {

                //cliente asociado al vehículo fue encontrado
                //por ende, vamos a retornar el vehículo
                vehicle = vehicles.get(i);

            }


            /* for (Vehicle currentVehicle : vehicles) {
            
            if (currentVehicle.getCustomer().equals(customer)) {
                
                //cliente asociado al vehículo fue encontrado
                //por ende, vamos a retornar el vehículo
                vehicle=currentVehicle;
                   
            }
        }*/
        }
        return vehicle;
    }

    public ArrayList<Vehicle> findVehiclesByParkingLot(ParkingLot parkingLot) {

        return parkingLot.getVehicles();
    }

    public void deleteVehicle(String idCustomer) throws ParseException {

        try {

            JSONObject vehicleObject;

            File file = new File(jsonFilePath);

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("vehiclesTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;

                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {

                    vehicleObject = (JSONObject) new JSONParser().parse(line);

                    if (!vehicleObject.get("idCustomer").toString().equals(idCustomer)) {

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

    public Vehicle getVehiclebyID(String idCustomer) throws ParseException {
        Vehicle vehicle = new Vehicle();
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

                if (jsonObject.get("idCustomer").toString().equals(idCustomer)) {

                    vehicle.setVehicleType(jsonObject.get("type").toString());
                    vehicle.setPlate(jsonObject.get("plate").toString());
                    vehicle.setColor(jsonObject.get("color").toString());
                    vehicle.setBrand(jsonObject.get("brand").toString());
                    vehicle.setModel(jsonObject.get("model").toString());
                    vehicle.setIdCustomer(jsonObject.get("idCustomer").toString());

                }

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
        return vehicle;
    }

    public void modifyVehicleFromFile(String customerID, Vehicle vehicle) throws ParseException {

        try {

            JSONObject vehicleObject;

            File file = new File(jsonFilePath);

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("vehiclesTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {

                vehicleObject = (JSONObject) new JSONParser().parse(line);

                if (!vehicleObject.get("idCustomer").toString().equals(customerID)) {

                    printWriter.println(line);
                    printWriter.flush();
                } else {
                    vehicleObject.put("type", vehicle.getVehicleType());
                    vehicleObject.put("plate", vehicle.getPlate());
                    vehicleObject.put("color", vehicle.getColor());
                    vehicleObject.put("brand", vehicle.getBrand());
                    vehicleObject.put("model", vehicle.getModel());
                    vehicleObject.put("idCustomer", vehicle.getIdCustomer());
                    printWriter.println(vehicleObject.toJSONString());
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

    public void PrintVehiclePDF() throws FileNotFoundException, DocumentException, ParseException {
        String FilePath = "C:\\Users\\Allan\\Desktop\\customers";
        JFileChooser dlg = new JFileChooser(FilePath);
        File f = dlg.getSelectedFile();
        String f1 = String.valueOf(f);
        String contenido = PrintVehicle();
        FileOutputStream fos = new FileOutputStream("vehículos .pdf");
        Document doc = new Document();
        PdfWriter.getInstance(doc, fos);
        doc.open();
        doc.add(new Paragraph(contenido));

        //llena el pdf con el TextArea
        doc.close();
    }

    public String PrintVehicle() throws ParseException, FileNotFoundException, DocumentException {
        Vehicle vehiclesArry[] = getAllVehiclesArray();
        String output = "\n\n\nInformación de los clientes registrados\n\n";
        int num = 1;
        for (Vehicle vehiclesArry1 : vehiclesArry) {
            Vehicle vehicle = (Vehicle) vehiclesArry1;

            output += num + "- " + vehicle.getBrand() + "\t" + vehicle.getColor() + "\t" + vehicle.getIdCustomer() + "\t" + vehicle.getVehicleType() + "\t" + vehicle.getPlate() + "\n";

            num++;
        }
        return output;
    }

    public Vehicle[] getAllVehiclesArray() throws ParseException {

        Vehicle[] vehiclesArray = new Vehicle[getAllVehicles().size()];

        for (int i = 0; i < vehiclesArray.length; i++) {

            vehiclesArray[i] = getAllVehicles().get(i);
        }
        return vehiclesArray;

    }
}
