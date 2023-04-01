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
    
    @Override
    public String toString() {
        return "ARRIENDO: " + getArriendo() + "\t" +
               "FECHA DEVOLUCIÓN: " + getFechaDevolucion() + "\t" ;
    }
}
