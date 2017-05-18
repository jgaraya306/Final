/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.ClerkData;
import Domain.Clerk;
import Domain.Customer;
import Domain.User;
import Domain.UserOperations;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Esteban
 */
public class ClerkBusiness extends User {

    ClerkData clerkData = new ClerkData();

    public void insertClerk(Clerk clerk) throws IOException {
        //regla de negocio de no permitir datos en blanco. Todos son requeridos.
        if (!clerk.getName().equals("")
                && !clerk.getIdentification().equals("")
                && !clerk.getAddress().equals("")
                && !clerk.getUsername().equals("") && !clerk.getPassword().equals("")) {
            clerkData.insertClerkJSon(clerk);
        }
    }

    @Override
    public boolean verifyUserLogin(String[] loginDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteClerk(String clerkrUsername) throws IOException, ParseException {

        clerkData.deleteClerk(clerkrUsername);

    }

    public LinkedList<Clerk> getAllClerks() throws ParseException {

        return clerkData.getAllClerks();
    }

    public void modifyClerk(String clerkName, Clerk clerk) throws IOException, ParseException {

        clerkData.modifyClerkFromFile(clerkName, clerk);

    }

    public Clerk getClerkByUsernameAndPassword(String username, String password) throws ParseException {

        Clerk clerk = new Clerk();
        //regla de negocio de no permitir datos en blanco. Todos son requeridos.
        if (!username.equals("") && !password.equals("")) {

            clerk = clerkData.getClerkByUsernameAndPassword(username, password);
        }

        return clerk;

    }

    public Clerk getClerkByName(String username) throws ParseException {

        Clerk clerk = new Clerk();
        clerk = clerkData.getClerkByUsername(username);
        return clerk;
    }
}
