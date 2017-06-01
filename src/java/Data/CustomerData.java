/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Controlator;
import Domain.Customer;
import Domain.Email;
import Domain.User;
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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
    Email email = new Email();
    Controlator controlator = new Controlator();

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

                System.err.println("error " + jsonObject.
                        get("disabilityPresented").toString());
                Customer customer = new Customer();
                customer.setName(jsonObject.get("name").toString());
                customer.setEmail(jsonObject.get("email").toString());
                customer.setPhone(jsonObject.get("phone").toString());
                customer.setIdentification(jsonObject.get("id").toString());
                customer.setAddress(jsonObject.get("address").toString());
                customer.setUsername(jsonObject.get("username").toString());
                customer.setPassword(jsonObject.get("password").toString());
                customer.setDisabilityPresented(Boolean.parseBoolean(jsonObject.
                        get("disabilityPresented").toString()));
                customer.setGoldenCiticen(Boolean.parseBoolean(jsonObject.
                        get("isGoldenCiticen").toString()));

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
        customerObject.put("disabilityPresented", customer.isDisabilityPresented());
        customerObject.put("isGoldenCiticen", customer.isGoldenCiticen());

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
                    customerObject.put("id", customer.getId());
                    customerObject.put("email", customer.getEmail());
                    customerObject.put("phone", customer.getPhone());
                    customerObject.put("address", customer.getAddress());
                    customerObject.put("username", customer.getUsername());
                    customerObject.put("password", customer.getPassword());
                    customerObject.put("isGoldenCiticen", customer.isGoldenCiticen());
                    customerObject.put("disabilityPresented", customer.isDisabilityPresented());

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
                    customer.setId(Integer.parseInt(jsonObject.get("id").toString()));
                    customer.setEmail(jsonObject.get("email").toString());
                    customer.setPhone(jsonObject.get("phone").toString());
                    customer.setAddress(jsonObject.get("address").toString());
                    customer.setUsername(jsonObject.get("username").toString());
                    customer.setPassword(jsonObject.get("password").toString());
                    customer.setDisabilityPresented(jsonObject.get("disabilityPresented").toString().equals("true"));
                    customer.setGoldenCiticen(jsonObject.get("isGoldenCiticen").toString().equals("true"));

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

    public Customer getCustomerById(String id) throws ParseException {

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

                if (jsonObject.get("id").toString().equals(id)) {

                    customer.setName(jsonObject.get("name").toString());
                    customer.setId(Integer.parseInt(jsonObject.get("id").toString()));
                    customer.setEmail(jsonObject.get("email").toString());
                    customer.setPhone(jsonObject.get("phone").toString());
                    customer.setAddress(jsonObject.get("address").toString());
                    customer.setUsername(jsonObject.get("username").toString());
                    customer.setPassword(jsonObject.get("password").toString());
                    customer.setDisabilityPresented(jsonObject.get("disabilityPresented").toString().equals("true"));
                    customer.setGoldenCiticen(jsonObject.get("isGoldenCiticen").toString().equals("true"));

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

    public void PrintCustomersPDF() throws FileNotFoundException, DocumentException, ParseException {
        String FilePath = "C:\\Users\\Julio\\Documents\\Base de datos parqueo\\customers.json";
        JFileChooser dlg = new JFileChooser(FilePath);
        File f = dlg.getSelectedFile();
        String f1 = String.valueOf(f);
        String contenido = PrintCustomer();
        FileOutputStream fos = new FileOutputStream("clientes.pdf");
        Document doc = new Document();
        PdfWriter.getInstance(doc, fos);
        doc.open();
        doc.add(new Paragraph(contenido));

        //llena el pdf con el TextArea
        doc.close();
    }

    public String PrintCustomer() throws ParseException, FileNotFoundException, DocumentException {
        Customer customersArry[] = getAllCustomersArray();
        String output = "\n\n\nInformación de los clientes registrados\n\n";

        for (Customer customersArry1 : customersArry) {
            Customer customer = (Customer) customersArry1;
            output += customer.toString() + "\n";

        }
        return output;
    }

    public void sentEmail(String username) throws ParseException {
        Customer customer = getCustomerByUsername(username);
        email.setPassword("jvvhoemluhsblewq");
        email.setUserEmail("juliojose3000@gmail.com");
        email.setIssue("Reservacion");
        email.setMessage("Parking System");
        email.setDestination(customer.getEmail());
        email.setFileName("TPhoto_00001.jpg");
        email.setFilePath("TPhoto_00001.jpg");
        Controlator controlator = new Controlator();
        if (controlator.IsEmailSended(email)) {
            JOptionPane.showMessageDialog(null, "Correo enviado");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

}
