/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * to change this license
 */

package com.mycompany.car.rent;

/**
 *
 * @author piffa
 */
public class CarRent {

    public static void main(String[] args) {
        //Vehiculo v1 = new Vehiculo("", "","",0,"");
        Cliente cliente = new Cliente("12345678-5", "Juanito Peres");
        //cliente.deshabilitarCliente();
        System.out.println(cliente.toString());
    }
}
