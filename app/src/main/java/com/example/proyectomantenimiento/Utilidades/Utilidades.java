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



    public static final String TABLA_VEHICULO="vehiculo";
    public static final String CAMPO_PATENTE_V="patente_v";
    public static final String CAMPO_MODELO="modelo";
    public static final String CAMPO_COMBUSTIBLE="combustible";
    public static final String CAMPO_MOTOR="motor";
    public static final String CAMPO_CHASIS="chasis";
    public static final String CAMPO_KM="km";
    public static final String CAMPO_HORAS="horas";
    public static final String CAMPO_ANIO="anio";
    public static final String CAMPO_TIPO_COMBUSTIBLE="anio";
    public static final String CREAR_TABLA_VEHICULO="CREATE TABLE "+TABLA_VEHICULO+"  ("+CAMPO_PATENTE_V+" TEXT," +
                                                                                     ""+CAMPO_MODELO+" TEXT," +
                                                                                     ""+CAMPO_COMBUSTIBLE+" FLOAT," +
                                                                                     ""+CAMPO_MOTOR+" TEXT, " +
                                                                                     ""+CAMPO_CHASIS+" TEXT," +
                                                                                     ""+CAMPO_KM+" INTEGER," +
                                                                                     ""+CAMPO_HORAS+" TEXT," +
                                                                                     ""+CAMPO_ANIO+" INTEGER," +
                                                                                     ""+CAMPO_TIPO_COMBUSTIBLE+" TEXT)";














}
