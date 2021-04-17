package com.example.proyectomantenimiento;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.proyectomantenimiento.Utilidades.Utilidades;

public class ConexionSQLiteHerperVehiculo extends SQLiteOpenHelper {

    public ConexionSQLiteHerperVehiculo(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_VEHICULO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CREAR_TABLA_VEHICULO");
        onCreate(db);
    }
}
