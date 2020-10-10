package com.mendez.datospersonales;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity<nombre> extends AppCompatActivity {



    EditText mTv;
    Button mDisplayDate;


    DatePickerDialog.OnDateSetListener onDateSetListener;

    @RequiresApi(api = Build.VERSION_CODES.M)

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        final EditText etNom;
        final EditText etfech;
        final EditText etTelefono;
        final EditText etEmail;
        final EditText etDescripcion;



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = (EditText) findViewById(R.id.textInFecha);
        mDisplayDate = (Button) findViewById(R.id.BotonFecha);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal = Calendar.getInstance();
                int dia = cal.get(Calendar.DAY_OF_MONTH);
                int mes = cal.get(Calendar.MONTH);
                int ano = cal.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker datePicker, int mAno, int mMes, int mDia) {
                     mTv.setText("" + mDia + " / " + (mMes + 1) + " / " + mAno);

                    }

                }, dia, mes, ano);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }

        });



        etNom = (EditText) findViewById(R.id.textImNom);
        etfech = (EditText) findViewById(R.id.textInFecha);
        etTelefono = (EditText) findViewById(R.id.textInTele);
        etEmail = (EditText) findViewById(R.id.textInEmail);
        etDescripcion = (EditText) findViewById(R.id.textInDescrip);
        Button siguiente = (Button) findViewById(R.id.BotonSiguiente);



        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DatosPersonales.class);
                intent.putExtra("Nombre", etNom.getText().toString().trim());
                intent.putExtra("Fecha", etfech.getText().toString().trim());
                intent.putExtra("Telefono", etTelefono.getText().toString().trim());
                intent.putExtra("Email", etEmail.getText().toString().trim());
                intent.putExtra("Descripcion", etDescripcion.getText().toString().trim());
                startActivity(intent);

             }

        });

    }


    @Override
    protected void onPause() {
        super.onPause();
    }




}



