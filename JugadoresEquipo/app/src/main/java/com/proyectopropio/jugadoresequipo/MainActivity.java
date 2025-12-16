package com.proyectopropio.jugadoresequipo;

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

    Jugador [] equipo = new Jugador[6];

    public void AltaJugador (View v){
        TextView tv;
        tv = findViewById(R.id.tvResultadoAlta);
        EditText et;
        Jugador nuevo;
        boolean termine=false;
        et = (EditText) findViewById(R.id.etNombre);
        String nombre = et.getText().toString();
        et = (EditText) findViewById(R.id.etApellido1);
        String apellido1 = et.getText().toString();
        et = (EditText) findViewById(R.id.etApellido2);
        String apellido2 = et.getText().toString();
        et = (EditText) findViewById(R.id.etDni);
        String dni = et.getText().toString();
        et = (EditText) findViewById(R.id.etEmail);
        String email = et.getText().toString();
        et = (EditText) findViewById(R.id.etTelefono);
        String telefono = et.getText().toString();
        et = (EditText) findViewById(R.id.etDorsal);
        String dorsalStr = et.getText().toString();
        int dorsal = Integer.parseInt(dorsalStr);
        CheckBox cb;
        cb = (CheckBox) findViewById(R.id.cbPortero);
        boolean esportero = cb.isChecked();

        nuevo = new Jugador(nombre,apellido1,apellido2,dni,email,telefono, dorsal);
        if (esportero){
            if (equipo[0]==null){
                equipo[0] = nuevo;
                tv.setText("Portero asignado :)");
            } else {
                tv.setText("Oh oh, ya hay portero");
            }
        }else{
            //insertar en hueco
            for (int i =1;i<equipo.length && !termine;i++){
                if (equipo[i]==null){
                    equipo[i]=nuevo;
                    tv.setText("Equipo asignado");
                    termine=true;
                }
            }
            if (!termine){
                tv.setText("No hay más sitio :(");
            }
        }
    }

    public void bajaJugador (View v){
        TextView tv;
        EditText et;
        tv = findViewById(R.id.tvResultadoBaja);
        et = findViewById(R.id.etPosicion);

        String posicionStr = et.getText().toString();
        int eliminado = Integer.parseInt(posicionStr);
            equipo[eliminado]=null;
            tv.setText("Jugador eliminado");

    }

    public void buscarTodos (View v){
        String resultado="";
        TextView tv;
        tv = findViewById(R.id.tvResultadoBusqueda);
        for (int i =0;i<equipo.length;i++){
            if (equipo[i]!=null){
                resultado+=(equipo[i].toString());
                resultado+="\n";
            }
        }
        tv.setText(resultado);
    }


}