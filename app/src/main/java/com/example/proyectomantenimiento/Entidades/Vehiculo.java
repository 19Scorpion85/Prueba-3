package com.example.proyectomantenimiento.Entidades;

public class Vehiculo {

    private String patente;
    private String modelo;
    private int combustible;
    private String motor;
    private String chasis;
    private int km;
    private String horasMotor;
    private int anio;
    private String tipoCombustible;

    public Vehiculo(String patente, String modelo, int combustible, String motor, String chasis, int km, String horasMotor, int anio, String tipoCombustible) {
        this.patente = patente;
        this.modelo = modelo;
        this.combustible = combustible;
        this.motor = motor;
        this.chasis = chasis;
        this.km = km;
        this.horasMotor = horasMotor;
        this.anio = anio;
        this.tipoCombustible = tipoCombustible;
    }

    public  Vehiculo(){}


    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getHorasMotor() {
        return horasMotor;
    }

    public void setHorasMotor(String horasMotor) {
        this.horasMotor = horasMotor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
}
