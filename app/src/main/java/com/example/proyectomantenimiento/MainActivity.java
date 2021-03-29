package com.example.proyectomantenimiento;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText usuario = findViewById(R.id.txtUsuario);
        EditText pass = findViewById(R.id.txtContraseña);
        entrar=(Button)findViewById(R.id.btnIngresar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje="Usuario o contraseña incorrecto";
                if(usuario.getText().toString().equals("mecanico") & pass.getText().toString().equals("123")){
                    Intent entrar=new Intent(MainActivity.this,MainActivityMenu.class);
                    startActivity(entrar);
                }else{
                    if(usuario.getText().toString().equals("") & pass.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"Ingrese los datos solicitados",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecto",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}