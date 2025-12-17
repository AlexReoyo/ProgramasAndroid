package com.politecnicomalaga.login;

import android.graphics.Color;
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
    public void IniciarSesion(View v){
        EditText et;
        TextView tv = findViewById(R.id.tvResultado);

        String nombre = ((EditText)findViewById(R.id.etNombre)).getText().toString();
        String passwd = ((EditText) findViewById(R.id.etPasswd)).getText().toString();

        if (nombre.equalsIgnoreCase("User") && passwd.equalsIgnoreCase("1234")){
            tv.setText("Acceso permitido");
            tv.setBackgroundColor(Color.parseColor("#3ACA6D"));
        } else {
            tv.setText("Acceso denegado");
            tv.setBackgroundColor(Color.parseColor("#CA224F"));
        }
    }
}