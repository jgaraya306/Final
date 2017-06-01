/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.TariffData;
import Domain.Tariff;
import java.io.IOException;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Allan
 */
public class TariffBusiness {

    TariffData tariffData;

    public TariffBusiness() {
        tariffData = new TariffData();
    }

    public void insertTariff(Tariff tariff) throws IOException {
        String priceHalfHour = String.valueOf(tariff.getPriceHalfHour());
        String priceOneHour = String.valueOf(tariff.getPriceOneHour());
        String pricePerDay = String.valueOf(tariff.getPricePerDay());
        String pricePerMonth = String.valueOf(tariff.getPricePerMonth());
        String pricePerYear = String.valueOf(tariff.getPricePerYear());
        String vehicleType=String.valueOf(tariff.getVehicleType());
//regla de negocio de no permitir datos en blanco. Todos son requeridos.
        if (!priceHalfHour.equals("") && !priceOneHour.equals("")
                && !pricePerDay.equals("") && !pricePerMonth.equals("")
                && !pricePerYear.equals("")&&!vehicleType.equals("")){
                 
            tariffData.insertTariffJson(tariff);

        }

    }
     public void deleteTariff(int id) throws IOException, ParseException, java.text.ParseException {

        tariffData.deleteTariff(id);

    }

    public LinkedList<Tariff> getAllTariff() throws ParseException, java.text.ParseException {

        return tariffData.getAllTariff();
    }


    public void modifyTariff(int id, Tariff tariff) throws IOException, ParseException, java.text.ParseException {

        tariffData.modifyTariffFromFile(id, tariff);

    }
     public Tariff getTariffById(int id) throws ParseException, java.text.ParseException, IOException {

        Tariff tariff = new Tariff();
        tariff = tariffData.getTariffById(id);
        return tariff;
    }
}
