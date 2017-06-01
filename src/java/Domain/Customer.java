package Domain;

import Data.CustomerData;

import javax.swing.JOptionPane;

/**
 *
 * @author Esteban
 */
public class Customer extends User {
    
    private String phone;
    private String email;
    private boolean disabilityPresented;
    private boolean goldenCiticen;
    CustomerData customerData;
    private int id;

    public Customer() {
        super();
        customerData = new CustomerData();
    }

    public Customer(String identification, String name, String username, String password,String phone,String email, boolean disabilityPresented, String address, boolean isGoldenCiticen) {
        super(identification, name, username, password,address);
        this.disabilityPresented = disabilityPresented;
        this.goldenCiticen = isGoldenCiticen;
        this.phone= phone;
        this.email=email;

    }

    public boolean isGoldenCiticen() {
        return goldenCiticen;
    }

    public void setGoldenCiticen(boolean goldenCiticen) {
        this.goldenCiticen = goldenCiticen;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }

   public boolean isDisabilityPresented() {
        return disabilityPresented;
    }

    public void setDisabilityPresented(boolean disabilityPresented) {
        this.disabilityPresented = disabilityPresented;
    }

   

    @Override
    public boolean verifyUserLogin(String[] loginDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Customer{" + "phone=" + phone + ", email=" + email + ", disabilityPresented=" + disabilityPresented + ", isGoldenCiticen=" + goldenCiticen + ", customerData=" + customerData + ", id=" + id + '}';
    }

 
    
    
    
    
    
}