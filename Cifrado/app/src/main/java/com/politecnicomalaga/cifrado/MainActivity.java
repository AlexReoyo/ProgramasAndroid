package com.politecnicomalaga.cifrado;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void ParImpar (View v){
        String textoIntroducido="";
        String textoDesordenado="";
        int numCaracteres;
        char posicion=' ';

        EditText etTextoIntroducido ;
        etTextoIntroducido = (EditText) findViewById(R.id.etFrase);
        textoIntroducido = etTextoIntroducido.getText().toString();
        numCaracteres = textoIntroducido.length();
        for (int i=0;i<numCaracteres;i+=2){
            posicion = textoIntroducido.charAt(i);
            textoDesordenado += posicion;
        }
        for (int i=1;i<numCaracteres;i+=2){
            posicion = textoIntroducido.charAt(i);
            textoDesordenado += posicion;
        }

        TextView tvResultado;
        tvResultado = (TextView) findViewById(R.id.tvTextoEncriptado);
        tvResultado.setText(textoDesordenado);
    }

    public void Cesar1 (View v){
        String textoIntroducido="";
        String textoEncriptado="";
        int codigoLetra;
        char letra = ' ';
        int numCaracteres;

        EditText etTextoIntroducido ;
        etTextoIntroducido = (EditText) findViewById(R.id.etFrase);
        textoIntroducido = etTextoIntroducido.getText().toString();
        numCaracteres = textoIntroducido.length();

        for (int i=0;i<numCaracteres;i++){
            letra = textoIntroducido.charAt(i);
            codigoLetra = letra;
            if (codigoLetra == 255){
                codigoLetra = 0;
            } else {
                codigoLetra+=1;
            }

            letra = (char) codigoLetra;
            textoEncriptado+=letra;
        }
        TextView tvResultado;
        tvResultado = (TextView) findViewById(R.id.tvTextoEncriptado);
        tvResultado.setText(textoEncriptado);
    }

    public void CesarN(View v){
        String textoIntroducido="";
        String textoEncriptado="";
        int codigoLetra;
        char letra = ' ';
        int numCaracteres;
        int numeroAvance;
        String numeroAvanceFormatoString;

        EditText etTextoIntroducido ;
        etTextoIntroducido = (EditText) findViewById(R.id.etFrase);
        textoIntroducido = etTextoIntroducido.getText().toString();

        EditText etN ;
        etN = (EditText) findViewById(R.id.etN);
        numeroAvanceFormatoString = etN.getText().toString();
        numeroAvance = Integer.parseInt(numeroAvanceFormatoString);
        numCaracteres = textoIntroducido.length();

        for (int i=0;i<numCaracteres;i++){
            letra = textoIntroducido.charAt(i);
            codigoLetra = letra;
            codigoLetra+=numeroAvance;
            codigoLetra%=256;
            letra = (char) codigoLetra;
            textoEncriptado+=letra;

        }
        TextView tvResultado;
        tvResultado = (TextView) findViewById(R.id.tvTextoEncriptado);
        tvResultado.setText(textoEncriptado);
    }

    public void CesarClave(View view) {
        String textoIntroducido="";
        String textoCodificado="";

        int clave; //clave introducida
        char posicionTexto; //letra extraida del texto
        char posicionClave; // numero extraido de la clave
        int codigoLetra; //codigo ascii de la la letra extraida
        int cantidadCaracteres; // cantidad total de caracteres del texto introducido
        int cantidadCaracteresClave; //cantidad de números que contiene la clave
        int cantidadCachos; // cantidad de segmentos en los que divido el texto según la clave
        int posicionLetra = 0; // posición de la letra por la que voy encriptando
        String claveFormatoTexto; // la clave en formato string


        EditText etTextoIntroducido ;
        etTextoIntroducido = (EditText) findViewById(R.id.etFrase);
        textoIntroducido = etTextoIntroducido.getText().toString();

        EditText etN ;
        etN = (EditText) findViewById(R.id.etClave);
        claveFormatoTexto = etN.getText().toString();

        cantidadCaracteres = textoIntroducido.length();
        cantidadCaracteresClave = claveFormatoTexto.length();

        if (cantidadCaracteres%cantidadCaracteresClave==0){
            cantidadCachos = cantidadCaracteres/cantidadCaracteresClave;
        } else {
            cantidadCachos = (cantidadCaracteres/cantidadCaracteresClave)+1;
        }


        for (int i =0;i<cantidadCachos;i++){
            //bucle para cada segmento dividido
            for(int j =0;j<cantidadCaracteresClave;j++) {
                //bucle para cada letra de cada segmento
                if(posicionLetra<cantidadCaracteres){
                    //condicional para parar cuando no queden mas numeros en el cacho y no de exception
                    posicionTexto = textoIntroducido.charAt(posicionLetra);
                    codigoLetra = posicionTexto;
                    posicionClave = claveFormatoTexto.charAt(j);


                    codigoLetra+= posicionClave;
                    codigoLetra-=48;

                    codigoLetra%=256;
                    posicionTexto = (char) codigoLetra;
                    textoCodificado+=posicionTexto;
                    posicionLetra++;
                }
            }
        }
        TextView tvResultado;
        tvResultado = (TextView) findViewById(R.id.tvTextoEncriptado);
        tvResultado.setText(textoCodificado);
    }
}