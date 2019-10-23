package com.example.ejercicioxo;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import Adaptadores.AdaptadorJugadores;
import Entidades.Jugadores;

import static com.example.ejercicioxo.MainActivity.lstJugadores;

public class ElegirJugador extends AppCompatActivity implements AdapterView.OnItemClickListener, AdaptadorJugadores.ItemClickCallback{

    public static String keyJugador = "kj";
    AdaptadorJugadores adapJugadores;
    RecyclerView rvJugadoresElegir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_jugador);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvJugadoresElegir = findViewById(R.id.rvJugadoresElegir);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvJugadoresElegir.setLayoutManager(layoutManager);

        adapJugadores = new AdaptadorJugadores(lstJugadores);
        adapJugadores.setItemClickCallback(this);
        rvJugadoresElegir.setAdapter(adapJugadores);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                super.onBackPressed();
            }break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onItemClick(View v, int position) {
        switch (v.getId()){
            case R.id.cvJugadores:{
                Intent in = new Intent(this, XO.class);
                Jugadores j = adapJugadores.lstJugadores.get(position);

                Bundle bnE = new Bundle();
                bnE.putSerializable(keyJugador, j);
                in.putExtras(bnE);

                startActivity(in);
                this.finish();
                break;
            }
        }
    }
}
