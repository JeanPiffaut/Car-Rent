/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.car.rent;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 */
public final class Arriendo {
    private int numero;
    private GregorianCalendar fecha_arriendo;
    private int dias;
    private int monto;
    private Vehiculo vehiculo;
    private Cliente cliente;
    
    public Arriendo(int numero, GregorianCalendar fecha_arriendo, int dias, int monto, Vehiculo vehiculo, Cliente cliente) {
        setNumero(numero);
        setFechaArriendo(fecha_arriendo);
        setDias(dias);
        setMonto(monto);
        setVehiculo(vehiculo);
        setCliente(cliente);
        
        if (!evaluarArriendo()) {
            throw new IllegalArgumentException("El vehiculo o el cliente no son validos");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
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
        return this.fecha_arriendo;
    }
    
    public String getFechaFormateada() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(getFechaArriendo().getTime());
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

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    private boolean evaluarArriendo() {
        return !(!getCliente().isVigente() && getVehiculo().getCondicion() == 'D');
    }
    
    public boolean ingresarArriendo() {
        if (evaluarArriendo()) {
            getVehiculo().setCondicion("A");
            return true;
        } else {
            return false;
        }
    }
    
    public int obtenerMontoPagar() {
        return getDias() * getMonto();
    }
    
    public void generarTicket() {
        String ticket = 
               "---------------------------------------------\n" +
               "              ARRIENDO DE VEHÍCULO          \n" +
               "              NUMERO ARRIENDO: " + getNumero() + "\n"+
               "              VEHICULO: " + getVehiculo().getPatente() +" "+ getVehiculo().getMarca() +" "+ getVehiculo().getModelo() + "\n"+
               "              PRECIO DIARIO: " + getMonto()+ "\n"+
               "---------------------------------------------\n" +
               "| Fecha      | Cliente       | Días | Pagar |\n" +
               "---------------------------------------------\n" +
               "| " + getFechaFormateada() + " | " + getCliente().getNombre() + " |  " + getDias() + "   | $" + obtenerMontoPagar() + " |\n" +
               "---------------------------------------------\n" +
               "                                             \n" + 
               "                               ______________\n" + 
               "                               FIRMA CLIENTE \n\n";
        
        System.out.println(ticket);
    }
}