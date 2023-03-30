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
    private int anho;
    private char condicion;

    public Vehiculo(String patente, String marca, String modelo, int anho) {
        setPatente(patente);
        setMarca(marca);
        setModelo(modelo);
        setAnho(anho);
        setCondicion("D");
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        if (patente.length() != 8) {
            throw new IllegalArgumentException("La patente debe ser de 8 caracteres.");
        }
        
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        if (anho < 2000) {
            throw new IllegalArgumentException("El año del vehiculo debe ser superior al 2000.");
        }
        
        this.anho = anho;
    }

    public char getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        String condicion_upper = condicion.toUpperCase();
        if (!"D".equals(condicion_upper) 
                || !"A".equals(condicion_upper) 
                || !"M".equals(condicion_upper)) {
            throw new IllegalArgumentException("El tipo de condición no es valido.");
        }
        
        this.condicion = condicion_upper.charAt(0);
    }
    
    @Override
    public String toString() {
        return "PATENTE: " + getPatente() + "\t" +
                "MODELO: " + getModelo() + "\t" +
                "MARCA: " + getMarca() + "\t" +
                "CONDICION: " + getCondicion();
    }
}
