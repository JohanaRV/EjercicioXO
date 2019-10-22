package com.example.ejercicioxo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import Entidades.Jugadores;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickJugadores(View v){
        Intent in = new Intent(this, JugadoresMain.class);
        startActivity(in);
    }

    public void OnClickJugar(View v){

    }
}
