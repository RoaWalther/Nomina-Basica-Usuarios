package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText sueldo,diasTrabajados,pension,salud,descuentos;
    private float sueldoDia,sueldoBruto,sueldoNeto,porcentajePension,porcentajeSalud,descuento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sueldo= findViewById(R.id.txtSueldo);
        diasTrabajados= findViewById(R.id.txtDiasTrabajados);
        pension= findViewById(R.id.txtPension);
        salud= findViewById(R.id.txtSalud);
        descuentos= findViewById(R.id.txtDescuentos);

    }

    public void enviarNomina(View view) {

        try {
            sueldoDia= Float.parseFloat(sueldo.getText().toString())/30;
            sueldoBruto= sueldoDia*Float.parseFloat(diasTrabajados.getText().toString());
            porcentajePension =sueldoBruto*Float.parseFloat(pension.getText().toString())/100;
            porcentajeSalud = sueldoBruto*Float.parseFloat(salud.getText().toString())/100;
            descuento= sueldoBruto*Float.parseFloat(descuentos.getText().toString())/100;
            sueldoNeto= sueldoBruto-(porcentajePension+porcentajeSalud+descuento);

            Intent miIntent = new Intent(MainActivity.this,MainNomina.class);
            miIntent.putExtra("sueldoBase",sueldo.getText().toString());
            miIntent.putExtra("pension",porcentajePension);
            miIntent.putExtra("salud",porcentajeSalud);
            miIntent.putExtra("dias",diasTrabajados.getText().toString());
            miIntent.putExtra("descuento",descuento);
            miIntent.putExtra("total",sueldoNeto);
            startActivity(miIntent);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Campos Vacios",Toast.LENGTH_LONG).show();
        }


    }
}