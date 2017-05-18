/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.CustomerData;
import Domain.Customer;
import Domain.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Esteban
 */
public class CustomerBusiness{

    CustomerData customerData;

    public CustomerBusiness() {

        customerData = new CustomerData();
    }


    public User searchUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<User> sortUsers(User[] allUsers) {

        //Esto se hace para convertir un ArrayList de Users
        //a un ArrayList de Customers
        ArrayList<User> customersToReturn = new ArrayList<>();
        ArrayList<Customer> customerSorted = bubbleSort(allUsers);

        for (int position = 0; position < customerSorted.size(); position++) {

            customersToReturn.add(customerSorted.get(position));
        }

        return customersToReturn;

    }

    public static ArrayList<Customer> bubbleSort(User[] customers) {
        int position;
        boolean flag = true;
        Customer temporalCustomer;
        ArrayList<Customer> customerArrayList = new ArrayList<>();

        while (flag) {
            flag = false;
            for (position = 0; position < customers.length - 1; position++) {
                if (customers[position].getName().compareToIgnoreCase(customers[position + 1].getName()) > 0) // change to > for ascending sort
                {
                    temporalCustomer = (Customer) customers[position];                //swap elements
                    customers[position] = customers[position + 1];
                    customers[position + 1] = temporalCustomer;
                    flag = true;
                }
            }
        }

        for (User customer : customers) {

            customerArrayList.add((Customer) customer);
        }

        return customerArrayList;
    }

    public ArrayList<User> sortUsers(String identification, User[] allUsers) {
        int position;
        boolean flag = true;
        User temporalUser;
        ArrayList<User> userArrayList = new ArrayList<>();

        while (flag) {
            flag = false;
            for (position = 0; position < allUsers.length - 1; position++) {
                if (allUsers[position].getAddress().compareToIgnoreCase(allUsers[position + 1].getAddress()) > 0) // change to > for ascending sort
                {
                    temporalUser = allUsers[position];                //swap elements
                    allUsers[position] = allUsers[position + 1];
                    allUsers[position + 1] = temporalUser;
                    flag = true;
                }
            }
        }

        for (User users : allUsers) {

            userArrayList.add((User) users);
        }

        return userArrayList;
    }

    public void insertCustomer(Customer customer) throws IOException {
        //regla de negocio de no permitir datos en blanco. Todos son requeridos.
        if (!customer.getName().equals("") && !customer.getEmail().equals("")
                && !customer.getPhone().equals("") && !customer.getAddress().equals("")
                && !customer.getIdentification().equals("")
                && !customer.getUsername().equals("") && !customer.getPassword().equals("")) {
            customerData.insertCustomerJSon(customer);

        }

    }
    
    
    //-------------------------------------------------------------------------

    public void deleteCustomer(String customerUsername) throws IOException, ParseException {

        customerData.deleteCustomer(customerUsername);

    }

    public LinkedList<Customer> getAllCustomers() throws ParseException {

        return customerData.getAllCustomers();
    }


    public void modifyCustomer(String customerName, Customer customer) throws IOException, ParseException {

        customerData.modifyCustomerFromFile(customerName, customer);

    }

    public Customer getCustomerByUsernameAndPassword(String username, String password) throws ParseException {

        Customer customer = new Customer();
        //regla de negocio de no permitir datos en blanco. Todos son requeridos.
        if (!username.equals("") && !password.equals("")) {

            customer = customerData.getCustomerByUsernameAndPassword(username, password);
        }

        return customer;

    }

    public Customer getCustomerByName(String username) throws ParseException {

        Customer customer = new Customer();
        customer = customerData.getCustomerByUsername(username);
        return customer;
    }

}
