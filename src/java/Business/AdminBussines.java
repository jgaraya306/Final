/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.AdminData;
import Domain.Administrator;
import Domain.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author juang
 */
public class AdminBussines {

    AdminData AdminData = new AdminData();

    public ArrayList<User> sortUsers(User[] allUsers) {

        //Esto se hace para convertir un ArrayList de Users
        //a un ArrayList de Customers
        ArrayList<User> adminToReturn = new ArrayList<>();
        ArrayList<Administrator> adminSorted = bubbleSort(allUsers);

        for (int position = 0; position < adminSorted.size(); position++) {

            adminToReturn.add(adminSorted.get(position));
        }

        return adminToReturn;

    }

    public static ArrayList<Administrator> bubbleSort(User[] administrator) {
        int position;
        boolean flag = true;
        Administrator temporalAdministrator;
        ArrayList<Administrator> adminArrayList = new ArrayList<>();

        while (flag) {
            flag = false;
            for (position = 0; position < administrator.length - 1; position++) {
                if (administrator[position].getName().compareToIgnoreCase(administrator[position + 1].getName()) > 0) // change to > for ascending sort
                {
                    temporalAdministrator = (Administrator) administrator[position];                //swap elements
                    administrator[position] = administrator[position + 1];
                    administrator[position + 1] = temporalAdministrator;
                    flag = true;
                }
            }
        }
        for (User customer : administrator) {

            adminArrayList.add((Administrator) customer);
        }

        return adminArrayList;
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

    public void insertAdministrador(Administrator administrator) throws IOException {
        //regla de negocio de no permitir datos en blanco. Todos son requeridos.

        if (!administrator.getName().equals("") && !administrator.getAddress().equals("") && !administrator.getIdentification().equals("")
                && !administrator.getUsername().equals("") && !administrator.getPassword().equals("")) {
            AdminData.insertAdminJSon(administrator);
        }

    }

    public void deleteAdmin(String adminUsername) throws ParseException {
        AdminData.deleteAdmin(adminUsername);
    }

    public LinkedList<Administrator> getAllAdmins() throws ParseException, IOException {
        return AdminData.getAlladmins();
    }

    public void modifyAdmin(String administratorName, Administrator administrator) throws ParseException {
        AdminData.modifyAdministratorFromFile(administratorName, administrator);
    }

    public Administrator getAdminByUsernameAndPassword(String username, String password) throws ParseException {
        Administrator administrator = new Administrator();
        if (!username.equals("") && !password.equals("")) {
            administrator = AdminData.getAdministratorByUsernameAndPassword(username, password);
        }
        return administrator;
    }

    public Administrator getAdministratorByUsername(String administratorUsername) throws ParseException {
        Administrator administrator = new Administrator();
        administrator = AdminData.getAdminByUsername(administratorUsername);
        return administrator;
    }
}
