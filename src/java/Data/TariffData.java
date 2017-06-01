/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Tariff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Allan
 */
public class TariffData {

    final String jsonFilePath = "C:\\Users\\Julio\\Documents\\Base de datos parqueo\\tarifas.json";

    public void insertTariffJson(Tariff tariff) throws IOException {
        JSONObject tariffObject = new JSONObject();
        tariffObject.put("id", tariff.getId());
        tariffObject.put("priceHalfHour", tariff.getPriceHalfHour());
        tariffObject.put("priceOneHour", tariff.getPriceOneHour());
        tariffObject.put("pricePerDay", tariff.getPricePerDay());
        tariffObject.put("pricePerWeek", tariff.getPricePerWeek());
        tariffObject.put("pricePerMonth", tariff.getPricePerMonth());
        tariffObject.put("pricePerYear", tariff.getPricePerYear());
        tariffObject.put("vehicleType", tariff.getVehicleType());

        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(jsonFilePath, true)) {
            file.write(tariffObject.toJSONString() + "\r\n");
        }
    }

    public LinkedList<Tariff> getAllTariff() throws ParseException, org.json.simple.parser.ParseException {

        LinkedList<Tariff> tariffs = new LinkedList<>();
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

                Tariff tariff = new Tariff();
                tariff.setId(Integer.parseInt(jsonObject.get("id").toString()));
                tariff.setVehicleType(jsonObject.get("vehicleType").toString());
                tariff.setPriceHalfHour(Float.parseFloat(jsonObject.get("priceHalfHour").toString()));
                tariff.setPriceOneHour(Float.parseFloat(jsonObject.get("priceOneHour").toString()));
                tariff.setPricePerDay(Float.parseFloat(jsonObject.get("pricePerDay").toString()));
                tariff.setPricePerWeek(Float.parseFloat(jsonObject.get("pricePerWeek").toString()));
                tariff.setPricePerMonth(Float.parseFloat(jsonObject.get("pricePerMonth").toString()));
                tariff.setPricePerYear(Float.parseFloat(jsonObject.get("pricePerYear").toString()));
                
                tariffs.add(tariff);
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
        return tariffs;
    }

    public void modifyTariffFromFile(int id, Tariff tariff) throws ParseException, org.json.simple.parser.ParseException {
        String idAux = ""+id;
        try {
            JSONObject tariffObject;
            File file = new File(jsonFilePath);
            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("TariffsTemp.json");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {
                tariffObject = (JSONObject) new JSONParser().parse(line);

                if (!tariffObject.get("id").toString().equals(idAux)) {

                    printWriter.println(line);
                    printWriter.flush();
                } else {
                    tariffObject.put("id", tariff.getId());
                    tariffObject.put("priceHalfHour", tariff.getPriceHalfHour());
                    tariffObject.put("priceOneHour", tariff.getPriceOneHour());
                    tariffObject.put("pricePerDay", tariff.getPricePerDay());
                    tariffObject.put("pricePerWeek", tariff.getPricePerWeek());
                    tariffObject.put("pricePerMonth", tariff.getPricePerMonth());
                    tariffObject.put("pricePerYear", tariff.getPricePerYear());
                    tariffObject.put("vehicleType", tariff.getVehicleType());
                    printWriter.println(tariffObject.toJSONString());
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

    public Tariff getTariffById(int id) throws ParseException, org.json.simple.parser.ParseException, IOException {
        String idToString = String.valueOf(id);
        Tariff tariff = new Tariff();
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
                if (jsonObject.get("id").toString().equals(idToString)) {
                    tariff.setVehicleType(jsonObject.get("vehicleType").toString());
                    tariff.setId(Integer.parseInt(jsonObject.get("id").toString()));
                    tariff.setPriceHalfHour(Float.parseFloat(jsonObject.get("priceHalfHour").toString()));
                    tariff.setPriceOneHour(Float.parseFloat(jsonObject.get("priceOneHour").toString()));
                    tariff.setPricePerDay(Float.parseFloat(jsonObject.get("pricePerDay").toString()));
                    tariff.setPricePerWeek(Float.parseFloat(jsonObject.get("pricePerWeek").toString()));                    
                    tariff.setPricePerMonth(Float.parseFloat(jsonObject.get("pricePerMonth").toString()));
                    tariff.setPricePerYear(Float.parseFloat(jsonObject.get("pricePerYear").toString()));
                    
  
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
        return tariff;
    }

    public void deleteTariff(int id) throws ParseException, org.json.simple.parser.ParseException {
        String idToString = String.valueOf(id);
        try {

            JSONObject tariffObject;

            File file = new File(jsonFilePath);

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("tariffsTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;

                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {

                    tariffObject = (JSONObject) new JSONParser().parse(line);

                    if (!tariffObject.get("id").toString().equals(idToString)) {

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
}
