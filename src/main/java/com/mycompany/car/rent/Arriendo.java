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
    
    /**
     * Retorna el objeto cliente asociado al arriendo
     * @return Cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Asigna el cliente enviado por parametro al arriendo
     * @param cliente: Cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna el identificador del arriendo
     * @return int
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Asigna el identificador al arriendo
     * @param numero: int 
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    /**
     * Retorna la fecha en la que se genero el arriendo
     * @return GregorianCalendar
     */
    public GregorianCalendar getFechaArriendo() {
        return this.fecha_arriendo;
    }
    
    /**
     * Asigna la fecha en la que se genero el arriendo
     * @param fecha_arriendo 
     */
    public void setFechaArriendo(GregorianCalendar fecha_arriendo) {
        this.fecha_arriendo = fecha_arriendo;
    }
    
    /**
     * Retorna la fecha de arriendo con formato dd/MM/yyyy
     * @return String
     */
    public String getFechaFormateada() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(getFechaArriendo().getTime());
    }

    /**
     * Retorna los dias por los que se arrendo el vehiculo
     * @return int
     */
    public int getDias() {
        return dias;
    }

    /**
     * Asigna la cantidad de dias que sera arrendado el vehiculo.
     * Se valida que la cantidad ingresada sea mayor a 0
     * @param dias 
     */
    public void setDias(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("El vehiculo debe arrendarce minimo por 1 dia.");
        }
        this.dias = dias;
    }

    /**
     * Retorna el objeto Vehiculo que se asigno al arriendo
     * @return Vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Asigna al arriendo el vehiculo que se le entregara al cliente.
     * @param vehiculo 
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Retorna el monto a pagar por cada dia arrendado.
     * @return 
     */
    public int getMonto() {
        return monto;
    }

    /**
     * Asigna el monto a pagar por cada dia arrendado.
     * @param monto 
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    /**
     * Valida que el cliente que arrendara siga vigente.
     * Valida que el vehículo a arrendarse este disponible.
     * @return boolean
     */
    private boolean evaluarArriendo() {
        return (getCliente().isVigente() && getVehiculo().getCondicion() == 'D');
    }
    
    /**
     * Valida que el arriendo sea valido con el metodo evaluarArriendo
     * Si es valido cambia la condicion del vehiculo a Arrendado
     * Genera el ticket con toda la informacion del arriendo.
     * @return boolean
     */
    public boolean ingresarArriendo() {
        if (evaluarArriendo()) {
            getVehiculo().setCondicion("A");
            generarTicket();
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Retorna el monto a pagar el cual se calcula en base al monto y los dias
     * @return 
     */
    public int obtenerMontoPagar() {
        return getDias() * getMonto();
    }
    
    /**
     * Imprime un ticket el cual contiene toda la informacion del arriendo generado
     */
    public void generarTicket() {
        String ticket = 
               "---------------------------------------------\n" +
               "              ARRIENDO DE VEHÍCULO           \n" +
               "              NUMERO ARRIENDO: " + getNumero() + "\n"+
               "              VEHICULO: " + getVehiculo().getPatente() +" "+ getVehiculo().getMarca() +" "+ getVehiculo().getModelo() + "\n"+
               "              PRECIO DIARIO: " + getMonto()+ "\n"+
               "---------------------------------------------\n" +
               "| Fecha      | Cliente       | Días | Pagar |\n" +
               "---------------------------------------------\n" +
               "| " + getFechaFormateada() + " | " + getCliente().getCedula() + " / " + getCliente().getNombre() + " |  " + getDias() + "   | $" + obtenerMontoPagar() + " |\n" +
               "---------------------------------------------\n" +
               "                                             \n" + 
               "                               ______________\n" + 
               "                               FIRMA CLIENTE \n\n";
        
        System.out.println(ticket);
    }
    
    @Override
    public String toString() {
        return "NUMERO: " + getNumero()+ "\t" +
               "FECHA ARRIENDO: " + getFechaFormateada()+ "\t" +
               "DIAS: " + getDias()+ "\t" +
               "MONTO: " + getMonto()+ "\t";
    }
}