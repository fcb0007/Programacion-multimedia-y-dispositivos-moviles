package com.example.practica_5_login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText campoCorreo;
    private EditText campoContraseña;
    private Button botonContinuar;
    private Switch switchRecordarContraseña;
    private TextView textViewMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.checkBoxRecordarContraseña), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        campoCorreo = findViewById(R.id.campoCorreo);
        campoContraseña = findViewById(R.id.campoContraseña);
        botonContinuar = findViewById(R.id.botonContinuar);
        switchRecordarContraseña = findViewById(R.id.switchRecordarContraseña);
        textViewMensaje = findViewById(R.id.textViewMensaje);

        botonContinuar.setOnClickListener(v -> {
            String correo = campoCorreo.getText().toString();
            String contraseña = campoContraseña.getText().toString();

            Boolean recordarContraseña = switchRecordarContraseña.isChecked();

            if (correo.equals("correo@correo.com") && contraseña.equals("123") && recordarContraseña){
                textViewMensaje.setTextColor(getResources().getColor(R.color.verde));
                textViewMensaje.setText("Usuario y contraseña correctos \n Almacenados para siguientes accesos");

            }else if(correo.equals("correo@correo.com") && contraseña.equals("123")){
                textViewMensaje.setTextColor(getResources().getColor(R.color.verde));
                textViewMensaje.setText("Usuario y contraseña correctos");
            }else{
                textViewMensaje.setTextColor(getResources().getColor(R.color.rojo));
                textViewMensaje.setText("Usuario y/o contraseña incorrectos");
            }
        } );
    }
}