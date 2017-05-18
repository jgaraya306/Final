/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

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
 * @author Esteban
 */
public class CustomerData {

    final String jsonFilePath = "C:\\Users\\Julio\\Documents\\Base de datos parqueo\\customers.json";

    //variable global que simula una base de datos
    public static LinkedList<Customer> customers;

    public CustomerData() {
        customers = new LinkedList<>();
    }

    public LinkedList<Customer> getAllCustomers() throws ParseException {
        LinkedList<Customer> customers = new LinkedList<>();
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

                Customer customer = new Customer();
                customer.setName(jsonObject.get("name").toString());
                customer.setEmail(jsonObject.get("email").toString());
                customer.setPhone(jsonObject.get("phone").toString());
                customer.setAddress(jsonObject.get("address").toString());
                customer.setUsername(jsonObject.get("username").toString());
                customer.setPassword(jsonObject.get("password").toString());
                System.out.println(customer.toString());
                customers.add(customer);
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
        return customers;
    }

    public Customer[] getAllCustomersArray() {

        Customer[] customersArray = new Customer[customers.size()];

        for (int i = 0; i < customersArray.length; i++) {

            customersArray[i] = customers.get(i);
        }
        return customersArray;

    }

    public Customer findCustomerById(String customerId) {

        Customer customer = new Customer();

        for (Customer currentCustomer : customers) {

            if (currentCustomer.getIdentification().equalsIgnoreCase(customerId)) {

                customer = currentCustomer;
            }
        }
        return customer;
    }

    public User searchUser(String username, String password) {
        for (Customer currentCustomer : customers) {
            if (currentCustomer.getPassword().equalsIgnoreCase(password) && currentCustomer.getUsername().equalsIgnoreCase(username)) {
                return currentCustomer;
            }
        }
        return null;

    }

    public boolean userCustomerExist(String login[]) throws IOException, org.json.simple.parser.ParseException {
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

    public void insertCustomerJSon(Customer customer) throws IOException {
        JSONObject customerObject = new JSONObject();
        customerObject.put("name", customer.getName());
        customerObject.put("id", customer.getIdentification());
        customerObject.put("address", customer.getAddress());
        customerObject.put("username", customer.getUsername());
        customerObject.put("password", customer.getPassword());
        customerObject.put("phone", customer.getPhone());
        customerObject.put("email", customer.getEmail());
        customerObject.put("disabilityPresented", customer.getIsDisabilityPresented());
        customerObject.put("isGoldenCiticen", customer.getIsIsGoldenCiticen());

        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(jsonFilePath, true)) {
            file.write(customerObject.toJSONString() + "\r\n");
        }

    }
    
    //------------------------------------------------------------------------//

    public void deleteCustomer(String username) throws ParseException {

        try {

            JSONObject customerObject;

            File file = new File(jsonFilePath);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("customersTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;

                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {

                    customerObject = (JSONObject) new JSONParser().parse(line);

                    if (!customerObject.get("username").toString().equals(username)) {

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

    public void modifyCustomerFromFile(String username, Customer customer) throws ParseException {

        try {

            JSONObject customerObject;

            File file = new File(jsonFilePath);

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File("customersTemp.json");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new 
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {

                customerObject = (JSONObject) new JSONParser().parse(line);

                if (!customerObject.get("username").toString().equals(username)) {

                    printWriter.println(line);
                    printWriter.flush();
                } else {

                    customerObject.put("name", customer.getName());
//                    customerObject.put("id", customer.getIdentification());
                    customerObject.put("email", customer.getEmail());
                    customerObject.put("phone", customer.getPhone());
                    customerObject.put("address", customer.getAddress());
                    customerObject.put("username", customer.getUsername());
                    customerObject.put("password", customer.getPassword());
                    //customerObject.put("isGoldenCiticen", customer.getIsIsGoldenCiticen());
                    //customerObject.put("isDisabilityPresented", customer.getIsDisabilityPresented());

                    printWriter.println(customerObject.toJSONString());
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

    public Customer getCustomerByUsername(String username) throws ParseException {

        Customer customer = new Customer();
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
                    customer.setName(jsonObject.get("name").toString());
                    customer.setIdentification(jsonObject.get("id").toString());
                    customer.setEmail(jsonObject.get("email").toString());
                    customer.setPhone(jsonObject.get("phone").toString());
                    customer.setAddress(jsonObject.get("address").toString());
                    customer.setUsername(jsonObject.get("username").toString());
                    customer.setPassword(jsonObject.get("password").toString());
                    customer.setDisabilityPresented(jsonObject.get("disabilityPresented").toString().equals("true"));
                    customer.setIsGoldenCiticen(jsonObject.get("isGoldenCiticen").toString().equals("true"));                    
                    
                    System.out.println(customer.toString());
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
        return customer;
    }

    public Customer getCustomerByUsernameAndPassword(String username, String password) throws ParseException {

        Customer customer = new Customer();
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
                    customer.setName(jsonObject.get("name").toString());
                    customer.setEmail(jsonObject.get("email").toString());
                    customer.setPhone(jsonObject.get("phone").toString());
                    customer.setAddress(jsonObject.get("address").toString());
                    customer.setUsername(jsonObject.get("username").toString());
                    customer.setPassword(jsonObject.get("password").toString());
                    System.out.println(customer.toString());
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
        return customer;
    }
}
