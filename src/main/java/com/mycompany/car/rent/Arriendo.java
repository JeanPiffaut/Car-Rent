/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.car.rent;

import java.util.GregorianCalendar;

/**
 *
 */
public final class Arriendo {
    private int numero;
    private GregorianCalendar fechaArriendo;
    private int dias;
    private Vehiculo vehiculo;
    // OJO QUE FALTA LA RELACIÓN CON EL CLIENTE
    
    public Arriendo(int numero, GregorianCalendar fechaArriendo, int dias, Vehiculo vehiculo) {
        setNumero(numero);
        setFechaArriendo(fechaArriendo);
        setDias(dias);
        setVehiculo(vehiculo);
        
        // LO NIEGO, YA QUE SI ES VÁLIDO EL MÉTODO ENTRARÁ A LA CONDICIÓN Y GATILLARÁ EL ERROR
        // POR LO QUE AL NEGARLO, EL TRUE LLEGA A SER FALSE Y EL FALSE LLEGA A SER TRUE
        if (!validarArriendo()) {
            throw new IllegalArgumentException("VEHICULO Ó CLIENTE INVÁLIDOS");
        }
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the fechaArriendo
     */
    public GregorianCalendar getFechaArriendo() {
        return fechaArriendo;
    }

    /**
     * @param fechaArriendo the fechaArriendo to set
     */
    public void setFechaArriendo(GregorianCalendar fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    /**
     * @return the dias
     */
    public int getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(int dias) {
        // VALIDAR LA CANTIDAD DÍAS
        this.dias = dias;
    }

    /**
     * @return the vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    private boolean validarArriendo() {
        // OJO VALIDAR LA VIGENCIA DEL CLIENTE
        return getVehiculo().getCondicion() == 'D';
    }
}