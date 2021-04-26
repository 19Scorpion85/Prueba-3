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

public class MainActivityChequeo2 extends AppCompatActivity {
    Button entrar1;
    Button guardar2;
    TextView patente;
    CheckBox c1,c2,c3,c4,c5,c6,c7;
    MainActivityChequeo1 main1;
    String pat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_embrague_caja);
        patente=(TextView)findViewById(R.id.txtPatenteTitulo2);
        entrar1=(Button)findViewById(R.id.btnSiguiente2);
        guardar2=(Button)findViewById(R.id.btnGuardarAct2);
        c1=(CheckBox)findViewById(R.id.i9);
        c2=(CheckBox)findViewById(R.id.i10);
        c3=(CheckBox)findViewById(R.id.i11);
        c4=(CheckBox)findViewById(R.id.i12);
        c5=(CheckBox)findViewById(R.id.i13);
        c6=(CheckBox)findViewById(R.id.i14);
        c7=(CheckBox)findViewById(R.id.i15);
       // mensaje=main1.patente2.getSelectedItem().toString();

        entrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrar=new Intent(MainActivityChequeo2.this, MainActivityChequeo3.class);
                startActivity(entrar);
            }
        });

        guardar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guardar();

            }
        });
    }

    public void Guardar(){
        //Conexión BD
        ConexionSQLliteHerper conn=new ConexionSQLliteHerper(this, "ChequeoBD",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        pat=main1.patente2.getSelectedItem().toString();

        Integer id1=9;
        Integer id2=10;
        Integer id3=11;
        Integer id4=12;
        Integer id5=13;
        Integer id6=14;
        Integer id7=15;
        String date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());//Fecha y hora actual
        String est1,est2,est3,est4,est5,est6,est7;
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

            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);
            //prueba

        }else{
            est1="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id1);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est1);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);

        }

        if(c2.isChecked()==true){
            est2="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id2);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est2);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);
            //prueba
            //      Toast toast = Toast.makeText(this, "c2 Ingresado: "+agregar, Toast.LENGTH_LONG);
            //      toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            //  toast.show();
        }else{
            est2="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id2);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est2);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);

            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);

        }
        if(c3.isChecked()==true){
            est3="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id3);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est3);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);

            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);
            //prueba
            //    Toast toast = Toast.makeText(this, "c3 Ingresado: "+agregar, Toast.LENGTH_LONG);
            //     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            //    toast.show();

        }else{
            est3="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id3);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est3);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);

            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);
        }

        if(c4.isChecked()==true){
            est4="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id4);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est4);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);

            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);
            //prueba
            //   Toast toast = Toast.makeText(this, "c4 Ingresado: "+agregar, Toast.LENGTH_LONG);
            //    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            //   toast.show();
        }else{
            est4="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id4);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est4);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);

            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);
        }

        if(c5.isChecked()==true){
            est5="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id5);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est5);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);
            //prueba
            //   Toast toast = Toast.makeText(this, "c5 Ingresado: "+agregar, Toast.LENGTH_LONG);
            //     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            //   toast.show();
        }else{
            est5="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id5);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est5);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);
        }

        if(c6.isChecked()==true){
            est6="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id6);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est6);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);
            //prueba
            //  Toast toast = Toast.makeText(this, "c6 Ingresado: "+agregar, Toast.LENGTH_LONG);
            //     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            //   toast.show();

        }else{
            est6="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id6);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est6);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);
        }

        if(c7.isChecked()==true){
            est7="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id7);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est7);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);

            //prueba
            //    Toast toast = Toast.makeText(this, "c7 Ingresado: "+agregar, Toast.LENGTH_LONG);
            //     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            //   toast.show();

        }else{
            est7="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id7);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est7);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);
        }

        //prueba
        Toast toast = Toast.makeText(this, "Chequeo Ingresado Correctamentre: Patente "+pat, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();

    }











}