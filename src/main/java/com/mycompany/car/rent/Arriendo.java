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
    private GregorianCalendar fecha_arriendo;
    private int dias;
    private Vehiculo vehiculo;
    private Cliente cliente;
    // OJO QUE FALTA LA RELACIÓN CON EL CLIENTE
    
    public Arriendo(int numero, GregorianCalendar fecha_arriendo, int dias, Vehiculo vehiculo, Cliente cliente) {
        setNumero(numero);
        setFechaArriendo(fecha_arriendo);
        setDias(dias);
        setVehiculo(vehiculo);
        setCliente(cliente);
        
        // LO NIEGO, YA QUE SI ES VÁLIDO EL MÉTODO ENTRARÁ A LA CONDICIÓN Y GATILLARÁ EL ERROR
        // POR LO QUE AL NEGARLO, EL TRUE LLEGA A SER FALSE Y EL FALSE LLEGA A SER TRUE
        if (!validarArriendo()) {
            throw new IllegalArgumentException("VEHICULO Ó CLIENTE INVÁLIDOS");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (!cliente.isVigente()) {
            throw new IllegalArgumentException("El cliente ingresado no es válido.");
        }
        this.cliente = cliente;
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
     * @return the fecha_arriendo
     */
    public GregorianCalendar getFechaArriendo() {
        return fecha_arriendo;
    }

    /**
     * @param fecha_arriendo the fecha_arriendo to set
     */
    public void setFechaArriendo(GregorianCalendar fecha_arriendo) {
        this.fecha_arriendo = fecha_arriendo;
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