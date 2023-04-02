/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.car.rent;

import java.util.GregorianCalendar;

/**
 *
 */
public final class Devolucion {
    private GregorianCalendar fecha_devolucion;
    private Arriendo arriendo;

    public Devolucion(GregorianCalendar fecha_devolucion, Arriendo arriendo) {
        setFechaDevolucion(fecha_devolucion);
        setArriendo(arriendo);
    }

    public GregorianCalendar getFechaDevolucion() {
        return fecha_devolucion;
    }

    public void setFechaDevolucion(GregorianCalendar fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public Arriendo getArriendo() {
        return arriendo;
    }

    public void setArriendo(Arriendo arriendo) {
        this.arriendo = arriendo;
    }
    
   public void ingresarDevolucion(Arriendo arriendo) {
        int dif = aplicaMulta();
        if(dif==0){
            this.arriendo.getVehiculo().setCondicion("D");
            System.out.println("Devolución vehiculo: " + this.arriendo.getVehiculo() + " OK. \n");
        }else{
            int montoMulta = (this.arriendo.getMonto() * dif) - this.arriendo.obtenerMontoPagar();
            System.out.println("Vehiculo: " + this.arriendo.getVehiculo() + " con " + dif + " días de multa: $" + montoMulta + ", favor actualizar contrato de arriendo. \n");
        }
    }
    
    public int aplicaMulta() {
        //PENDIENTE: Determinar diferencia en dias entre "Fecha Arriendo" y "Fecha Devolucion".
        return 1;
    }
    
    @Override
    public String toString() {
        return "ARRIENDO: " + getArriendo() + "\t" +
               "FECHA DEVOLUCIÓN: " + getFechaDevolucion() + "\t" ;
    }
}
