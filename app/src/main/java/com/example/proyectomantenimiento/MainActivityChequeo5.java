package com.example.proyectomantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyectomantenimiento.Entidades.Vehiculo;
import com.example.proyectomantenimiento.Utilidades.Utilidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivityChequeo5 extends AppCompatActivity {

    Button entrar1;
    Button guardar2;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8;
    String pat;
    ConexionSQLiteHerperVehiculo conn;
    Spinner patente2;
    ArrayList<String> listaPatente;
    ArrayList<Vehiculo> patenteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity6_suspension);
        conn=new ConexionSQLiteHerperVehiculo(getApplicationContext(),"VehiculoBD",null,1);

        guardar2=(Button)findViewById(R.id.btnGuardar5);

        c1=(CheckBox)findViewById(R.id.i37);
        c2=(CheckBox)findViewById(R.id.i38);
        c3=(CheckBox)findViewById(R.id.i39);
        c4=(CheckBox)findViewById(R.id.i40);
        c5=(CheckBox)findViewById(R.id.i41);
        c6=(CheckBox)findViewById(R.id.i42);
        c7=(CheckBox)findViewById(R.id.i43);
        c8=(CheckBox)findViewById(R.id.i44);


        patente2=(Spinner)findViewById(R.id.spPatente5);

        // mensaje=main1.patente2.getSelectedItem().toString();
        ConsultarListaVehiculos();

        //    String [] opciones={"Seleccione Patente:","Prueba spinner"};
        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter(this, android.R.layout.simple_spinner_item,listaPatente);

        patente2.setAdapter(adaptador);

        entrar1=(Button)findViewById(R.id.btnSiguiente6);

        entrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrar=new Intent(MainActivityChequeo5.this, MainActivityChequeo6.class);
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


    private void ConsultarListaVehiculos() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Vehiculo vehiculo=null;
        patenteList=new ArrayList<Vehiculo>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_VEHICULO,null);

        while(cursor.moveToNext()){
            vehiculo=new Vehiculo();
            vehiculo.setPatente(cursor.getString(0));
            Log.i("",vehiculo.getPatente().toString());
            patenteList.add(vehiculo);
        }
        obtenerListaPatente();
    }

    private void obtenerListaPatente() {
        listaPatente= new ArrayList<String>();
        listaPatente.add("Seleccione");

        for(int i=0;i<patenteList.size();i++){
            listaPatente.add(patenteList.get(i).getPatente());
        }
    }


    public void Guardar(){
        //Conexión BD
        ConexionSQLliteHerper conn=new ConexionSQLliteHerper(this, "ChequeoBD",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        pat=patente2.getSelectedItem().toString();

        Integer id1=37;
        Integer id2=38;
        Integer id3=39;
        Integer id4=40;
        Integer id5=41;
        Integer id6=42;
        Integer id7=43;
        Integer id8=44;

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

        if(c8.isChecked()==true){
            est8="Realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id8);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est8);
            agregar.put(Utilidades.CAMPO_RUTMECANICO,rut);
            agregar.put(Utilidades.CAMPO_OBS,obs);
            Long idResultante=db.insert(Utilidades.TABLA_CHEQUEO,Utilidades.CAMPO_IDCHEQUEO,agregar);

            //prueba
            //    Toast toast = Toast.makeText(this, "c7 Ingresado: "+agregar, Toast.LENGTH_LONG);
            //     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            //   toast.show();

        }else{
            est8="No realizado";
            agregar.put(Utilidades.CAMPO_PATENTE,pat);
            agregar.put(Utilidades.CAMPO_IDCHEQUEO,id8);
            agregar.put(Utilidades.CAMPO_FECHAREVISION,date);
            agregar.put(Utilidades.CAMPO_ESTADOREVISION,est8);
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