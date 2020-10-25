package com.caselles.mypuppy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class DetalleMascota extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_detalle);

        //getSupportActionBar().setTitle("Detalle");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*
        ActionBar Actionbar = getSupportActionBar();
        Actionbar.setTitle("Detalle");
        Actionbar.setDisplayShowHomeEnabled(true);
        Actionbar.setDisplayHomeAsUpEnabled(true);
         */

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("direccion");

        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }
}