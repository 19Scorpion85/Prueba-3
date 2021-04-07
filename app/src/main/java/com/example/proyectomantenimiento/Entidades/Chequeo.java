package com.example.proyectomantenimiento.Entidades;

import java.util.Date;

public class Chequeo  {
    private String patente;
    private Integer idChequeo;
    private String fechaRevision;
    private String tipoRevision;
    private String estadoRevision;
    private String rutMecanico;
    private String obs;

    public Chequeo(String patente, Integer idChequeo, String fechaRevision, String tipoRevision, String estadoRevision, String rutMecanico, String obs) {
        this.patente = patente;
        this.idChequeo = idChequeo;
        this.fechaRevision = fechaRevision;
        this.tipoRevision = tipoRevision;
        this.estadoRevision = estadoRevision;
        this.rutMecanico = rutMecanico;
        this.obs = obs;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Integer getIdChequeo() {
        return idChequeo;
    }

    public void setIdChequeo(Integer idChequeo) {
        this.idChequeo = idChequeo;
    }

    public String getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(String fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getTipoRevision() {
        return tipoRevision;
    }

    public void setTipoRevision(String tipoRevision) {
        this.tipoRevision = tipoRevision;
    }

    public String getEstadoRevision() {
        return estadoRevision;
    }

    public void setEstadoRevision(String estadoRevision) {
        this.estadoRevision = estadoRevision;
    }

    public String getRutMecanico() {
        return rutMecanico;
    }

    public void setRutMecanico(String rutMecanico) {
        this.rutMecanico = rutMecanico;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
