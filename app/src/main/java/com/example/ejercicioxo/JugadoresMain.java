package com.example.ejercicioxo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import Adaptadores.AdaptadorJugadores;
import Entidades.Jugadores;

import static com.example.ejercicioxo.MainActivity.lstJugadores;

public class JugadoresMain extends AppCompatActivity implements AdapterView.OnItemClickListener, AdaptadorJugadores.ItemClickCallback{

    public static String keyMsg = "j";
    AdaptadorJugadores adapJugadores;
    FloatingActionButton fab;
    RecyclerView rvJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CreacionDosJugadores();
        rvJugadores = findViewById(R.id.rvJugadores);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvJugadores.setLayoutManager(layoutManager);

        adapJugadores = new AdaptadorJugadores(lstJugadores);
        adapJugadores.setItemClickCallback(this);
        rvJugadores.setAdapter(adapJugadores);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(JugadoresMain.this, JugadoresEdicion.class);
                startActivityForResult(in, 1);
            }
        });
    }

    private void CreacionDosJugadores(){
        if(lstJugadores.isEmpty()){
            Jugadores j1 = new Jugadores();
            j1.setId(1);
            j1.setNombre("Player 1");
            j1.setGanadas(0);

            Jugadores j2 = new Jugadores();
            j2.setId(2);
            j2.setNombre("Player 2");
            j2.setGanadas(0);

            lstJugadores.add(j1);
            lstJugadores.add(j2);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:{
                if(requestCode == RESULT_OK){
                    String msg = data.getStringExtra(keyMsg);
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                }
            } break;
        }
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
        //Evento click
    }
}
