package com.example.proyectomantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.proyectomantenimiento.Entidades.Chequeo;
import com.example.proyectomantenimiento.Entidades.Vehiculo;
import com.example.proyectomantenimiento.Utilidades.Utilidades;

import java.util.ArrayList;

public class MainActivityLista extends AppCompatActivity {

    Button verRegistros;
    Button verVehiculos;

    ListView lvChequeo;
    ListView lvVehiculo;
    ArrayList<String> listaInformacion;
    ArrayList<Chequeo> listaChequeos;
    ArrayList<String> listaInformacionVehiculos;
    ArrayList<Vehiculo> listaVehiculos;
    ArrayAdapter adapter1;
    ArrayAdapter adapter2;
    ConexionSQLliteHerper conn;
    ConexionSQLiteHerperVehiculo conn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista);

        conn=new ConexionSQLliteHerper(getApplicationContext(),"ChequeoBD",null,1);
        conn2=new ConexionSQLiteHerperVehiculo(getApplicationContext(),"VehiculoBD",null,1);

        verRegistros=(Button)findViewById(R.id.btnListaChequeos);
        verVehiculos=(Button)findViewById(R.id.btnListaVehiculos);

        lvVehiculo=(ListView)findViewById(R.id.listListar);

        consultarListaChequeos();
        consultarListaVehiculos();

        adapter1=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacionVehiculos);
        adapter2=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);

        verRegistros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvVehiculo.setAdapter(adapter2);
             //   lvChequeo.setAdapter(adapter);
                //   Intent entrar=new Intent(MainActivity1Motor.this,MainActivityLista.class);
                // startActivity(entrar);
            }
        });

        verVehiculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lvVehiculo.setAdapter(adapter1);
                //   Intent entrar=new Intent(MainActivity1Motor.this,MainActivityLista.class);
                // startActivity(entrar);
            }
        });

    }

    private void consultarListaChequeos() {
        SQLiteDatabase db=conn.getReadableDatabase();
        Chequeo cheq;//puede ser null
        listaChequeos=new ArrayList<Chequeo>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_CHEQUEO,null);
        while (cursor.moveToNext()){
            cheq=new Chequeo();
            cheq.setPatente(cursor.getString(0));
            cheq.setIdChequeo(cursor.getInt(1));
            cheq.setFechaRevision(cursor.getString(2));
            cheq.setEstadoRevision(cursor.getString(3));
            cheq.setRutMecanico(cursor.getString(4));
            cheq.setObs(cursor.getString(5));
            listaChequeos.add(cheq);
        }
        obtenerLista();
    }



    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i=0;i<listaChequeos.size();i++){
            listaInformacion.add(" PATENTE: "+listaChequeos.get(i).getPatente()+"\n " +
                                  "ID CHEQUEO: "+listaChequeos.get(i).getIdChequeo()+" \n " +
                                  "FECHA REVISIÓN: "+listaChequeos.get(i).getFechaRevision()+"\n " +
                                  "ESTADO: "+listaChequeos.get(i).getEstadoRevision()+"\n " +
                                  "MECÁNICO: "+listaChequeos.get(i).getRutMecanico()+"\n " +
                                  "OBS: "+listaChequeos.get(i).getObs());
        }
    }


    private void consultarListaVehiculos() {
        SQLiteDatabase db=conn2.getReadableDatabase();
        Vehiculo ve;//puede ser null
        listaVehiculos=new ArrayList<Vehiculo>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_VEHICULO,null);
        while (cursor.moveToNext()){
            ve=new Vehiculo();
            ve.setPatente(cursor.getString(0));
            ve.setModelo(cursor.getString(1));
            ve.setCombustible(cursor.getInt(2));
            ve.setMotor(cursor.getString(3));
            ve.setChasis(cursor.getString(4));
            ve.setKm(cursor.getInt(5));
            ve.setHorasMotor(cursor.getString(6));
            ve.setAnio(cursor.getInt(7));
            ve.setTipoCombustible(cursor.getString(8));

            listaVehiculos.add(ve);
        }
        obtenerListaVehiculos();
    }

    private void obtenerListaVehiculos() {
        listaInformacionVehiculos=new ArrayList<String>();

        for (int i=0;i<listaVehiculos.size();i++){
            listaInformacionVehiculos.add(" PATENTE: "+listaVehiculos.get(i).getPatente()+"\n" +
                                          " MODELO: "+listaVehiculos.get(i).getModelo()+" \n " +
                                           "COMBUSTIBLE: "+listaVehiculos.get(i).getCombustible()+"\n " +
                                           "MOTOR: "+listaVehiculos.get(i).getMotor()+"\n " +
                                           "CHASIS: "+listaVehiculos.get(i).getChasis()+"\n " +
                                           "KMS: "+listaVehiculos.get(i).getKm()+"\n " +
                                           "HORAS MOTOR: "+listaVehiculos.get(i).getHorasMotor()+"\n " +
                                           "AÑO: "+listaVehiculos.get(i).getAnio()+"\n " +
                                           "TIPO COMBUSTIBLE: "+listaVehiculos.get(i).getTipoCombustible());
        }
    }





}