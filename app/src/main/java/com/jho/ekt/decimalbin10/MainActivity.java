package com.jho.ekt.decimalbin10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText activity1_txtvalor;
    Button activity1_btnB2D, activity1_btnD2B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializaComponentes();
    }

    private void InicializaComponentes(){
        activity1_txtvalor=(EditText) findViewById(R.id.activity1_txtvalor);
        activity1_btnB2D =(Button)findViewById(R.id.activity1_btnB2D);
        activity1_btnD2B =(Button)findViewById(R.id.activity1_btnD2B);

        activity1_btnB2D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                B2D();
            }
        });

        activity1_btnD2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                D2B();
            }
        });
    }

    private void B2D(){
        try {
            //Binario a decimal
            String cifra = activity1_txtvalor.getText().toString();
            int decimal=Integer.parseInt(cifra,2);

            //Creamos el Intent
            Intent intent =
                    new Intent(MainActivity.this, Binario.class);

            //Creamos la información a pasar entre actividades
            Bundle b = new Bundle();
            b.putString("NUMBER", activity1_txtvalor.getText().toString());

            //Añadimos la información al intent
            intent.putExtras(b);

            //Iniciamos la nueva actividad
            startActivity(intent);

        }catch (Exception e) {
            //Si ocurre algun error con la conversion la app se cierra, para evitarlo mandamos un Toast
            Toast.makeText(MainActivity.this, "Número incorrecto ", Toast.LENGTH_LONG).show();
        }
    }

    private void D2B(){
        try {
            //Decimal a binario
            String cifra = activity1_txtvalor.getText().toString();
            int numero = Integer.parseInt(cifra);
            String binario = Integer.toBinaryString(numero);

            //Creamos el Intent
            Intent intent =
                    new Intent(MainActivity.this, Decimaly.class);

            //Creamos la información a pasar entre actividades
            Bundle b = new Bundle();
            b.putString("Decimo", activity1_txtvalor.getText().toString());

            //Añadimos la información al intent
            intent.putExtras(b);

            //Iniciamos la nueva actividad
            startActivity(intent);
        }catch (Exception e) {
            //Si ocurre algun error con la conversion la app se cierra, para evitarlo mandamos un Toast
            Toast.makeText(MainActivity.this, "Formato incorrecto", Toast.LENGTH_LONG).show();
        }
    }
}