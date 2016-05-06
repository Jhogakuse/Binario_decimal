package com.jho.ekt.decimalbin10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Binario extends AppCompatActivity {
    EditText activity2_txtdecimal, activity2_txtbinario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binario);

        InicializaCompenentes();
    }

    private void InicializaCompenentes(){
        activity2_txtdecimal=(EditText) findViewById(R.id.activity2_txtdecimal);
        activity2_txtbinario=(EditText) findViewById(R.id.activity2_txtbinario);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        String number = bundle.getString("NUMBER");
        activity2_txtdecimal.setText(number);

        try {
            //Binario a decimal
            String cifra = activity2_txtdecimal.getText().toString();
            int decimal=Integer.parseInt(cifra,2);
            String binary=Integer.toString(decimal);
            activity2_txtbinario.setText(binary);

        }catch (Exception e) {
            Toast.makeText(Binario.this, "Número incorrecto ", Toast.LENGTH_LONG).show();
        }
    }
}