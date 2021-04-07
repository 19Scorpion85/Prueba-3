package com.example.proyectomantenimiento;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.proyectomantenimiento.Entidades.Mecanico;
import com.example.proyectomantenimiento.Entidades.Vehiculo;
import com.example.proyectomantenimiento.Utilidades.Utilidades;

import java.util.Date;

public class ConexionSQLliteHerper extends SQLiteOpenHelper {


    public ConexionSQLliteHerper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL(Utilidades.CREAR_TABLA_CHEQUEO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CREAR_TABLA_CHEQUEO");
        onCreate(db);
    }
}
