package com.example.ejercicioxo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.rengwuxian.materialedittext.MaterialEditText;

import Entidades.Jugadores;

import static com.example.ejercicioxo.MainActivity.lstJugadores;
import static com.example.ejercicioxo.JugadoresMain.keyMsg;

public class JugadoresEdicion extends AppCompatActivity {

    MaterialEditText edtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores_edicion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtNombre = findViewById(R.id.edtNombre);
    }

    public void OnClickGuardarJugador(View v){
        String nombre = this.edtNombre.getText().toString();

        if(nombre.length() <= 0){
            Toast.makeText(this, "Digite el nombre del jugador", Toast.LENGTH_SHORT).show();
        } else{
            Intent in = new Intent();
            int id = lstJugadores.size() + 1;
            Jugadores j = new Jugadores();

            j.setId(id);
            j.setNombre(nombre);
            j.setGanadas(0);
            lstJugadores.add(j);
            in.putExtra(keyMsg, "Jugador añadido con éxito... :)");
            setResult(RESULT_OK, in);
            this.finish();
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
}
