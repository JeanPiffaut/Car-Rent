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
        System.out.println("¿El cliente esta vigente? " + c1.isVigente());
        
        Cliente c2 = new Cliente("10649515-7", "Carlos Peres");
        System.out.println("¿El cliente esta vigente? " + c2.isVigente());
        
        Cliente c3 = new Cliente("14359340-1", "Miguel Peres");
        System.out.println("¿El cliente esta vigente? " + c3.isVigente());
        
        // B: crear vehiculos
        Vehiculo v1 = new Vehiculo("ASDCE-EE", "Honda","CR-V",2014);
        System.out.println("El vehículo " + v1.getPatente() + " esta en condición: " + v1.getCondicion());
        Vehiculo v2 = new Vehiculo("ASDCE-EE", "Nissan","Rogue",2018);
        System.out.println("El vehículo " + v2.getPatente() + " esta en condición: " + v2.getCondicion());
        Vehiculo v3 = new Vehiculo("ASDCE-EE", "Jeep","Cherokee",2015);
        System.out.println("El vehículo " + v3.getPatente() + " esta en condición: " + v3.getCondicion());
        
        // E: ingresar 2 arriendos
        GregorianCalendar date1 = new GregorianCalendar(2023, 4, 05,10, 15);
        Arriendo ar1 = new Arriendo(1, date1, 7, 34000, v1, c1);
        ar1.ingresarArriendo();
        
        // F: ingresar devoluciones
        GregorianCalendar date_dev1 = new GregorianCalendar(2023, 4, 12,17, 54);
        Devolucion dev1 = new Devolucion(date_dev1, ar1);
        dev1.ingresarDevolucion();
        
        GregorianCalendar date3 = new GregorianCalendar(2023, 4, 05,11, 00);
        Arriendo ar3 = new Arriendo(3, date3, 3, 45000, v3, c3);
        ar3.ingresarArriendo();
        
        GregorianCalendar date_dev3 = new GregorianCalendar(2023, 4, 12,17, 54);
        Devolucion dev3 = new Devolucion(date_dev3, ar3);
        dev3.ingresarDevolucion();
        
        // D: asignar en mantencion a vehiculo
        v2.asignarVehiculoEnMantencion();
        
        GregorianCalendar date2 = new GregorianCalendar(2023, 4, 05,11, 00);
        Arriendo ar2 = new Arriendo(2, date2, 3, 45000, v2, c2);
        ar2.ingresarArriendo();
        
        // C: deshabilitar cliente
        c2.deshabilitarCliente(ar2);
        
        GregorianCalendar date_dev2 = new GregorianCalendar(2023, 4, 12,17, 54);
        Devolucion dev2 = new Devolucion(date_dev2, ar2);
        dev2.ingresarDevolucion();
    }
}
