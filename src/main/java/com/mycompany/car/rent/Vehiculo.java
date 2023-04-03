/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.car.rent;

/**
 *
 */
public final class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private int anio_fabricacion;
    private char condicion;

    public Vehiculo(String patente, String marca, String modelo, int anho) {
        setPatente(patente);
        setMarca(marca);
        setModelo(modelo);
        setAnioFabricacion(anho);
        setCondicion("D");
    }

    /**
     * Retorna la patente del vehiculo
     * @return String
     */
    public String getPatente() {
        return patente;
    }

    /**
     * Asigna la patente del vehiculo validando que tenga un largo de 8 caracteres
     * @param patente 
     */
    public void setPatente(String patente) {
        if (patente.length() != 8) {
            throw new IllegalArgumentException("La patente debe ser de 8 caracteres.");
        }
        
        this.patente = patente;
    }

    /**
     * Retorna la marca del vehiculo
     * @return String
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Asigna la marca al vehiculo
     * @param marca 
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Retorna la marca del vehiculo
     * @return String
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Asigna el modelo del vehiculo
     * @param modelo 
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Retorna el año de fabricacion del vehiculo
     * @return int
     */
    public int getAnioFabricacion() {
        return anio_fabricacion;
    }

    /**
     * Asigna el año de fabricacion del vehiculo
     * Esta debe ser mayor al año 2000
     * @param anio_fabricacion 
     */
    public void setAnioFabricacion(int anio_fabricacion) {
        if (anio_fabricacion < 2000) {
            throw new IllegalArgumentException("El año del vehiculo debe ser superior al 2000.");
        }
        
        this.anio_fabricacion = anio_fabricacion;
    }

    /**
     * Retorna la condicion del vehiculo
     * @return char
     */
    public char getCondicion() {
        return condicion;
    }

    /**
     * Asigna la condicion del vehiculo, este puede tener 3:
     * D = Disponible
     * A = Arrendado
     * M = Mantencion
     * @param condicion 
     */
    public void setCondicion(String condicion) {
        String condicion_upper = condicion.toUpperCase();
        if (!"D".equals(condicion_upper) 
                && !"A".equals(condicion_upper) 
                && !"M".equals(condicion_upper)) {
            throw new IllegalArgumentException("El tipo de condición no es valido.");
        }
        
        this.condicion = condicion_upper.charAt(0);
    }
    
    /**
     * Asigna el vehiculo a la condicion de mantencion
     * Imprime el estado del vehiculo
     */
    public void asignarVehiculoEnMantencion() {
        setCondicion("M");
        System.out.println(toString());
    }
    
    @Override
    public String toString() {
        return "PATENTE: " + getPatente() + "\t" +
               "MODELO: " + getModelo() + "\t" +
               "MARCA: " + getMarca() + "\t" +
               "CONDICION: " + getCondicion();
    }
}
