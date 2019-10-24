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
        CreacionDosJugadores();
    }

    public void OnClickJugadores(View v){
        Intent in = new Intent(this, JugadoresMain.class);
        startActivity(in);
    }

    public void OnClickJugar(View v){
        Intent in = new Intent(this, ModoJuego.class);
        startActivity(in);
    }

    private void CreacionDosJugadores(){
        if(lstJugadores.isEmpty()){
            Jugadores j1 = new Jugadores();
            j1.setId(1);
            j1.setNombre("Player 1");
            j1.setGanadas(0);

            Jugadores j2 = new Jugadores();
            j2.setId(2);
            j2.setNombre("Maquina");
            j2.setGanadas(0);

            lstJugadores.add(j1);
            lstJugadores.add(j2);
        }
    }
}
