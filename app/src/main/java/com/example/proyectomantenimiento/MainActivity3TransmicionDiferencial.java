package com.example.proyectomantenimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3TransmicionDiferencial extends AppCompatActivity {
    Button entrar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_transmicion_diferencial);

        entrar1=(Button)findViewById(R.id.btnSiguiente3);



        entrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrar=new Intent(MainActivity3TransmicionDiferencial.this,MainActivity5DireccionYOtros.class);
                startActivity(entrar);
            }
        });




    }
}