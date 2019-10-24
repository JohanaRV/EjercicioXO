package com.example.ejercicioxo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import Adaptadores.AdaptadorJugadores;
import Entidades.Jugadores;

import static com.example.ejercicioxo.ModoJuego.keyUnJugador;
import static com.example.ejercicioxo.MainActivity.lstJugadores;

public class ElegirJugador extends AppCompatActivity implements AdapterView.OnItemClickListener, AdaptadorJugadores.ItemClickCallback{

    public static String keyJugador = "kj";
    public static String keyIdJugadorUno = "id1";
    public static String keyNomJugadorUno = "nom1";
    public static String keyGaJugadorUno = "ga1";
    public static String keyIdJugadorDos = "id2";
    public static String keyNomJugadorDos = "nom2";
    public static String keyGaJugadorDos = "ga2";
    public static String keyDos = "dos2";
    boolean modo;
    int cantJugadores, id1, id2;
    AdaptadorJugadores adapJugadores;
    RecyclerView rvJugadoresElegir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_jugador);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GetModo();

        rvJugadoresElegir = findViewById(R.id.rvJugadoresElegir);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvJugadoresElegir.setLayoutManager(layoutManager);

        adapJugadores = new AdaptadorJugadores(lstJugadores);
        adapJugadores.setItemClickCallback(this);
        rvJugadoresElegir.setAdapter(adapJugadores);
    }

    private void GetModo(){
        this.modo = getIntent().getBooleanExtra(keyUnJugador, false);
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
                if(this.modo){      //Si es true, es porque será un solo jugador
                    Intent in = new Intent(this, XO.class);
                    Jugadores j = adapJugadores.lstJugadores.get(position);

                    Bundle bnE = new Bundle();
                    bnE.putSerializable(keyJugador, j);
                    in.putExtras(bnE);

                    startActivity(in);
                    this.finish();
                } else{             //Sino, eligio dos jugadores
                    if(this.cantJugadores < 2){
                        if(this.cantJugadores == 0){
                            id1 = position;

                            new AlertDialog.Builder(this).setTitle("¡Información!").setMessage("Seleccione el segundo jugador")
                                    .setPositiveButton(android.R.string.ok, null).show();
                        } else{
                            Intent in = new Intent(this, XO.class);

                            in.putExtra(keyDos, true);
                            in.putExtra(keyIdJugadorUno, adapJugadores.lstJugadores.get(id1).getId());
                            in.putExtra(keyNomJugadorUno, adapJugadores.lstJugadores.get(id1).getNombre());
                            in.putExtra(keyGaJugadorUno, adapJugadores.lstJugadores.get(id1).getGanadas());

                            in.putExtra(keyIdJugadorDos, adapJugadores.lstJugadores.get(position).getId());
                            in.putExtra(keyNomJugadorDos, adapJugadores.lstJugadores.get(position).getNombre());
                            in.putExtra(keyGaJugadorDos, adapJugadores.lstJugadores.get(position).getGanadas());

                            startActivity(in);
                            this.finish();
                        }
                        this.cantJugadores++;
                    }
                }
                break;
            }
        }
    }
}
