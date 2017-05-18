/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Esteban
 */
public abstract class User {

    private String identification;
    private String name;
    private String username;
    private String password;
    private String address;

    public User() {
    }

    public User(String identification, String name, String username, String password,String address) {
        this.identification = identification;
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract boolean verifyUserLogin(String[] loginDetails);

}
