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
public class VehicleType {
    
    private int id;
    private String description;
    private byte numberOfTires; //# de llantas
    private float fee; //precio asignado

    public VehicleType(int id, String description, byte numberOfTires, float fee) {
        this.id = id;
        this.description = description;
        this.numberOfTires = numberOfTires;
        this.fee = fee;
    }

    public VehicleType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getNumberOfTires() {
        return numberOfTires;
    }

    public void setNumberOfTires(byte numberOfTires) {
        this.numberOfTires = numberOfTires;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }
    
    
}
