package com.example.practica_7_reproductor;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private ImageButton botonPlay;
    private ImageButton botonPausa;
    private TextView textViewCancion;
    private SeekBar seekBar;
    private TextView textViewTiempoActual;
    private TextView textViewTiempoTotal;

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
        mediaPlayer = MediaPlayer.create(this, R.raw.punch_deck_zen_garden);
        botonPlay = findViewById(R.id.botonPlay);
        botonPausa = findViewById(R.id.botonPausa);
        textViewCancion = findViewById(R.id.textViewCancion);
        seekBar = findViewById(R.id.seekBar);
        textViewTiempoActual = findViewById(R.id.textViewTiempoActual);
        textViewTiempoTotal = findViewById(R.id.textViewTiempoTotal);

        textViewCancion.setText("Punch Deck - Zen Garden II: Apocalypse");

        textViewCancion.setSelected(true);
        botonPlay.setOnClickListener(v -> mediaPlayer.start());
        botonPausa.setOnClickListener(v -> mediaPlayer.pause());
        mediaPlayer.setOnPreparedListener(mp -> {
            seekBar.setMax(mp.getDuration());
            textViewTiempoActual.setText("00:00");
            int minutos = mp.getDuration() / 1000 / 60;
            int segundos = mp.getDuration() / 1000 % 60;
            textViewTiempoTotal.setText(String.format("%02d:%02d", minutos, segundos));


        });
        Handler handler = new Handler();
        Runnable actualizarSeekBar = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());

                int minutos = mediaPlayer.getCurrentPosition() / 1000 / 60;
                int segundos = mediaPlayer.getCurrentPosition() / 1000 % 60;
                String tiempo = String.format("%02d:%02d", minutos, segundos);
                textViewTiempoActual.setText(tiempo);

                handler.postDelayed(this, 500);

            }
    };
        handler.post(actualizarSeekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override public void onStopTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }

                }

            });


        }
    }