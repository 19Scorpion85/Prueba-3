package com.example.proyectomantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectomantenimiento.Utilidades.Utilidades;

import java.sql.Date;

public class MainActivity1Motor extends AppCompatActivity {

    TextView patente;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8;
    Button entrar1;
    Button guardar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity1_motor);

      //  ConexionSQLliteHerper conn=new ConexionSQLliteHerper(this,"bd_chequeo",null,1);
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
        guardar1=(Button)findViewById(R.id.btnGuardar);

        entrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent entrar=new Intent(MainActivity1Motor.this,MainActivity2EmbragueCaja.class);
                startActivity(entrar);

            }
        });
    }

    public void onClick(View view){
        registrarChequeosql();
    }

    private void registrarChequeosql() {
        ConexionSQLliteHerper conn=new ConexionSQLliteHerper((View.OnClickListener) this,"bd_chequeo",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        //insert into chequeo (patente,idchequeo,fecha,estadorevision,rutmecanico,obs) values()

        String insert="INSERT INTO "+Utilidades.TABLA_CHEQUEO
                               +"("
                               +Utilidades.CAMPO_PATENTE+","+Utilidades.CAMPO_IDCHEQUEO+","+Utilidades.CAMPO_FECHAREVISION+","+Utilidades.CAMPO_ESTADOREVISION+","+Utilidades.CAMPO_RUTMECANICO+","+Utilidades.CAMPO_OBS+")"+
                                "VALUES ('"+patente.getText().toString()+"',1,date('now'),"+c1.toString()+",'15943249-1','Sin obs')";

        db.execSQL(insert);
        db.close();

    }


}