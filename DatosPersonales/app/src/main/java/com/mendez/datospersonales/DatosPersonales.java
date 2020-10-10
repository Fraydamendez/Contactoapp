package com.mendez.datospersonales;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


public class DatosPersonales extends AppCompatActivity {



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_datos);
        TextView tvFec;
        TextView tvTele;
        TextView tvEma;
        TextView tvDes;
        TextView tvNom;

        //Importando texto


        Bundle bundle = getIntent().getExtras();

        String nombre = bundle.getString("Nombre");
        String fecha = bundle.getString("Fecha");
        String telefono = bundle.getString("Telefono");
        String email = bundle.getString("Email");
        String descrip = bundle.getString("Descripcion");

        tvNom = findViewById(R.id.tvNombre);

        tvFec   = (TextView) findViewById(R.id.tvFecha);
        tvTele   = (TextView) findViewById(R.id.tvTelefono);
        tvEma       = (TextView) findViewById(R.id.tvEmail);
        tvDes = (TextView) findViewById(R.id.tvDescripcion);

        tvNom.setText("Telefono: "+ nombre);
        tvFec.setText("Fecha Nac.: "+ fecha);
        tvTele.setText("Telefono: "+ telefono);
        tvEma.setText("Email: " + email);
        tvDes.setText("Descripción de contacto: "+ descrip);



        Button botonEdit = (Button) findViewById(R.id.botonEditar);
        botonEdit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onBackPressed();

            }




        });

    }

    public boolean OnKeyDown (int keyCode, KeyEvent event){

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent (DatosPersonales.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
