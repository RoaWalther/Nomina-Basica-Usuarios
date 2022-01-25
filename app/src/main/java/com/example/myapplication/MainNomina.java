package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainNomina extends AppCompatActivity {

    private TextView resultado;
    private final String salto="\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nomina);

        resultado= findViewById(R.id.lblResultado);

        Bundle miBundle = this.getIntent().getExtras();
        if (miBundle!= null) {
            StringBuilder txt= new StringBuilder();

            txt.append("Sueldo Basico: "+miBundle.getString("sueldoBase"));
            txt.append(salto+"Dias Laborados: ");
            txt.append(miBundle.getString("dias"));
            txt.append(salto+"%Salud: ");
            txt.append(miBundle.getFloat("salud"));
            txt.append(salto+"%Pension: ");
            txt.append(miBundle.getFloat("pension"));
            txt.append(salto+"%Deducidos: ");
            txt.append(miBundle.getFloat("descuento"));
            txt.append(salto);
            txt.append(salto);
            txt.append(salto);
            txt.append(salto);
            txt.append("Sueldo Neto: "+miBundle.getFloat("total"));
            resultado.setText(txt);
        }
    }

    public void regresar(View view) {
        finish();
    }
}