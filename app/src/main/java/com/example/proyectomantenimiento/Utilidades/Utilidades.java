package com.example.proyectomantenimiento.Utilidades;

public class Utilidades {

    //Constante campos tabla chequeo

    public static final String TABLA_CHEQUEO="chequeo";
    public static final String CAMPO_PATENTE="patente";
    public static final String CAMPO_IDCHEQUEO="idchequeo";
    public static final String CAMPO_FECHAREVISION="fecha";
    public static final String CAMPO_ESTADOREVISION="estadorevision";
    public static final String CAMPO_RUTMECANICO="rutmecanico";
    public static final String CAMPO_OBS="obs";

    public static final String CREAR_TABLA_CHEQUEO="CREATE TABLE "+TABLA_CHEQUEO+"  ("+CAMPO_PATENTE+" TEXT," +
                                                                                    ""+CAMPO_IDCHEQUEO+" INTEGER," +
                                                                                   " "+CAMPO_FECHAREVISION+" DATE," +
                                                                                   " "+CAMPO_ESTADOREVISION+" TEXT, " +
                                                                                    ""+CAMPO_RUTMECANICO+" TEXT," +
                                                                                   " "+CAMPO_OBS+" TEXT)";





}
