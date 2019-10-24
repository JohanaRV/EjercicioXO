package com.example.ejercicioxo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ModoJuego extends AppCompatActivity {

    public static String keyUnJugador = "uno";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_juego);
    }

    public void OnClickUnJugador(View v){
        Intent in = new Intent(this, ElegirJugador.class);
        in.putExtra(keyUnJugador, true);
        startActivity(in);
        this.finish();
    }

    public void OnClickDosJugadores(View v){
        Intent in = new Intent(this, ElegirJugador.class);
        in.putExtra(keyUnJugador, false);
        startActivity(in);
        this.finish();
    }
}
