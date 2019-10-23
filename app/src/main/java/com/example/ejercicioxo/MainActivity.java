package com.example.ejercicioxo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Entidades.Jugadores;

public class MainActivity extends AppCompatActivity {

    public static List<Jugadores> lstJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstJugadores = new ArrayList<>();
    }

    public void OnClickJugadores(View v){
        Intent in = new Intent(this, JugadoresMain.class);
        startActivity(in);
    }

    public void OnClickJugar(View v){
        Intent in = new Intent(this, ElegirJugador.class);
        startActivity(in);
    }
}
