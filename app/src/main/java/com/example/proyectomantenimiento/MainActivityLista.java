package com.example.proyectomantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectomantenimiento.Entidades.Chequeo;
import com.example.proyectomantenimiento.Entidades.Vehiculo;
import com.example.proyectomantenimiento.Utilidades.Utilidades;

import java.util.ArrayList;

public class MainActivityLista extends AppCompatActivity {

    Button verRegistros;
    Button verVehiculos;
    Button buscarVehiculo;

    TextView patente;
    ListView lvChequeo;
    ListView lvVehiculo;
    ListView lvDetalles;

    ArrayList<String> listaInformacion;
    ArrayList<Chequeo> listaChequeos;
    ArrayList<String> listaInformacionVehiculos;
    ArrayList<Vehiculo> listaVehiculos;
    ArrayList<String> listaInformacionPatente;
    ArrayList<Vehiculo> listaVehiculosPatente;

    ArrayAdapter adapter1;
    ArrayAdapter adapter2;
    ArrayAdapter adapter3;

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
        buscarVehiculo=(Button)findViewById(R.id.btnBuscarVehiculo);
        patente=(TextView)findViewById(R.id.txtBuscarPatente);

        lvVehiculo=(ListView)findViewById(R.id.listListar);
        lvChequeo=(ListView)findViewById(R.id.listListar);
        lvDetalles=(ListView)findViewById(R.id.listListar);

        consultarListaChequeos();
        consultarListaVehiculos();
       // consultarListaPatente();

        adapter1=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacionVehiculos);
        adapter2=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);
    //    adapter3=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacionPatente);

        verRegistros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvChequeo.setAdapter(adapter2);
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


       // buscarVehiculo.setOnClickListener(new View.OnClickListener() {
       //     @Override
        //    public void onClick(View v) {
        //        lvDetalles.setAdapter(adapter3);


           // }
      //  });

        /*
        lvDetalles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                String informacion="PATENTE: "+listaVehiculos.get(pos).getPatente()+"\n";
                informacion+="MODELO: "+listaVehiculos.get(pos).getModelo()+"\n";
                informacion+="COMBUSTIBLE: "+listaVehiculos.get(pos).getCombustible()+"\n";
                informacion+="MOTOR: "+listaVehiculos.get(pos).getMotor()+"\n";
                informacion+="CHASIS: "+listaVehiculos.get(pos).getChasis()+"\n";
                informacion+="KMS: "+listaVehiculos.get(pos).getKm()+"\n";
                informacion+="HORAS MOTOR:  "+listaVehiculos.get(pos).getHorasMotor()+"\n";
                informacion+="AÑO: "+listaVehiculos.get(pos).getAnio()+"\n";
                informacion+="TIPO COMBUSTIBLE: "+listaVehiculos.get(pos).getTipoCombustible();
                Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).show();
            }
        });
*/
    }



    private void consultarListaChequeos() {
        SQLiteDatabase db=conn.getReadableDatabase();
        Chequeo cheq;//puede ser null
        listaChequeos=new ArrayList<Chequeo>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_CHEQUEO+" order by 1 and 3",null);
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
                                  "ID CHEQUEO: "+listaChequeos.get(i).getIdChequeo()+" \n "  +
                                 "FECHA REVISIÓN: "+listaChequeos.get(i).getFechaRevision()+"\n "   +
                                  "ESTADO: "+listaChequeos.get(i).getEstadoRevision()+"\n "
                            //+
                              //    "MECÁNICO: "+listaChequeos.get(i).getRutMecanico()+"\n " +
                             //     "OBS: "+listaChequeos.get(i).getObs()
                         );
        }
    }

    private void consultarListaVehiculos() {
        SQLiteDatabase db=conn2.getReadableDatabase();
        Vehiculo ve;//puede ser null
        listaVehiculos=new ArrayList<Vehiculo>();
        String order="order by 1";
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_VEHICULO+" order by 1",null);
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
                                           "TIPO COMBUSTIBLE: "+listaVehiculos.get(i).getTipoCombustible()
                             );
        }
    }
/*
    private void consultarListaPatente() {
        SQLiteDatabase db=conn2.getReadableDatabase();
        Vehiculo ve;//puede ser null
        listaVehiculosPatente=new ArrayList<Vehiculo>();
        patente.getText().toString();

        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_VEHICULO+" WHERE "+Utilidades.CAMPO_PATENTE_V+"="+patente,null);
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

            listaVehiculosPatente.add(ve);
        }
        obtenerListaVehiculosPatente();

    }

    private void obtenerListaVehiculosPatente() {
        listaInformacionPatente=new ArrayList<String>();

        for (int i=0;i<listaVehiculosPatente.size();i++){
            listaInformacionPatente.add(" PATENTE: "+listaVehiculosPatente.get(i).getPatente()+"\n" +
                    " MODELO: "+listaVehiculosPatente.get(i).getModelo()+" \n " +
                    "COMBUSTIBLE: "+listaVehiculosPatente.get(i).getCombustible()+"\n " +
                    "MOTOR: "+listaVehiculosPatente.get(i).getMotor()+"\n " +
                    "CHASIS: "+listaVehiculosPatente.get(i).getChasis()+"\n " +
                    "KMS: "+listaVehiculosPatente.get(i).getKm()+"\n " +
                    "HORAS MOTOR: "+listaVehiculosPatente.get(i).getHorasMotor()+"\n " +
                    "AÑO: "+listaVehiculosPatente.get(i).getAnio()+"\n " +
                    "TIPO COMBUSTIBLE: "+listaVehiculosPatente.get(i).getTipoCombustible()
            );
        }
    }
*/

}