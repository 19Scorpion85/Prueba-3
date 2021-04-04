package com.example.proyectomantenimiento;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyectomantenimiento.Entidades.Mecanico;
import com.example.proyectomantenimiento.Entidades.Vehiculo;

import java.util.Date;

public class ConexionSQLliteHerper extends SQLiteOpenHelper {

    final String CREAR_TABLA_CHEQUEO="CREATE TABLE chequeo (patente TEXT,idchequeo INTEGER, fecharevision DATE,tiporevision TEXT, estadorevision TEXT, rutmecanico TEXT, obs TEXT)";

    public ConexionSQLliteHerper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_CHEQUEO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CREAR_TABLA_CHEQUEO");
        onCreate(db);
    }
}
