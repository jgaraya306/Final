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
public class Space {

    private int idParking;
    private int idCustomer;
    private int id;
    private boolean disabilityAdaptation;
    private boolean spaceTaken;
    private String vehicleType;

    public Space() {
    }

    public Space(int idParking, int id, boolean disabilityAdaptation, boolean spaceTaken, String vehicleType,int idCustomer) {
        this.idParking = idParking;
        this.id = id;
        this.disabilityAdaptation = disabilityAdaptation;
        this.spaceTaken = spaceTaken;
        this.vehicleType = vehicleType;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
    
    

    public int getIdParking() {
        return idParking;
    }

    public void setIdParking(int idParking) {
        this.idParking = idParking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public boolean isDisabilityAdaptation() {
        return disabilityAdaptation;
    }

    public void setDisabilityAdaptation(boolean disabilityAdaptation) {
        this.disabilityAdaptation = disabilityAdaptation;
    }

    public boolean isSpaceTaken() {
        return spaceTaken;
    }

    public void setSpaceTaken(boolean spaceTaken) {
        this.spaceTaken = spaceTaken;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

}
