/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Space;
import Domain.VehicleType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author juang
 */
public class SpaceData {

    final String jsonFilePath = "C:\\Users\\Julio\\Documents\\Base de datos parqueo\\spaces.json";

    //variable global que simula una base de datos
    public static LinkedList<Space> spaces;

    public SpaceData() {
        spaces = new LinkedList<>();
    }

    public LinkedList<Space> getAllSpaces(String idParking) throws ParseException {
        LinkedList<Space> spaces = new LinkedList<>();
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

                Space space = new Space();

                if (jsonObject.get("idParking").toString().equals(idParking)) {

                    space.setDisabilityAdaptation(Boolean.parseBoolean(jsonObject.get("disabilityAdaptation").toString()));
                    space.setIdParking(Integer.parseInt(jsonObject.get("idParking").toString()));
                    space.setId(Integer.parseInt(jsonObject.get("id").toString()));
                    space.setSpaceTaken(Boolean.parseBoolean(jsonObject.get("spaceTaken").toString()));
                    if (jsonObject.get("vehicleType") != null) {
                        space.setVehicleType(jsonObject.get("vehicleType").toString());
                    }

                    spaces.add(space);
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
        return spaces;
    }

    public Space[] getAllSpaceArray() {

        Space[] spacesArray = new Space[spaces.size()];

        for (int i = 0; i < spacesArray.length; i++) {

            spacesArray[i] = spaces.get(i);
        }
        return spacesArray;

    }

    public void insertSpaceJSon(Space space) throws IOException {
        JSONObject spaceObject = new JSONObject();
        spaceObject.put("idParking", space.getIdParking());
        spaceObject.put("id", space.getId());
        spaceObject.put("vehicleType", space.getVehicleType());
        spaceObject.put("disabilityAdaptation", space.isDisabilityAdaptation());
        spaceObject.put("spaceTaken", space.isSpaceTaken());
        spaceObject.put("idCustomer", space.getIdCustomer());
        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(jsonFilePath, true)) {
            file.write(spaceObject.toJSONString() + "\r\n");
        }

    }

    //------------------------------------------------------------------------//
    public void deleteSpace(String id, String spaceIdParking) throws ParseException {
        try {
            JSONObject spaceObject;
            File file = new File(jsonFilePath);
            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("spacesTemp.json");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;
                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {
                    spaceObject = (JSONObject) new JSONParser().parse(line);
                    if (!spaceObject.get("id").toString().equals(id)
                            || !spaceObject.get("idParking").toString().equals(spaceIdParking)) {
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

    public void modifySpaceFromFile(int idParking, int id, Space space) throws ParseException {
        String auxId = "" + id;
        String auxIdParking = "" + idParking;
        try {
            JSONObject spaceObject;

            File file = new File(jsonFilePath);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("spacesTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            String line = null;
            //Read from the original file and write to the new 
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {

                spaceObject = (JSONObject) new JSONParser().parse(line);

                if (spaceObject.get("id").toString().equals(auxId)
                        && spaceObject.get("idParking").toString().equals(auxIdParking)) {

                    spaceObject.put("idParking", space.getIdParking());
                    spaceObject.put("id", space.getId());
                    spaceObject.put("vehicleType", space.getVehicleType());
                    spaceObject.put("disabilityAdaptation", space.isDisabilityAdaptation());
                    spaceObject.put("spaceTaken", space.isSpaceTaken());
                    spaceObject.put("idCustomer", space.getIdCustomer());
                    printWriter.println(spaceObject.toJSONString());

                } else {
                    printWriter.println(line);
                    printWriter.flush();
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

    public Space getSpaceById(String id, String spaceIdParking) throws ParseException {

        Space space = new Space();
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

                if (jsonObject.get("id").toString().equals(id)
                        && jsonObject.get("idParking").toString().equals(spaceIdParking)) {
                    space.setIdParking(Integer.parseInt(jsonObject.get("idParking").toString()));
                    space.setId(Integer.parseInt(jsonObject.get("id").toString()));
                    space.setDisabilityAdaptation(Boolean.parseBoolean(jsonObject.get("disabilityAdaptation").toString()));
                    space.setSpaceTaken(Boolean.parseBoolean(jsonObject.get("spaceTaken").toString()));
                    if (jsonObject.get("vehicleType") != null) {
                        space.setVehicleType(jsonObject.get("vehicleType").toString());
                    }
                    System.out.println(space.toString());
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
        return space;
    }

    public LinkedList<Space> getSpacesOfType(String idParking, String vehicleType) throws ParseException {

        LinkedList<Space> spaces = new LinkedList<>();
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

                Space space = new Space();

                if (jsonObject.get("idParking").toString().equals(idParking)
                        && jsonObject.get("vehicleType").toString().equals(vehicleType)
                        && jsonObject.get("spaceTaken").toString().equals("false")) {

                    space.setDisabilityAdaptation(Boolean.parseBoolean(jsonObject.get("disabilityAdaptation").toString()));
                    space.setIdParking(Integer.parseInt(jsonObject.get("idParking").toString()));
                    space.setId(Integer.parseInt(jsonObject.get("id").toString()));
                    space.setSpaceTaken(Boolean.parseBoolean(jsonObject.get("spaceTaken").toString()));
                    if (jsonObject.get("vehicleType") != null) {
                        space.setVehicleType(jsonObject.get("vehicleType").toString());
                    }

                    spaces.add(space);
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
        return spaces;
    }

    public LinkedList<Space> getSpacesForIdCustomer(String idCustomer) throws ParseException {

        LinkedList<Space> spaces = new LinkedList<>();
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

                Space space = new Space();

                if (jsonObject.get("idCustomer").toString().equals(idCustomer)) {

                    space.setDisabilityAdaptation(Boolean.parseBoolean(jsonObject.get("disabilityAdaptation").toString()));
                    space.setIdParking(Integer.parseInt(jsonObject.get("idParking").toString()));
                    space.setId(Integer.parseInt(jsonObject.get("id").toString()));
                    space.setSpaceTaken(Boolean.parseBoolean(jsonObject.get("spaceTaken").toString()));
                    space.setVehicleType(jsonObject.get("vehicleType").toString());

                    spaces.add(space);
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
        return spaces;
    }
    
    public LinkedList<Space> getSpacesOfTypeForNoPreference(String idParking, String vehicleType) throws ParseException {

        LinkedList<Space> spaces = new LinkedList<>();
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

                Space space = new Space();

                if (jsonObject.get("idParking").toString().equals(idParking)
                        && jsonObject.get("vehicleType").toString().equals(vehicleType)
                        && jsonObject.get("spaceTaken").toString().equals("false")
                        && jsonObject.get("disabilityAdaptation").toString().equals("false")) {

                    space.setDisabilityAdaptation(Boolean.parseBoolean(jsonObject.get("disabilityAdaptation").toString()));
                    space.setIdParking(Integer.parseInt(jsonObject.get("idParking").toString()));
                    space.setId(Integer.parseInt(jsonObject.get("id").toString()));
                    space.setSpaceTaken(Boolean.parseBoolean(jsonObject.get("spaceTaken").toString()));
                    if (jsonObject.get("vehicleType") != null) {
                        space.setVehicleType(jsonObject.get("vehicleType").toString());
                    }

                    spaces.add(space);
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
        return spaces;
    }
}
