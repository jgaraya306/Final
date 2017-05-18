/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Administrator;
import Domain.User;
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

/**
 *
 * @author juang
 */
public class AdminData {

    final String jsonFilePath = "C:\\Users\\Julio\\Documents\\Base de datos parqueo\\admins.json";

    //variable global que simula una base de datos
    public static ArrayList<Administrator> admins;

    public AdminData() {
        admins = new ArrayList<>();
    }

    public void insertatAdmin(Administrator administrator) {
        admins.add(administrator);
    }

    public void removeAdmin(Administrator administrator) {
        admins.remove(administrator);
    }

    public LinkedList<Administrator> getAlladmins() throws IOException, ParseException {
        LinkedList<Administrator> admins = new LinkedList<>();
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
                Administrator administrator = new Administrator();
                administrator.setAddress(jsonObject.get("address").toString());
                administrator.setIdentification(jsonObject.get("identification").toString());
                administrator.setName(jsonObject.get("name").toString());
                administrator.setPassword(jsonObject.get("password").toString());
                administrator.setUsername(jsonObject.get("username").toString());
                admins.add(administrator);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + jsonFilePath + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + jsonFilePath + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }

        return admins;
    }

    public Administrator[] getAllAdminArray() {

        Administrator[] administratorArray = new Administrator[admins.size()];

        for (int i = 0; i < administratorArray.length; i++) {
            administratorArray[i] = admins.get(i);
        }
        return administratorArray;
    }

    public Administrator findAdminById(String administratorId) {

        Administrator administrator = new Administrator();

        for (Administrator currentAdministrator : admins) {

            if (currentAdministrator.getIdentification().equalsIgnoreCase(administratorId)) {

                administrator = currentAdministrator;
            }
        }
        return administrator;
    }

    public User searchUser(String username, String password) {
        for (Administrator currentAdministrator : admins) {
            if (currentAdministrator.getPassword().equalsIgnoreCase(password) && currentAdministrator.getUsername().equalsIgnoreCase(username)) {
                return currentAdministrator;
            }
        }
        return null;
    }

    public boolean userAdminExist(String login[]) throws IOException, org.json.simple.parser.ParseException {
        boolean found = false;
        JSONObject jsonObject;
        String line = null;
        FileReader fileReader = new FileReader(jsonFilePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            jsonObject = (JSONObject) new JSONParser().parse(line);
            if (jsonObject.get("username").toString().equals(login[0]) && jsonObject.get("password").toString().equals(login[1])) {
                found = true;
                break;
            } else {
                found = false;
            }
        }
        bufferedReader.close();
        return found;
    }

    public void insertAdminJSon(Administrator administrator) throws IOException {
        JSONObject administratorObject = new JSONObject();
        administratorObject.put("name", administrator.getName());
        administratorObject.put("address", administrator.getAddress());
        administratorObject.put("username", administrator.getUsername());
        administratorObject.put("identification", administrator.getIdentification());
        administratorObject.put("password", administrator.getPassword());

        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(jsonFilePath, true)) {
            file.write(administratorObject.toJSONString() + "\r\n");
        }

    }

    //------------------------------------------------------------------------//
    public void deleteAdmin(String username) throws ParseException {
        try {
            JSONObject adminObject;
            File file = new File(jsonFilePath);
            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("adminsTemp.json");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;
                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {
                    adminObject = (JSONObject) new JSONParser().parse(line);
                    if (!adminObject.get("username").toString().equals(username)) {
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

    public void modifyAdministratorFromFile(String username, Administrator administrator) throws ParseException {

        try {
            JSONObject adminObject;
            File file = new File(jsonFilePath);
            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("adminsTemp.json");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));
            String line = null;
            //Read from the original file and write to the new 
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {
                adminObject = (JSONObject) new JSONParser().parse(line);
                if (!adminObject.get("username").toString().equals(username)) {
                    printWriter.println(line);
                    printWriter.flush();
                } else {
                    adminObject.put("name", administrator.getName());

                    adminObject.put("address", administrator.getAddress());
                    adminObject.put("username", administrator.getUsername());

                    printWriter.println(adminObject.toJSONString());
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

    public Administrator getAdminByUsername(String username) throws ParseException {
        Administrator admin = new Administrator();
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
                if (jsonObject.get("username").toString().equals(username)) {
                    admin.setName(jsonObject.get("name").toString());
                    admin.setIdentification(jsonObject.get("id").toString());
                    admin.setAddress(jsonObject.get("address").toString());
                    admin.setUsername(jsonObject.get("username").toString());
                    admin.setPassword(jsonObject.get("password").toString());
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
        return admin;
    }

    public Administrator getAdministratorByUsernameAndPassword(String username, String password) throws ParseException {

        Administrator admin = new Administrator();
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
                if (jsonObject.get("username").toString().equals(username) && jsonObject.get("password").toString().equals(password)) {
                    admin.setName(jsonObject.get("name").toString());
                    admin.setAddress(jsonObject.get("address").toString());
                    admin.setUsername(jsonObject.get("username").toString());
                    admin.setPassword(jsonObject.get("password").toString());
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
        return admin;
    }
}
