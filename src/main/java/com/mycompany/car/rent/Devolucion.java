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
public final class Devolucion {
    private GregorianCalendar fecha_devolucion;
    private Arriendo arriendo;
    private int monto_multa;

    public Devolucion(GregorianCalendar fecha_devolucion, Arriendo arriendo) {
        setFechaDevolucion(fecha_devolucion);
        setArriendo(arriendo);
    }

    /**
     * Retorna la fecha de devolucion del vehiculo
     * @return GregorianCalendar
     */
    public GregorianCalendar getFechaDevolucion() {
        return fecha_devolucion;
    }

    /**
     * Asgina la fecha de devolucion del vehiculo
     * @param fecha_devolucion 
     */
    public void setFechaDevolucion(GregorianCalendar fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }
    
    /**
     * Retorna la fecha de devolucion con el formato dd/MM/yyyy
     * @return String
     */
    public String getFechaFormateada() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(getFechaDevolucion().getTime());
    }

    /**
     * Retorna el objeto Arriendo asociado a la devolucion
     * @return Arriendo
     */
    public Arriendo getArriendo() {
        return arriendo;
    }

    /**
     * Asigna a la devolucion un arriendo
     * @param arriendo 
     */
    public void setArriendo(Arriendo arriendo) {
        this.arriendo = arriendo;
    }

    /**
     * Retorna el monto de multa que tiene la devolucion
     * @return int
     */
    public int getMontoMulta() {
        return monto_multa;
    }

    /**
     * Asigna el monto de la multa que tiene la devolucion
     * @param monto_multa 
     */
    public void setMontoMulta(int monto_multa) {
        this.monto_multa = monto_multa;
    }
    
    /**
     * Ingresa la devolucion al sistema
     * Valida si el cliente y que el arriendo sean vigentes
     * Calcula en base a la fecha de arriendo y la fecha de devolucion si es que se debe asignar una multa al cliente
     */
    public void ingresarDevolucion() {
        if ((getArriendo().getCliente().isVigente() == false && getArriendo().getVehiculo().getCondicion() != 'A')) {
            throw new IllegalArgumentException("El cliente o el vehículo no es valido para una devolución");
        }
        
        int dif = calcularAtraso();
        if(dif==0){
            setMontoMulta(0);
            getArriendo().getVehiculo().setCondicion("D");
        }else{
            setMontoMulta(getArriendo().getMonto() * dif);
        }
        
        generarTicket();
    }
    
    /**
     * Calcula y retorna en base a la fecha de arriendo y devolucion la diferencia de dias
     * @return int
     */
    public int calcularAtraso() {
        long diferenciaEnMilisegundos = getFechaDevolucion().getTimeInMillis() - getArriendo().getFechaArriendo().getTimeInMillis();
        int dias = (int)(diferenciaEnMilisegundos / (24 * 60 * 60 * 1000));
        int pactado = getArriendo().getDias();
        
        int diff = dias - pactado;
        return diff;
    }
    
    /**
     * Imprime un ticket el cual contiene toda la informacion de la devolucion generado
     */
    public void generarTicket() {       
        String ticket = 
               "---------------------------------------------\n" +
               "              DEVOLUCIÓN DE VEHÍCULO           \n" +
               "              NUMERO ARRIENDO: " + getArriendo().getNumero() + "\n"+
               "              VEHICULO: " + getArriendo().getVehiculo().getPatente() + " "+ getArriendo().getVehiculo().getMarca() +" "+ getArriendo().getVehiculo().getModelo() + "\n"+
               "              PRECIO DIARIO: " + getArriendo().getMonto()+ "\n"+
               "---------------------------------------------\n" +
               "| Fecha      | Cliente       | Días pactado | Atraso | Multa |\n" +
               "---------------------------------------------\n" +
               "| " + getFechaFormateada()+ " | " + getArriendo().getCliente().getCedula() + " / " + getArriendo().getCliente().getNombre() + " |  " + getArriendo().getDias() + "            | " + calcularAtraso() + " | $" + getMontoMulta() + " |\n" +
               "---------------------------------------------\n" +
               "                                             \n" + 
               "                               ______________\n" + 
               "                               FIRMA CLIENTE \n\n";
        
        System.out.println(ticket);
    }
    
    @Override
    public String toString() {
        return "ARRIENDO: " + getArriendo() + "\t" +
               "FECHA DEVOLUCIÓN: " + getFechaDevolucion() + "\t" +
               "MONTO MULTA: " + getMontoMulta()+ "\t";
    }
}
