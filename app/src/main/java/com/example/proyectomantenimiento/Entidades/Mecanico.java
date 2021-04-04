package com.example.proyectomantenimiento.Entidades;

public class Mecanico {

    private String rut;
    private String PrimerNombre;
    private String SegundoNombre;
    private String apellidoP;
    private String apellidoM;

    public Mecanico(String rut, String primerNombre, String segundoNombre, String apellidoP, String apellidoM) {
        this.rut = rut;
        PrimerNombre = primerNombre;
        SegundoNombre = segundoNombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        PrimerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        SegundoNombre = segundoNombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
}
