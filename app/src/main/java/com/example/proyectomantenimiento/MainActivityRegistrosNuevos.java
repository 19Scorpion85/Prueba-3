package com.example.proyectomantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectomantenimiento.Utilidades.Utilidades;

public class MainActivityRegistrosNuevos extends AppCompatActivity {

    Button guardar1;
    Button eliminar1;
    Button actualizar1;
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
    ConexionSQLiteHerperVehiculo conn=new ConexionSQLiteHerperVehiculo(this, "VehiculoBD",null,1);
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
        horasMotor=(TextView)findViewById(R.id.txtHrs);
        minMotor=(TextView)findViewById(R.id.txtMin);
        anio=(TextView)findViewById(R.id.txtAnio);
        tipoCombustible=(TextView)findViewById(R.id.txtTipoCombustible);

        guardar1=(Button)findViewById(R.id.btnGuardar2);
        eliminar1=(Button)findViewById(R.id.btnEliminar);
        actualizar1=(Button)findViewById(R.id.btnModificar);

        guardar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarVehiculos();

            }
        });

        eliminar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EliminarVehiculo();

            }
        });

        actualizar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActualizarVehiculo();

            }
        });

    }

    private void EliminarVehiculo() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros={patente.getText().toString()};
        ContentValues eliminar=new ContentValues();
        db.delete(Utilidades.TABLA_VEHICULO,Utilidades.CAMPO_PATENTE_V+"=?",parametros);
        Toast toast = Toast.makeText(this, "vehiculo eliminado correctamente", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();

    }

    private void ActualizarVehiculo() {

        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros={patente.getText().toString()};
        ContentValues actualizar=new ContentValues();

        String mod=modelo.getText().toString();
        String comb=combustible.getText().toString();
        String mot=motor.getText().toString();
        String chas=chasis.getText().toString();
        String km=kms.getText().toString();
        String horasMotor2=horasMotor.getText().toString();
        String minMotor2=minMotor.getText().toString();
        String anio2=anio.getText().toString();
        String tipoComb=tipoCombustible.getText().toString();

        actualizar.put(Utilidades.CAMPO_MODELO,mod);
        actualizar.put(Utilidades.CAMPO_COMBUSTIBLE,comb);
        actualizar.put(Utilidades.CAMPO_MOTOR,mot);
        actualizar.put(Utilidades.CAMPO_CHASIS,chas);
        actualizar.put(Utilidades.CAMPO_KM,km);
        actualizar.put(Utilidades.CAMPO_HORAS,horasMotor2+":"+minMotor2);
        actualizar.put(Utilidades.CAMPO_ANIO,anio2);
        actualizar.put(Utilidades.CAMPO_TIPO_COMBUSTIBLE,tipoComb);

        db.update(Utilidades.TABLA_VEHICULO,actualizar,Utilidades.CAMPO_PATENTE_V+"=?",parametros);
        Toast toast = Toast.makeText(this, "vehiculo actualizado: "+actualizar, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();

        db.close();
    }

    public  void GuardarVehiculos(){


        SQLiteDatabase db = conn.getWritableDatabase();
        Long idResultante;
        String pat=patente.getText().toString();
        String mod=modelo.getText().toString();
        String comb=combustible.getText().toString();
        String mot=motor.getText().toString();
        String chas=chasis.getText().toString();
        String km=kms.getText().toString();
        String horasMotor2=horasMotor.getText().toString();
        String minMotor2=minMotor.getText().toString();
        String anio2=anio.getText().toString();
        String tipoComb=tipoCombustible.getText().toString();

        ContentValues agregar=new ContentValues();

        agregar.put(Utilidades.CAMPO_PATENTE_V,pat);
        agregar.put(Utilidades.CAMPO_MODELO,mod);
        agregar.put(Utilidades.CAMPO_COMBUSTIBLE,comb);
        agregar.put(Utilidades.CAMPO_MOTOR,mot);
        agregar.put(Utilidades.CAMPO_CHASIS,chas);
        agregar.put(Utilidades.CAMPO_KM,km);
        agregar.put(Utilidades.CAMPO_HORAS,horasMotor2+":"+minMotor2);
        agregar.put(Utilidades.CAMPO_ANIO,anio2);
        agregar.put(Utilidades.CAMPO_TIPO_COMBUSTIBLE,tipoComb);

        db.insert(Utilidades.TABLA_VEHICULO,Utilidades.CAMPO_PATENTE_V,agregar);

            //prueba
       //     Toast toast = Toast.makeText(this, "Vehículo ingresado : "+idResultante, Toast.LENGTH_LONG);
        //    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        //    toast.show();

            Toast toast = Toast.makeText(this, "vehiculo Ingresado: "+agregar, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();

        db.close();


    }





}