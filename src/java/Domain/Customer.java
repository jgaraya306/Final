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
    private boolean isGoldenCiticen;
    CustomerData customerData;

    public Customer() {
        super();
        customerData = new CustomerData();
    }

    public Customer(String identification, String name, String username, String password,String phone,String email, boolean disabilityPresented, String address, boolean isGoldenCiticen) {
        super(identification, name, username, password,address);
        this.disabilityPresented = disabilityPresented;
        this.isGoldenCiticen = isGoldenCiticen;
        this.phone= phone;
        this.email=email;
    }

    

    public boolean getIsDisabilityPresented() {
        return disabilityPresented;
    }

    public void setDisabilityPresented(boolean disabilityPresented) {
        this.disabilityPresented = disabilityPresented;
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

    public boolean getIsIsGoldenCiticen() {
        return isGoldenCiticen;
    }

    public void setIsGoldenCiticen(boolean isGoldenCiticen) {
        this.isGoldenCiticen = isGoldenCiticen;
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }



    @Override
    public boolean verifyUserLogin(String[] loginDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}