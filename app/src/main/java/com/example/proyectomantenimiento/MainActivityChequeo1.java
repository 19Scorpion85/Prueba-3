package com.example.proyectomantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectomantenimiento.Utilidades.Utilidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivityChequeo1 extends AppCompatActivity {

    TextView patente;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8;
    Button entrar1;
    Button guardar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity1_motor);

      // Pantalla de chequeo MainActivity1Motor
        patente=(TextView)findViewById(R.id.txtPatente);
        c1=(CheckBox)findViewById(R.id.i1);
        c2=(CheckBox)findViewById(R.id.i2);
        c3=(CheckBox)findViewById(R.id.i3);
        c4=(CheckBox)findViewById(R.id.i4);
        c5=(CheckBox)findViewById(R.id.i5);
        c6=(CheckBox)findViewById(R.id.i6);
        c7=(CheckBox)findViewById(R.id.i7);
        c8=(CheckBox)findViewById(R.id.i8);
        entrar1=(Button)findViewById(R.id.btnSiguiente1);
        guardar1=(Button)findViewById(R.id.btnGuardar1);

        entrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Guardar();
               Intent entrar=new Intent(MainActivityChequeo1.this, MainActivityChequeo2.class);
                startActivity(entrar);
            }
        });

        guardar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Guardar();
             //   Intent entrar=new Intent(MainActivity1Motor.this,MainActivityLista.class);
               // startActivity(entrar);
            }
        });
    }

    public void Guardar(){
       //Conexión BD
          ConexionSQLliteHerper conn=new ConexionSQLliteHerper(this, "ChequeoBD",null,1);
          SQLiteDatabase BaseDeDatos = conn.getWritableDatabase();

        String pat=patente.getText().toString();
        Integer id1=1;
        Integer id2=2;
        Integer id3=3;
        Integer id4=4;
        Integer id5=5;
        Integer id6=6;
        Integer id7=7;
        Integer id8=8;
        String date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());//Fecha y hora actual
        String est1,est2,est3,est4,est5,est6,est7,est8;
        String rut="xxxxxxx-x";//prueba hasta conexión con webservice
        String obs="Sin observaciones";
        ContentValues agregar=new ContentValues();

        if(c1.isChecked()==true){
            est1="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id1);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est1);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
            //prueba
               Toast toast = Toast.makeText(this, "c1 Ingresado: "+agregar, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
        }else{
            est1="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id1);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est1);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
        }

        if(c2.isChecked()==true){
            est2="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id2);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est2);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);

            //prueba
               Toast toast = Toast.makeText(this, "c2 Ingresado: "+agregar, Toast.LENGTH_LONG);
                 toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
               toast.show();
        }else{
            est2="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id2);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est2);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
        }
        if(c3.isChecked()==true){
            est3="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id3);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est3);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
            //prueba
               Toast toast = Toast.makeText(this, "c3 Ingresado: "+agregar, Toast.LENGTH_LONG);
                 toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
               toast.show();

        }else{
            est3="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id3);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est3);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
        }

        if(c4.isChecked()==true){
            est4="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id4);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est4);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
            //prueba
               Toast toast = Toast.makeText(this, "c4 Ingresado: "+agregar, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
        }else{
            est4="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id4);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est4);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
        }

        if(c5.isChecked()==true){
            est5="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id5);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est5);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);

            //prueba
               Toast toast = Toast.makeText(this, "c5 Ingresado: "+agregar, Toast.LENGTH_LONG);
                 toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
               toast.show();
        }else{
            est5="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id5);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est5);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
        }

        if(c6.isChecked()==true){
            est6="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id6);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est6);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);

            //prueba
               Toast toast = Toast.makeText(this, "c6 Ingresado: "+agregar, Toast.LENGTH_LONG);
                 toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
               toast.show();

        }else{
            est6="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id6);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est6);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
        }

        if(c7.isChecked()==true){
            est7="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id7);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est7);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);


            //prueba
               Toast toast = Toast.makeText(this, "c7 Ingresado: "+agregar, Toast.LENGTH_LONG);
                 toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();

        }else{
            est7="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id7);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est7);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
        }

        if(c8.isChecked()==true){
            est8="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id8);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est8);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
            //prueba
                Toast toast = Toast.makeText(this, "c8 Ingresado: "+agregar, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
        }else{
            est8="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id8);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est8);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
        }

        //prueba
        //    Toast toast = Toast.makeText(this, "c1 Ingresado: "+agregar, Toast.LENGTH_LONG);
        //     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        //    toast.show();

    }


}