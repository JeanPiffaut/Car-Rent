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
        
        // A: crear clientes
        Cliente c1 = new Cliente("12345678-5", "Juanito Peres");
        Cliente c2 = new Cliente("10649515-7", "Carlos Peres");
        Cliente c3 = new Cliente("14359340-1", "Miguel Peres");
        
        // B: crear vehiculos
        Vehiculo v1 = new Vehiculo("ASDCE-EE", "Honda","CR-V",2014);
        Vehiculo v2 = new Vehiculo("ASDCE-EE", "Nissan","Rogue",2018);
        Vehiculo v3 = new Vehiculo("ASDCE-EE", "Jeep","Cherokee",2015);
        
        // C: deshabilitar cliente
        c2.deshabilitarCliente();
       
        // D: asignar en mantencion a vehiculo
        v2.setCondicion("M");
        
        // E: ingresar 2 arriendos
        GregorianCalendar date1 = new GregorianCalendar(2023, 4, 05,10, 15);
        Arriendo ar1 = new Arriendo(1, date1, 7, 34000, v1, c1);
        ar1.generarTicket();
        
        GregorianCalendar date2 = new GregorianCalendar(2023, 4, 05,11, 00);
        Arriendo ar2 = new Arriendo(1, date2, 3, 45000, v2, c3);
        ar2.generarTicket();
        
        // F: ingresar devoluciones
        GregorianCalendar date_dev1 = new GregorianCalendar(2023, 4, 12,17, 54);
        Devolucion dev1 = new Devolucion(date_dev1, ar1);
        
        GregorianCalendar date_dev2 = new GregorianCalendar(2023, 4, 12,17, 54);
        Devolucion dev2 = new Devolucion(date_dev2, ar2);
    }
}
