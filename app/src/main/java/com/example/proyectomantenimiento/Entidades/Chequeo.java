package com.example.proyectomantenimiento.Entidades;

import java.util.Date;

public class Chequeo  {
    private Vehiculo patente;
    private Integer idChequeo;
    private Date fechaRevision;
    private String tipoRevision;
    private Boolean estadoRevision;
    private Mecanico rutMecanico;
    private String obs;

    public Chequeo(Vehiculo patente, Integer idChequeo, Date fechaRevision, String tipoRevision, Boolean estadoRevision, Mecanico rutMecanico, String obs) {
        this.patente = patente;
        this.idChequeo = idChequeo;
        this.fechaRevision = fechaRevision;
        this.tipoRevision = tipoRevision;
        this.estadoRevision = estadoRevision;
        this.rutMecanico = rutMecanico;
        this.obs = obs;
    }

    public Vehiculo getPatente() {
        return patente;
    }

    public void setPatente(Vehiculo patente) {
        this.patente = patente;
    }

    public Integer getIdChequeo() {
        return idChequeo;
    }

    public void setIdChequeo(Integer idChequeo) {
        this.idChequeo = idChequeo;
    }

    public Date getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(Date fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getTipoRevision() {
        return tipoRevision;
    }

    public void setTipoRevision(String tipoRevision) {
        this.tipoRevision = tipoRevision;
    }

    public Boolean getEstadoRevision() {
        return estadoRevision;
    }

    public void setEstadoRevision(Boolean estadoRevision) {
        this.estadoRevision = estadoRevision;
    }

    public Mecanico getRutMecanico() {
        return rutMecanico;
    }

    public void setRutMecanico(Mecanico rutMecanico) {
        this.rutMecanico = rutMecanico;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
