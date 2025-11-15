package com.example.practica_6_multiventana;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitySesion extends AppCompatActivity {
    private Button botonDesconectar;
    private TextView textViewMostrarCorreo;
    private String correo;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sesion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        intent = getIntent();
        correo = intent.getStringExtra("correo");
        textViewMostrarCorreo = findViewById(R.id.textViewMostrarCorreo);
        textViewMostrarCorreo.setText(correo);
        botonDesconectar = findViewById(R.id.botonDesconectar);
        botonDesconectar.setOnClickListener(v -> {
            finish();

        });
    }
}