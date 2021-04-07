package com.example.proyectomantenimiento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.proyectomantenimiento.Entidades.Chequeo;
import com.example.proyectomantenimiento.Utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class MainActivityLista extends AppCompatActivity {

    Button ver;
    ListView lista;
    ArrayList<Chequeo> listaChequeo;
    ArrayList<String> listaInformacion;
    ConexionSQLliteHerper conn;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista);

        lista=(ListView)findViewById(R.id.listChequeos);
        text=(TextView)findViewById(R.id.txtLista);
         conn=new ConexionSQLliteHerper(this, "ChequeoBD",null,1);
         mostrarChequeos();

        ArrayAdapter adaptador=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);

        lista.setAdapter(adaptador);
    }

    private void mostrarChequeos(){
        //Conexión BD
         conn=new ConexionSQLliteHerper(this, "ChequeoBD",null,1);
        SQLiteDatabase BaseDeDatos = conn.getReadableDatabase();
        Chequeo chequeo=null;
        listaChequeo=new ArrayList<Chequeo>();
        Cursor cursor=BaseDeDatos.rawQuery("SELECT * FROM "+Utilidades.TABLA_CHEQUEO,null);

        while (cursor.moveToNext()){
             chequeo=new Chequeo();
            chequeo.setPatente(cursor.getString(0));
            chequeo.setIdChequeo(cursor.getInt(1));
            chequeo.setFechaRevision(cursor.getString(2));
            chequeo.setEstadoRevision(cursor.getString(3));
            chequeo.setRutMecanico(cursor.getString(4));
            chequeo.setObs(cursor.getString(5));

            listaChequeo.add(chequeo);
        }
        obtenerLista();
    }

    private void obtenerLista(){
        listaInformacion=new ArrayList<String>();

        for (int i=0;i<listaChequeo.size();i++){
            listaInformacion.add(listaChequeo.get(i).getPatente()+" - "+listaChequeo.get(i).getIdChequeo()+" - "+listaChequeo.get(i).getFechaRevision()+" - "+listaChequeo.get(i).getEstadoRevision()+"- "+listaChequeo.get(i).getRutMecanico()+" -"+listaChequeo.get(i).getObs());
        }


    }










}