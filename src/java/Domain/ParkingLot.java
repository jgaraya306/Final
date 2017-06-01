/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Esteban
 */
public class ParkingLot {

    private int id;
    private String name;
    private transient int numberOfSpaces;
    private ArrayList<Vehicle> vehicles;
    private LinkedList<Space> spaces;
    private boolean ceiling;

    public ParkingLot() {

        //instanciamos e inicializamos los arreglos
        vehicles = new ArrayList<>();
        //hardcoded # de espacios
        spaces = new LinkedList<>();

    }

    //El constructor recibe un arreglo de vehiculos, el cual no se de donde sale
//    public ParkingLot(String name, int numberOfSpaces, ArrayList<Vehicle> vehicles, Space[] spaces, boolean ceiling) {
//        id++;
//        this.name = name;
//        this.numberOfSpaces = numberOfSpaces;
//        this.vehicles = vehicles;
//        this.spaces = spaces;
//        this.ceiling = ceiling;
//    }
    
    public ParkingLot(int id,String name, int numberOfSpaces, LinkedList<Space> spaces, boolean ceiling) {
        this.id = id;
        this.name = name;
        this.numberOfSpaces = numberOfSpaces;
        this.spaces = spaces;
        this.ceiling = ceiling;
    }

    public boolean isCeiling() {
        return ceiling;
    }

    public void setCeiling(boolean ceiling) {
        this.ceiling = ceiling;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSpaces() {
        return numberOfSpaces;
    }

    public void setNumberOfSpaces(int numberOfSpaces) {
        this.numberOfSpaces = numberOfSpaces;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public LinkedList<Space> getSpaces() {
        return spaces;
    }

    public void setSpaces(LinkedList<Space> spaces) {
        this.spaces = spaces;
    }

}
