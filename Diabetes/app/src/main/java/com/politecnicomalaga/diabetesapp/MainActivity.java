package com.politecnicomalaga.diabetesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Scanner;

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

    public void onClick (View v){

        EditText etGlucosa;
        EditText etDecision;
        TextView tvResultado;

        double glucemia;
        etGlucosa = (EditText) findViewById(R.id.etNivelGlucemia);
        String nivelGlucosa = etGlucosa.getText().toString();
        glucemia =Double.parseDouble(nivelGlucosa);

        String conscienteIntroducido = "";
        String ResultadoMostrado="";

        if (glucemia >= 180){
            ResultadoMostrado="Debe administrar agua y avisar a su familia";
        } else if (glucemia < 70 && glucemia>0){
            etDecision=(EditText) findViewById(R.id.etDecisionConsciente);
            conscienteIntroducido = etDecision.getText().toString();
            if (conscienteIntroducido.equalsIgnoreCase("si")){
                ResultadoMostrado="Dar líquidos azucarados e hidratos de carbono de absorción rápida y repetir prueba 5-10min después";
            } else if (conscienteIntroducido.equalsIgnoreCase("no")){
                ResultadoMostrado="No le des nada por la boca y debes administrar glucagón, Avisar a familia y a Emergencias";
            } else{
                ResultadoMostrado="No ha introducido el dato consciente correctamente";
            }

        } else if(glucemia >110 && glucemia<180){
            ResultadoMostrado="Repite el control dentro de 10 min";
        } else if (glucemia>=70 && glucemia<=110){
            ResultadoMostrado="Tu nivel de glucemia es normal";
        } else{
            ResultadoMostrado="La lectura introducida ha sido errónea, repita la prueba";
        }

        tvResultado = (TextView) findViewById(R.id.tvResultadoFinal);
        tvResultado.setText(ResultadoMostrado);
    }
}