package com.example.proyectomantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity1Motor extends AppCompatActivity {

    Button entrar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity1_motor);

        entrar1=(Button)findViewById(R.id.btnSiguiente5);

        entrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrar=new Intent(MainActivity1Motor.this,MainActivity2EmbragueCaja.class);
                startActivity(entrar);
            }
        });
    }
}