package com.example.proyectomantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityChequeo5 extends AppCompatActivity {
    Button entrar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity6_suspension);

        entrar1=(Button)findViewById(R.id.btnSiguiente6);



        entrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrar=new Intent(MainActivityChequeo5.this, MainActivityChequeo6.class);
                startActivity(entrar);
            }
        });




    }
}