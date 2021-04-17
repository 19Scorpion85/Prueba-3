package com.example.proyectomantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyectomantenimiento.Utilidades.Utilidades;

public class MainActivityRegistrosNuevos extends AppCompatActivity {

    Button guardar1;
    TextView patente;
    TextView modelo;
    TextView combustible;
    TextView motor;
    TextView chasis;
    TextView kms;
    TextView horasMotor;
    TextView minMotor;
    TextView anio;
    TextView tipoCombustible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registros_nuevos);

        patente=(TextView)findViewById(R.id.txtPatente2);
        modelo=(TextView)findViewById(R.id.txtModelo);
        combustible=(TextView)findViewById(R.id.txtCombustible);
        motor=(TextView)findViewById(R.id.txtMotor);
        chasis=(TextView)findViewById(R.id.txtChasis);
        kms=(TextView)findViewById(R.id.txtKm);
        horasMotor=(TextView)findViewById(R.id.txtHorasMotor);
        minMotor=(TextView)findViewById(R.id.txtMin);
        anio=(TextView)findViewById(R.id.txtAnio);
        tipoCombustible=(TextView)findViewById(R.id.txtTipoCombustible);

        guardar1=(Button)findViewById(R.id.btnGuardar2);

        guardar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarVehiculos();

                //   Intent entrar=new Intent(MainActivity1Motor.this,MainActivityLista.class);
                // startActivity(entrar);
            }
        });

    }

    public  void GuardarVehiculos(){

        ConexionSQLiteHerperVehiculo conn=new ConexionSQLiteHerperVehiculo(this, "ChequeoBD",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        String pat=patente.getText().toString();
        String mod=modelo.getText().toString();
        String comb=combustible.getText().toString();
        String mot=motor.getText().toString();
        String chas=chasis.getText().toString();
        String km=kms.getText().toString();
        String horasMotor2=horasMotor.getText().toString()+":"+minMotor.getText().toString();
        String anio2=anio.getText().toString();
        String tipoComb=tipoCombustible.getText().toString();

        ContentValues agregar=new ContentValues();

        agregar.put(Utilidades.CAMPO_PATENTE_V,pat);
        agregar.put(Utilidades.CAMPO_MODELO,mod);
        agregar.put(Utilidades.CAMPO_COMBUSTIBLE,comb);
        agregar.put(Utilidades.CAMPO_MOTOR,mot);
        agregar.put(Utilidades.CAMPO_CHASIS,chas);
        agregar.put(Utilidades.CAMPO_KM,km);
        agregar.put(Utilidades.CAMPO_HORAS,horasMotor2);
        agregar.put(Utilidades.CAMPO_ANIO,anio2);
        agregar.put(Utilidades.CAMPO_TIPO_COMBUSTIBLE,tipoComb);




    }





}