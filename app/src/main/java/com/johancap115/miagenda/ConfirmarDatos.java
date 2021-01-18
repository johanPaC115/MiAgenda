package com.johancap115.miagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView txvNombre, txvFecha, txvTel, txvEmail, txvDesc;
    Contacto contact=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        txvNombre  = (TextView) findViewById(R.id.txvNombre);
        txvFecha   = (TextView) findViewById(R.id.txvFecha);
        txvTel     = (TextView) findViewById(R.id.txvTelefono);
        txvEmail   = (TextView) findViewById(R.id.txvEmail);
        txvDesc    = (TextView) findViewById(R.id.txvDescripcion);


        Bundle objtetoEnviado= getIntent().getExtras();

        if (objtetoEnviado!=null){
            contact=(Contacto) objtetoEnviado.getSerializable("contacto");
            txvNombre.setText(contact.getNombre());
            txvFecha.setText(contact.getFecha_nac());
            txvTel.setText(contact.getTelefono());
            txvEmail.setText(contact.getEmail());
            txvDesc.setText(contact.getDescripcion());
        }

    }

    public void confirmarContacto(View view) {
        editarcontacto();
    }

    private void editarcontacto() {
        Intent editIntent = new Intent(ConfirmarDatos.this, MainActivity.class);
        Bundle bundleContac = new Bundle();
        bundleContac.putSerializable("contacto", contact);
        editIntent.putExtras(bundleContac);
        startActivity(editIntent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intentBack = new Intent(ConfirmarDatos.this, MainActivity.class);
            startActivity(intentBack);
        }
        return super.onKeyDown(keyCode, event);
    }
}