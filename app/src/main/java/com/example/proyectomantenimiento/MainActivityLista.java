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

import com.example.proyectomantenimiento.Entidades.Chequeo;
import com.example.proyectomantenimiento.Utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class MainActivityLista extends AppCompatActivity {

    Button ver;
    ListView lista;
    ArrayList<Chequeo> listaChequeo;
    ArrayList<String> listaInformacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista);
        lista=(ListView)findViewById(R.id.lvLista);

        ConexionSQLliteHerper conn=new ConexionSQLliteHerper(this, "ChequeoBD",null,1);

        ver=(Button)findViewById(R.id.btnLista);
        mostrarChequeos();
        ArrayAdapter adaptador=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);

        lista.setAdapter(adaptador);

    //    ver.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
             //   mostrarChequeos();


      //      }
   //     });
    }

    private void mostrarChequeos(){
        //Conexión BD
        ConexionSQLliteHerper conn=new ConexionSQLliteHerper(this, "ChequeoBD",null,1);
        SQLiteDatabase BaseDeDatos = conn.getReadableDatabase();
        Chequeo chequeo=null;
        listaChequeo=new ArrayList<>();
        Cursor cursor=BaseDeDatos.rawQuery("SELECT * FROM "+Utilidades.TABLA_CHEQUEO,null);


        //  public static final String CAMPO_PATENTE="patente";
        //  public static final String CAMPO_IDCHEQUEO="idchequeo";
        // public static final String CAMPO_FECHAREVISION="fecha";
        // public static final String CAMPO_ESTADOREVISION="estadorevision";
        //  public static final String CAMPO_RUTMECANICO="rutmecanico";
        // public static final String CAMPO_OBS="obs";
        while (cursor.moveToNext()){
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