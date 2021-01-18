package com.johancap115.miagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.audiofx.AudioEffect;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private TextInputEditText dateText, nombreText, telText, emailText, descripText;

    private  Contacto myContacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatePicker();

        dateText = findViewById(R.id.txtPickerDate);
        nombreText = (TextInputEditText) findViewById(R.id.txtInputNombre);
        telText = (TextInputEditText) findViewById(R.id.txtInputTelefono);
        emailText = (TextInputEditText) findViewById(R.id.txtInputEmail);
        descripText = (TextInputEditText) findViewById(R.id.txtInputDescripcion);

       Bundle objetoCreado= getIntent().getExtras();
       if(objetoCreado!=null){
           myContacto =(Contacto) objetoCreado.getSerializable("contacto");
           nombreText.setText(myContacto.getNombre());
           dateText.setText(myContacto.getFecha_nac());
           telText.setText(myContacto.getTelefono());
           emailText.setText(myContacto.getEmail());
           descripText.setText(myContacto.getDescripcion());
       }
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month +1;
                String date = makeDateString(month, dayOfMonth, year);
                dateText.setText(date);
            }
        };
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(  this, style, dateSetListener, year, month, day);
    }

    private String makeDateString(int month, int dayOfMonth, int year) {
        return getMonthFormat(month) + "/" + dayOfMonth + "/" + year;
    }

    private String getMonthFormat(int month) {
        String MES = "ENE";
        switch (month){
            case 1:  MES = "ENE"; break;
            case 2:  MES = "FEB"; break;
            case 3:  MES = "MAR"; break;
            case 4:  MES = "ABR"; break;
            case 5:  MES = "MAY"; break;
            case 6:  MES = "JUN"; break;
            case 7:  MES = "JUL"; break;
            case 8:  MES = "AGO"; break;
            case 9:  MES = "SEP"; break;
            case 10: MES = "OCT"; break;
            case 11: MES = "NOV"; break;
            case 12: MES = "DIC"; break;
        }
        return MES;
    }

    public void showDatePickerDialog(View view) {
        datePickerDialog.show();

    }

    public void crearContacto(View view) {
        agregarContacto();
    }

    private void agregarContacto() {
        //Creo el objeto Contacto
        String nom, fecha, tel, email, desc;
        nom = nombreText.getText().toString();
        fecha = dateText.getText().toString();
        tel = telText.getText().toString();
        email = emailText.getText().toString();
        desc = descripText.getText().toString();

        myContacto = new Contacto(nom, fecha, tel, email,desc);

        //Envio el objeto contacto a la siguiente Activity (ConfirmarDatos)
        Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("contacto", myContacto);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}