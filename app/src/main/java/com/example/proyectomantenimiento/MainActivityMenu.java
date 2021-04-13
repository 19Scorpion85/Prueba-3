package com.example.proyectomantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityMenu extends AppCompatActivity {
    Button entrar1;
    Button entrar2;
    Button entrar3;
    Button entrar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        entrar1=(Button)findViewById(R.id.btnMant);
        entrar2=(Button)findViewById(R.id.btnRegistro);
        entrar3=(Button)findViewById(R.id.btnLista);
        entrar4=(Button)findViewById(R.id.btnDescarga);

        entrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent entrar=new Intent(MainActivityMenu.this, MainActivityChequeo1.class);
                    startActivity(entrar);

            }
        });

        entrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrar2=new Intent(MainActivityMenu.this,MainActivityRegistrosNuevos.class);
                startActivity(entrar2);
            }
        });

        entrar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrar3=new Intent(MainActivityMenu.this,MainActivityLista.class);
                startActivity(entrar3);
            }
        });

        entrar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrar4=new Intent(MainActivityMenu.this,MainActivityDescarga.class);
                startActivity(entrar4);
            }
        });

    }
}