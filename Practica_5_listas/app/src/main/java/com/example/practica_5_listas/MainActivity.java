package com.example.practica_5_listas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        Videojuegos[] videojuegos = new Videojuegos[8];
        videojuegos[0] = new Videojuegos("Cyberpunk 2077", "Acción RPG", "2020", R.drawable.cyberpunk);
        videojuegos[1] = new Videojuegos("Doom The Dark Ages", "FPS", "2025", R.drawable.doom);
        videojuegos[2] = new Videojuegos("The Last Of Us Part II", "Acción", "2020", R.drawable.tlou);
        videojuegos[3] = new Videojuegos("Resident Evil Village", "Survival Horror", "2021", R.drawable.village);
        videojuegos[4] = new Videojuegos("The Witcher 3", "RPG", "2015", R.drawable.witcher);
        videojuegos[5] = new Videojuegos("Mass Effect Legendary Edition", "Acción RPG", "2021", R.drawable.mass);
        videojuegos[6] = new Videojuegos("Metro Exodus", "Acción RPG", "2019", R.drawable.metro);
        videojuegos[7] = new Videojuegos("Wolfenstein: The New Order", "FPS", "2014", R.drawable.wolfenstein);



        Adaptador adaptorVideojuegos = new Adaptador(videojuegos);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adaptorVideojuegos);



    }
}