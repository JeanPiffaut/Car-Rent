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

    public GregorianCalendar getFechaDevolucion() {
        return fecha_devolucion;
    }

    public void setFechaDevolucion(GregorianCalendar fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }
    
    public String getFechaFormateada() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(getFechaDevolucion().getTime());
    }

    public Arriendo getArriendo() {
        return arriendo;
    }

    public void setArriendo(Arriendo arriendo) {
        this.arriendo = arriendo;
    }

    public GregorianCalendar getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(GregorianCalendar fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public int getMontoMulta() {
        return monto_multa;
    }

    public void setMontoMulta(int monto_multa) {
        this.monto_multa = monto_multa;
    }
    
    public void ingresarDevolucion() {
        int dif = calcularAtraso();
        if(dif==0){
            setMontoMulta(0);
            this.arriendo.getVehiculo().setCondicion("D");
            //System.out.println("Devolución vehiculo: " + this.arriendo.getVehiculo() + " OK. \n");
        }else{
            setMontoMulta(this.arriendo.getMonto() * dif);
            //System.out.println("Vehiculo: " + this.arriendo.getVehiculo() + " con " + dif + " días de multa: $" + getMontoMulta() + ", favor actualizar contrato de arriendo. \n");  
        }
        
        generarTicket();
    }
    
    public int calcularAtraso() {
        long diferenciaEnMilisegundos = getFechaDevolucion().getTimeInMillis() - getArriendo().getFechaArriendo().getTimeInMillis();
        int dias = (int)(diferenciaEnMilisegundos / (24 * 60 * 60 * 1000));
        int pactado = getArriendo().getDias();
        
        int diff = dias - pactado;
        return diff;
    }
    
    @Override
    public String toString() {
        return "ARRIENDO: " + getArriendo() + "\t" +
               "FECHA DEVOLUCIÓN: " + getFechaDevolucion() + "\t" ;
    }
    
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
}
