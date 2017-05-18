package Data;

import Domain.Clerk;
import Domain.Customer;
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
 * @author Allan
 */
public class ClerkData {

    final String jsonFilePath = "C:\\Users\\Julio\\Documents\\Base de datos parqueo\\clerks.json";

    //variable global que simula una base de datos
    public static LinkedList<Clerk> clerks;

    public ClerkData() {
        clerks = new LinkedList<>();
    }

    public LinkedList<Clerk> getAllClerks() throws ParseException {

        LinkedList<Clerk> clerks = new LinkedList<>();
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

                Clerk clerk = new Clerk();
                clerk.setName(jsonObject.get("name").toString());
                clerk.setAddress(jsonObject.get("address").toString());
                clerk.setUsername(jsonObject.get("username").toString());
                clerk.setPassword(jsonObject.get("password").toString());
               
                clerks.add(clerk);
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
        return clerks;

    }

    public Clerk[] getAllClerksArray() {

        Clerk[] clerksArray = new Clerk[clerks.size()];

        for (int i = 0; i < clerksArray.length; i++) {

            clerksArray[i] = clerks.get(i);
        }
        return clerksArray;

    }

    public Clerk findCustomerById(String clerkId) {

        Clerk clerk = new Clerk();

        for (Clerk currentClerk : clerks) {

            if (currentClerk.getIdentification().equalsIgnoreCase(clerkId)) {

                clerk = currentClerk;
            }
        }
        return clerk;
    }

    public User searchUser(String username, String password) {
        for (Clerk currentClerk : clerks) {
            if (currentClerk.getPassword().equalsIgnoreCase(password) && currentClerk.getUsername().equalsIgnoreCase(username)) {
                return currentClerk;
            }
        }
        return null;

    }

    public boolean userClerkExist(String login[]) throws IOException, org.json.simple.parser.ParseException {
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

    public void insertClerkJSon(Clerk clerk) throws IOException {
        JSONObject customerObject = new JSONObject();
        customerObject.put("name", clerk.getName());
        customerObject.put("address", clerk.getAddress());
        customerObject.put("username", clerk.getUsername());
        customerObject.put("password", clerk.getPassword());

        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(jsonFilePath, true)) {
            file.write(customerObject.toJSONString() + "\r\n");
        }

    }

    //------------------------------------------------------------------------//
    public void deleteClerk(String username) throws ParseException {

        try {

            JSONObject clerkObject;

            File file = new File(jsonFilePath);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("clerksTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;

                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {

                    clerkObject = (JSONObject) new JSONParser().parse(line);

                    if (!clerkObject.get("username").toString().equals(username)) {

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

    public void modifyClerkFromFile(String username, Clerk clerk) throws ParseException {

        try {

            JSONObject clerkObject;

            File file = new File(jsonFilePath);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("clerksTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new 
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {

                clerkObject = (JSONObject) new JSONParser().parse(line);

                if (!clerkObject.get("username").toString().equals(username)) {

                    printWriter.println(line);
                    printWriter.flush();
                } else {

                    clerkObject.put("name", clerk.getName());
                    clerkObject.put("address", clerk.getAddress());
                    clerkObject.put("username", clerk.getUsername());
                    clerkObject.put("password", clerk.getPassword());

                    printWriter.println(clerkObject.toJSONString());
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

    public Clerk getClerkByUsername(String username) throws ParseException {

        Clerk clerk = new Clerk();
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
                    clerk.setName(jsonObject.get("name").toString());
                    //clerk.setIdentification(jsonObject.get("id").toString());
                    clerk.setAddress(jsonObject.get("address").toString());
                    clerk.setUsername(jsonObject.get("username").toString());
                    clerk.setPassword(jsonObject.get("password").toString());

                    System.out.println(clerk.toString());
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
        return clerk;
    }

    public Clerk getClerkByUsernameAndPassword(String username, String password) throws ParseException {

        Clerk clerk = new Clerk();
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
                    clerk.setName(jsonObject.get("name").toString());
                    clerk.setAddress(jsonObject.get("address").toString());
                    clerk.setUsername(jsonObject.get("username").toString());
                    clerk.setPassword(jsonObject.get("password").toString());

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
        return clerk;
    }

}
