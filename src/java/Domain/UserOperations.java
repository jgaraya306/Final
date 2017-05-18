/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public interface UserOperations {

    User searchUser(String identification);

    User searchUser(User user);

    ArrayList<User> sortUsers(User allUsers[]);

    ArrayList<User> sortUsers(String identification, User allUsers[]);

}
