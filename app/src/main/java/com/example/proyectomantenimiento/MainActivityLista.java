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

    Button verRegistros;
    ListView lvChequeo;
    ArrayList<String> listaInformacion;
    ArrayList<Chequeo> listaChequeos;
    ConexionSQLliteHerper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista);
        conn=new ConexionSQLliteHerper(getApplicationContext(),"ChequeoBD",null,1);
        verRegistros=(Button)findViewById(R.id.btnVerRegistros);
        lvChequeo=(ListView) findViewById(R.id.listListar);
        consultarListaChequeos();
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);


        verRegistros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvChequeo.setAdapter(adapter);

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
            listaInformacion.add(" PATENTE: "+listaChequeos.get(i).getPatente()+"\n ID CHEQUEO: "+listaChequeos.get(i).getIdChequeo()+" \n FECHA REVISIÓN: "+listaChequeos.get(i).getFechaRevision()+"\n ESTADO: "+listaChequeos.get(i).getEstadoRevision()+"\n MECÁNICO: "+listaChequeos.get(i).getRutMecanico()+"\n OBS: "+listaChequeos.get(i).getObs());
        }
    }


}