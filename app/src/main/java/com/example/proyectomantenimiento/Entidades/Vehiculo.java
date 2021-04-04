package com.example.proyectomantenimiento.Entidades;

public class Vehiculo {
    private String patente;
    private String modelo;
    private Double combustible;
    private String motor;
    private String chasis;
    private Double km;
    private Integer horasMotor;
    private Integer minutosMotor;

    public Vehiculo(String patente, String modelo, Double combustible, String motor, String chasis, Double km, Integer horasMotor, Integer minutosMotor) {
        this.patente = patente;
        this.modelo = modelo;
        this.combustible = combustible;
        this.motor = motor;
        this.chasis = chasis;
        this.km = km;
        this.horasMotor = horasMotor;
        this.minutosMotor = minutosMotor;
    }

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

    public Double getCombustible() {
        return combustible;
    }

    public void setCombustible(Double combustible) {
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

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    public Integer getHorasMotor() {
        return horasMotor;
    }

    public void setHorasMotor(Integer horasMotor) {
        this.horasMotor = horasMotor;
    }

    public Integer getMinutosMotor() {
        return minutosMotor;
    }

    public void setMinutosMotor(Integer minutosMotor) {
        this.minutosMotor = minutosMotor;
    }
}
