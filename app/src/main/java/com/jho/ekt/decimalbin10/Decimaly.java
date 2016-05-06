package com.jho.ekt.decimalbin10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Decimaly extends AppCompatActivity {
    EditText activity3_txtdecimal, activity3_txtbinario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimaly);
        InicializaCompenentes();
    }

    private void InicializaCompenentes(){
        activity3_txtdecimal=(EditText) findViewById(R.id.activity3_txtdecimal);
        activity3_txtbinario=(EditText) findViewById(R.id.activity3_txtbinario);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        String number = bundle.getString("Decimo");
        activity3_txtbinario.setText(number);

        try {
            //Decimal a binario
            String cifra = activity3_txtbinario.getText().toString();
            int numero = Integer.parseInt(cifra);
            String binario = Integer.toBinaryString(numero);
            activity3_txtdecimal.setText(binario);
        }catch (Exception e) {
            Toast.makeText(Decimaly.this, "Formato incorrecto", Toast.LENGTH_LONG).show();
        }
    }
}