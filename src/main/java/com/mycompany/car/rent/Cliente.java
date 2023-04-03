/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.car.rent;

/**
 *
 */
public final class Cliente {
    private String cedula;
    private String nombre;
    private boolean vigente;
    

    public Cliente(String cedula, String nombre) {
        setCedula(cedula);
        setNombre(nombre);
    }

    /**
     * Retorna la cedula del cliente
     * @return String
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Asigna y valida que la cedula ingresada para el cliente, sea valida
     * @param cedula 
     */
    public void setCedula(String cedula) {
        boolean validacion = false;
        try {
            String rut =  cedula.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
            throw new IllegalArgumentException("El rut ingresado no es valido.");
        } catch (Exception e) {
            throw new IllegalArgumentException("El rut ingresado no es valido.");
        }
        
        if (validacion) {
            this.cedula = cedula.toUpperCase();   
            setVigente(true);
        } else {
            setVigente(false);
            throw new IllegalArgumentException("El rut ingresado no es valido.");
        }
    }

    /**
     * Retorna el nombre del cliente
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del cliente
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna si el cliente esta vigente
     * @return boolean
     */
    public boolean isVigente() {
        return vigente;
    }

    /**
     * Asigna si el cliente esta vigente
     * @param vigente 
     */
    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
    
    /**
     * Deshabilita al cliente dependiendo de si el arriendo enviado por parametro no esta activo
     * @param arriendo 
     */
    public void deshabilitarCliente(Arriendo arriendo) {
        if (arriendo.getVehiculo().getCondicion() != 'A') {
            setVigente(false);
            System.out.println(toString());   
        } else {
            throw new IllegalArgumentException("Cliente figura con arriendos activos.");
        }
    }
    
    @Override
    public String toString() {
        return "CEDULA: " + getCedula() + "\t" + 
               "NOMBRE: " + getNombre() + "\t" + 
               "ES VALIDO: " + isVigente();
    }
}
