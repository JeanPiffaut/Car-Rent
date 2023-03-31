/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * to change this license
 */

package com.mycompany.car.rent;

import java.util.GregorianCalendar;

/**
 *
 * @author piffa
 */
public class CarRent {

    public static void main(String[] args) {
        // Vehiculos
        Vehiculo v1 = new Vehiculo("ASDCE-EE", "Honda","CR-V",2014);
        Vehiculo v2 = new Vehiculo("ASDCE-EE", "Nissan","Rogue",2018);
        Vehiculo v3 = new Vehiculo("ASDCE-EE", "Jeep","Cherokee",2015);
        
        // Cliente
        Cliente c1 = new Cliente("12345678-5", "Juanito Peres");
        //cliente.deshabilitarCliente();
        
        GregorianCalendar date = new GregorianCalendar();
        Arriendo ar = new Arriendo(1, date, 7, 34000, v1, c1);
        ar.generarTicket();
    }
}
