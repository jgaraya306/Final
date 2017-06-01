package Data;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Allan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CustomerData c=new CustomerData();
        VehicleData v=new VehicleData();
        ParkingLotData p=new ParkingLotData();
        try {
            c.sentEmail("Alan");
            // c.PrintCustomersPDF();
             //  v.PrintVehiclePDF();
             //  p.PrintParkingLotPDF();
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        ///} catch (FileNotFoundException ex) {
         //   Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
       // } catch (DocumentException ex) {
         //   Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  }
    
}