package com.politecnicomalaga.runmanager;

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




    Participante [] corredores = new Participante [100];

    public void Alta (View v){
        TextView tv;
        EditText et;
        tv = findViewById(R.id.tvResultadoAlta);

        et = findViewById(R.id.etDni);
        String dni = et.getText().toString();

        et = findViewById(R.id.etNombre);
        String nombre = et.getText().toString();

        et = findViewById(R.id.etApellidos);
        String apellidos= et.getText().toString();

        et = findViewById(R.id.etFechaNac);
        String fechaNac = et.getText().toString();

        et = findViewById(R.id.etEmail);
        String email =et.getText().toString();

        et = findViewById(R.id.etTelefono);
        String tfno =et.getText().toString();

        boolean termine=false;
        Participante nuevo;
        for (int i =0;i<corredores.length;i++){
            if (corredores[i]==null && !termine){
                nuevo= new Participante(dni,nombre,apellidos,fechaNac,email,tfno,(i+1));
                corredores[i]=nuevo;
                tv.setText("Corredor Añadido");
                termine=true;
            }
        }
        if (!termine){
            tv.setText("Ya no hay más sitio :(");
        }
    }

    public void Baja (View v){
        EditText et;
        TextView tv;
        tv = (TextView) findViewById(R.id.tvResultadoBaja);
        et = (EditText) findViewById(R.id.etDniBusqueda);
        boolean encontrado=false;
        String dni =et.getText().toString();
        for (int i =0;i<corredores.length && !encontrado;i++){
            if (corredores[i]!=null && corredores[i].getDni().equalsIgnoreCase(dni)){
                corredores[i]=null;
                tv.setText("Corredor eliminado");
                encontrado=true;
            }
        }
        if (!encontrado){
            tv.setText("No se ha encontrado ese participante");
        }
    }

    public void Buscar (View v){
        TextView tv = (TextView) findViewById(R.id.tvResultadoBusqueda);
        String resultado="";
        for (int i =0;i<corredores.length;i++){
            if (corredores[i]!=null){
                resultado+=corredores[i].toString();
                resultado+="\n";
                resultado+="\n";
            }
        }
        tv.setText(resultado);
    }
}