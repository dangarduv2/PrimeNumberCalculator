package com.example.primenumberclculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void calcular(View view){
        TextView text= (TextView) findViewById(R.id.text);
        TextView tecla= (TextView) findViewById(R.id.tecla);
        int y = Integer.parseInt(tecla.getText().toString());

        if (y>=1 & y<10000){

            int v[] = new int[y];
            int posicion = 0;


            int divisibles;
            for (int i = 0; posicion < y; i++) { //no sale de este for sino está lleno el vector
                divisibles = 0;
                for (int j = 1; j <= i; j++) { // aqui este for, recorre todos los numeros detrás de el
                    if (i % j == 0) { //los números primos solo son divisible por 1 y por ellos mismo
                        divisibles++;
                    }
                }
                if (divisibles == 2) { //si es divisible por el y por 1 entrara
                    v[posicion] = i; // guardo numero el en vector
                    posicion++; // aumento una posicion para el sgte numero
                }
            }
            text.setText(String.valueOf(v[y-1]));//Mensaje que mostrara el TextView de el resultado
            //Toast que saltará cuando se calcule el primo
            Toast.makeText(this, R.string.done, Toast.LENGTH_SHORT).show();
        }else{Toast.makeText(this, R.string.unoydiez, Toast.LENGTH_SHORT).show();}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }
}