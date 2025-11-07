package com.politecnicomalaga.dados6;

import android.os.Bundle;
import android.view.View;
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

    public void clickButton(View v){
        byte n1=0,n2=0,n3=0,n4=0;
        byte cantidad6J1 =0;
        byte cantidad6J2=0;

        String ganador="";

        int totalSumaJugador1;
        int totalSumaJugador2;

        n1 = (byte)(Math.random()*6+1);
        n2 = (byte)(Math.random()*6+1);
        n3 = (byte)(Math.random()*6+1);
        n4 = (byte)(Math.random()*6+1);

        TextView tv = findViewById(R.id.tvResultadoDado1);
        tv.setText(String.valueOf(n1));
        tv = findViewById(R.id.tvResultadoDado2);
        tv.setText(String.valueOf(n2));
        tv = findViewById(R.id.tvResultadoDado3);
        tv.setText(String.valueOf(n3));
        tv = findViewById(R.id.tvResultadoDado4);
        tv.setText(String.valueOf(n4));

        if (n1 == 6){
            cantidad6J1++;
        }
        if (n2 == 6){
            cantidad6J1++;
        }
        if (n3 == 6){
            cantidad6J2++;
        }
        if (n4 == 6){
            cantidad6J2++;
        }

        if (cantidad6J1 > cantidad6J2){
            ganador= "Gana el jugador 1";
        } else if (cantidad6J2>cantidad6J1){
            ganador="Gana el jugador 2";
        } else {
            totalSumaJugador1=n1+n2;
            totalSumaJugador2=n3+n4;
            if (totalSumaJugador1>totalSumaJugador2){
                ganador="Gana el jugador 1";
            } else if (totalSumaJugador1<totalSumaJugador2){
                ganador="Gana el jugador 2";
            } else{
                ganador="Empate";
            }
        }

        tv = findViewById(R.id.tvResultadoDadoFinal);
        tv.setText(ganador);
    }
}

