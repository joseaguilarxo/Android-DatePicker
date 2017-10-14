package com.joseaguilar.calendario_datepicker;

import android.app.DatePickerDialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Instanciamos variables para los elementos del layout
    EditText edtresultado;
    Button btnseleccion;

    //DatePicker - Paso 1: Creamos variables de : dia,mes,anio
    private int dia, mes, anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vinculamos elementos
        edtresultado = (EditText) findViewById(R.id.edtfecha);
        btnseleccion = (Button) findViewById(R.id.btngo);

        //creamos evento del boton
        btnseleccion.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnseleccion) {
            //DatePicker - Paso 2: Creamos elemento Calendar --!!IMPORTANTE: el Calendar debe de importarse de java.util.Calendar
            final Calendar calendar = Calendar.getInstance();
            //DatePicker - Paso 3: instanciamos valores de dia-mes-anio
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            anio = calendar.get(Calendar.YEAR);
            //DatePicker - Paso 4: Creamos la instancia de la clase DatePickerDialog
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    //DatePicker - Paso 5: hacemos que nuestro edittext recoja la seleccion
                    edtresultado.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                }
            }, dia, mes, anio);
            datePickerDialog.show();

        }
    }
}
