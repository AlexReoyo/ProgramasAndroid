package com.politecnicomalaga.cifradov2;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
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
    public void ParImpar(View v){
        CheckBox encriptado;
        encriptado =  (CheckBox) findViewById(R.id.cbEncriptar);
        boolean desencriptar = encriptado.isChecked();

        String textoIntroducido="";
        String textoDesordenado="";
        int numCaracteres;
        char posicion=' ';
        String partePar="";
        String parteImpar="";
        int numCaracterespar;
        int numCaracteresImpar;

        EditText frase;
        frase = (EditText) findViewById(R.id.etFrase);
        textoIntroducido = frase.getText().toString();
        numCaracteres = textoIntroducido.length();

        if (desencriptar){
            numCaracterespar = (numCaracteres/2)+(numCaracteres%2);
            numCaracteresImpar = numCaracteres-numCaracterespar;
            //parte par
            for (int i = 0; i < numCaracterespar;i++){
                posicion = textoIntroducido.charAt(i);
                partePar+=posicion;
            }
            //parte Impar
            for (int j = numCaracterespar;j <numCaracteres;j++){
                posicion = textoIntroducido.charAt(j);
                parteImpar+=posicion;
            }
            //union de ambas cadenas
            for (int k = 0; k < numCaracterespar;k++){
                posicion=partePar.charAt(k);
                textoDesordenado+=posicion;

                if (k < numCaracteresImpar) {
                    posicion = parteImpar.charAt(k);
                    textoDesordenado += posicion;
                }
            }
        }else {
            for (int i=0;i<numCaracteres;i+=2){
                posicion = textoIntroducido.charAt(i);
                textoDesordenado += posicion;
            }
            for (int i=1;i<numCaracteres;i+=2){
                posicion = textoIntroducido.charAt(i);
                textoDesordenado += posicion;
            }
        }

        TextView textoEncriptado;
        textoEncriptado = findViewById(R.id.tvFraseEncriptada);
        textoEncriptado.setText(textoDesordenado);
    }

    public void CesarN (View v){
        CheckBox encriptado;
        encriptado =  (CheckBox) findViewById(R.id.cbEncriptar);
        boolean desencriptar = encriptado.isChecked();

        String textoIntroducido="";
        String textoDesordenado="";
        String nAvance;
        int codigoLetra;
        char letra = ' ';
        int numCaracteres;
        int iNumeroAvance;

        EditText frase;
        frase = (EditText) findViewById(R.id.etFrase);
        textoIntroducido = frase.getText().toString();
        numCaracteres = textoIntroducido.length();

        EditText clave;
        clave = (EditText) findViewById(R.id.etLlave);
        nAvance = clave.getText().toString();
        iNumeroAvance = Integer.parseInt(nAvance);


        if (desencriptar){

            for (int i=0;i<numCaracteres;i++){
                letra = textoIntroducido.charAt(i);
                codigoLetra = letra;
                codigoLetra-=iNumeroAvance;
                codigoLetra = (codigoLetra + 256) % 256;
                codigoLetra%=256;

                letra = (char) codigoLetra;
                textoDesordenado+=letra;
            }

        } else {

            for (int i=0;i<numCaracteres;i++){
                letra = textoIntroducido.charAt(i);
                codigoLetra = letra;
                codigoLetra+=iNumeroAvance;
                codigoLetra%=256;

                letra = (char) codigoLetra;
                textoDesordenado+=letra;
            }
        }
        TextView textoEncriptado;
        textoEncriptado = findViewById(R.id.tvFraseEncriptada);
        textoEncriptado.setText(textoDesordenado);
    }


    public void CesarClave (View v){

        CheckBox encriptado;
        encriptado =  (CheckBox) findViewById(R.id.cbEncriptar);
        boolean desencriptar = encriptado.isChecked();

        String textoIntroducido="";
        String textoDesordenado="";

        int clave; //clave introducida
        String claveFormatoTexto; // la clave en formato string
        char posicionTexto; //letra extraida del texto
        char posicionClave; // numero extraido de la clave
        int codigoLetra; //codigo ascii de la la letra extraida
        int cantidadCaracteres; // cantidad total de caracteres del texto introducido
        int cantidadCaracteresClave; //cantidad de números que contiene la clave
        int cantidadCachos; // cantidad de segmentos en los que divido el texto según la clave
        int posicionLetra = 0; // posición de la letra por la que voy encriptando


        EditText frase;
        frase = (EditText) findViewById(R.id.etFrase);
        textoIntroducido = frase.getText().toString();

        EditText claveIntroducida;
        claveIntroducida = (EditText) findViewById(R.id.etLlave);
        claveFormatoTexto = claveIntroducida.getText().toString();

        cantidadCaracteresClave = claveFormatoTexto.length();
        cantidadCaracteres = textoIntroducido.length();

        if (cantidadCaracteres%cantidadCaracteresClave==0){
            cantidadCachos = cantidadCaracteres/cantidadCaracteresClave;
        } else {
            cantidadCachos = (cantidadCaracteres/cantidadCaracteresClave)+1;
        }

        if (desencriptar){

            for (int i =0;i<cantidadCachos;i++){
                //bucle para cada segmento dividido
                for(int j =0;j<cantidadCaracteresClave;j++) {
                    //bucle para cada letra de cada segmento
                    if(posicionLetra<cantidadCaracteres){
                        //condicional para parar cuando no queden mas numeros en el cacho y no de exception
                        posicionTexto = textoIntroducido.charAt(posicionLetra);
                        codigoLetra = posicionTexto;
                        posicionClave = claveFormatoTexto.charAt(j);

                        codigoLetra-= posicionClave;
                        codigoLetra+=48;

                        codigoLetra = (codigoLetra + 256) % 256;
                        codigoLetra%=256;

                        posicionTexto = (char) codigoLetra;
                        textoDesordenado+=posicionTexto;
                        posicionLetra++;
                    }
                }
            }

        } else {
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
                        textoDesordenado+=posicionTexto;
                        posicionLetra++;
                    }
                }
            }
        }

        TextView textoEncriptado;
        textoEncriptado = findViewById(R.id.tvFraseEncriptada);
        textoEncriptado.setText(textoDesordenado);



    }
    public void Copiar (View v){
        TextView contenido;
        contenido = findViewById(R.id.tvFraseEncriptada);
        String textToCopy = contenido.getText().toString();

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("texto", textToCopy);
        clipboard.setPrimaryClip(clip);
    }





}