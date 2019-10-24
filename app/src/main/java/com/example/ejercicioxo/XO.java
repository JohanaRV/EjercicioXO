package com.example.ejercicioxo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import Entidades.Jugadores;
import static com.example.ejercicioxo.MainActivity.lstJugadores;
import static com.example.ejercicioxo.ElegirJugador.keyJugador;
import static com.example.ejercicioxo.ElegirJugador.keyIdJugadorUno;
import static com.example.ejercicioxo.ElegirJugador.keyNomJugadorUno;
import static com.example.ejercicioxo.ElegirJugador.keyGaJugadorUno;
import static com.example.ejercicioxo.ElegirJugador.keyIdJugadorDos;
import static com.example.ejercicioxo.ElegirJugador.keyNomJugadorDos;
import static com.example.ejercicioxo.ElegirJugador.keyGaJugadorDos;
import static com.example.ejercicioxo.ElegirJugador.keyDos;


public class XO extends AppCompatActivity implements View.OnClickListener{

    TextView txv11, txv12, txv13, txv21, txv22, txv23, txv31, txv32, txv33;
    int elegido11, elegido12, elegido13, elegido21, elegido22, elegido23, elegido31, elegido32, elegido33, id1, id2, ga1, ga2, limMax;
    boolean player1, player2, ModoDosJugadores;
    Jugadores jugadores;
    String nombreJugador1, nombreJugador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xo);

        InicializaAndClick();
        getDatos();
    }

    private void InicializaAndClick(){
        txv11 = findViewById(R.id.txv11);
        txv12 = findViewById(R.id.txv12);
        txv13 = findViewById(R.id.txv13);
        txv21 = findViewById(R.id.txv21);
        txv22 = findViewById(R.id.txv22);
        txv23 = findViewById(R.id.txv23);
        txv31 = findViewById(R.id.txv31);
        txv32 = findViewById(R.id.txv32);
        txv33 = findViewById(R.id.txv33);

        txv11.setOnClickListener(this);
        txv12.setOnClickListener(this);
        txv13.setOnClickListener(this);
        txv21.setOnClickListener(this);
        txv22.setOnClickListener(this);
        txv23.setOnClickListener(this);
        txv31.setOnClickListener(this);
        txv32.setOnClickListener(this);
        txv33.setOnClickListener(this);

        elegido11 = 0;
        elegido12 = 0;
        elegido13 = 0;
        elegido21 = 0;
        elegido22 = 0;
        elegido23 = 0;
        elegido31 = 0;
        elegido32 = 0;
        elegido33 = 0;

        player1 = true;
        player2 = false;
    }

    private void getDatos() {
        Bundle or = getIntent().getExtras();
        this.ModoDosJugadores = getIntent().getBooleanExtra(keyDos, false);
        if(!this.ModoDosJugadores){     //Un jugador
            jugadores = (Jugadores) or.getSerializable(keyJugador);

            new AlertDialog.Builder(this).setTitle("¡Información!").setMessage(jugadores.getNombre() + ": X\nMaquina: O")
                    .setPositiveButton(android.R.string.ok, null).show();
        } else{             //Dos jugadores
            this.id1 = getIntent().getIntExtra(keyIdJugadorUno, 0);
            this.nombreJugador1 = getIntent().getStringExtra(keyNomJugadorUno);
            this.ga1 = getIntent().getIntExtra(keyGaJugadorUno, 0);

            this.id2 = getIntent().getIntExtra(keyIdJugadorDos, 0);
            this.nombreJugador2 = getIntent().getStringExtra(keyNomJugadorDos);
            this.ga2 = getIntent().getIntExtra(keyGaJugadorDos, 0);
            new AlertDialog.Builder(this).setTitle("¡Información!").setMessage(this.nombreJugador1 + ": X\n" + this.nombreJugador2 + ": O")
                    .setPositiveButton(android.R.string.ok, null).show();
        }
    }

    @Override
    public void onClick(View view) {
        ProcesarBoton(view.getId());
    }

    public void ProcesarBoton(int opc){
        switch (opc){
            case R.id.txv11: {
                PintarTextView(11);
                VerificarGanador();
                break;
            }
            case R.id.txv12: {
                PintarTextView(12);
                VerificarGanador();
                break;
            }
            case R.id.txv13: {
                PintarTextView(13);
                VerificarGanador();
                break;
            }
            case R.id.txv21: {
                PintarTextView(21);
                VerificarGanador();
                break;
            }
            case R.id.txv22: {
                PintarTextView(22);
                VerificarGanador();
                break;
            }
            case R.id.txv23: {
                PintarTextView(23);
                VerificarGanador();
                break;
            }
            case R.id.txv31: {
                PintarTextView(31);
                VerificarGanador();
                break;
            }
            case R.id.txv32: {
                PintarTextView(32);
                VerificarGanador();
                break;
            }
            case R.id.txv33: {
                PintarTextView(33);
                VerificarGanador();
                break;
            }
        }
    }

    private void PintarTextView(int position){
        if(this.id1 == 0){      //Si es 0 es porque se eligio un jugador
            switch (position){
                case 11:{
                    if(elegido11 == 0){
                        txv11.setText("X");
                        elegido11 = 1;
                        player1 = false;
                        player2 = true;

                        if(elegido11 == 0 || elegido12 == 0 || elegido13 == 0 || elegido21 == 0 || elegido22 == 0 || elegido23 == 0 || elegido31 == 0 || elegido32 == 0 || elegido33 == 0) {
                            TurnoMaquina();
                        }
                    }
                    break;
                }
                case 12:{
                    if(elegido12 == 0){
                        txv12.setText("X");
                        elegido12 = 1;
                        player1 = false;
                        player2 = true;

                        if(elegido11 == 0 || elegido12 == 0 || elegido13 == 0 || elegido21 == 0 || elegido22 == 0 || elegido23 == 0 || elegido31 == 0 || elegido32 == 0 || elegido33 == 0) {
                            TurnoMaquina();
                        }
                    }
                    break;
                }
                case 13:{
                    if(elegido13 == 0){
                        txv13.setText("X");
                        elegido13 = 1;
                        player1 = false;
                        player2 = true;

                        if(elegido11 == 0 || elegido12 == 0 || elegido13 == 0 || elegido21 == 0 || elegido22 == 0 || elegido23 == 0 || elegido31 == 0 || elegido32 == 0 || elegido33 == 0) {
                            TurnoMaquina();
                        }
                    }
                    break;
                }
                case 21:{
                    if(elegido21 == 0){
                        txv21.setText("X");
                        elegido21 = 1;
                        player1 = false;
                        player2 = true;

                        if(elegido11 == 0 || elegido12 == 0 || elegido13 == 0 || elegido21 == 0 || elegido22 == 0 || elegido23 == 0 || elegido31 == 0 || elegido32 == 0 || elegido33 == 0) {
                            TurnoMaquina();
                        }
                    }
                    break;
                }
                case 22:{
                    if(elegido22 == 0){
                        txv22.setText("X");
                        elegido22 = 1;
                        player1 = false;
                        player2 = true;

                        if(elegido11 == 0 || elegido12 == 0 || elegido13 == 0 || elegido21 == 0 || elegido22 == 0 || elegido23 == 0 || elegido31 == 0 || elegido32 == 0 || elegido33 == 0) {
                            TurnoMaquina();
                        }
                    }
                    break;
                }
                case 23:{
                    if(elegido23 == 0){
                        txv23.setText("X");
                        elegido23 = 1;
                        player1 = false;
                        player2 = true;

                        if(elegido11 == 0 || elegido12 == 0 || elegido13 == 0 || elegido21 == 0 || elegido22 == 0 || elegido23 == 0 || elegido31 == 0 || elegido32 == 0 || elegido33 == 0) {
                            TurnoMaquina();
                        }
                    }
                    break;
                }
                case 31:{
                    if(elegido31 == 0){
                        txv31.setText("X");
                        elegido31 = 1;
                        player1 = false;
                        player2 = true;

                        if(elegido11 == 0 || elegido12 == 0 || elegido13 == 0 || elegido21 == 0 || elegido22 == 0 || elegido23 == 0 || elegido31 == 0 || elegido32 == 0 || elegido33 == 0) {
                            TurnoMaquina();
                        }
                    }
                    break;
                }
                case 32:{
                    if(elegido32 == 0){
                        txv32.setText("X");
                        elegido32 = 1;
                        player1 = false;
                        player2 = true;

                        if(elegido11 == 0 || elegido12 == 0 || elegido13 == 0 || elegido21 == 0 || elegido22 == 0 || elegido23 == 0 || elegido31 == 0 || elegido32 == 0 || elegido33 == 0) {
                            TurnoMaquina();
                        }
                    }
                    break;
                }
                case 33:{
                    if(elegido33 == 0){
                        txv33.setText("X");
                        elegido33 = 1;
                        player1 = false;
                        player2 = true;

                        if(elegido11 == 0 || elegido12 == 0 || elegido13 == 0 || elegido21 == 0 || elegido22 == 0 || elegido23 == 0 || elegido31 == 0 || elegido32 == 0 || elegido33 == 0) {
                            TurnoMaquina();
                        }
                    }
                    break;
                }
            }

        } else{     //Para dos jugadores
            switch (position){
                case 11:{
                    if(player1){
                        if(elegido11 == 0){
                            txv11.setText("X");
                            elegido11 = 1;
                            player1 = false;
                            player2 = true;
                        }
                    } else{
                        if(elegido11 == 0){
                            txv11.setText("O");
                            elegido11 = 2;
                            player1 = true;
                            player2 = false;
                        }
                    }
                    break;
                }
                case 12:{
                    if(player1){
                        if(elegido12 == 0){
                            txv12.setText("X");
                            elegido12 = 1;
                            player1 = false;
                            player2 = true;
                        }
                    } else{
                        if(elegido12 == 0){
                            txv12.setText("O");
                            elegido12 = 2;
                            player1 = true;
                            player2 = false;
                        }
                    }
                    break;
                }
                case 13:{
                    if(player1){
                        if(elegido13 == 0){
                            txv13.setText("X");
                            elegido13 = 1;
                            player1 = false;
                            player2 = true;
                        }
                    } else{
                        if(elegido13 == 0){
                            txv13.setText("O");
                            elegido13 = 2;
                            player1 = true;
                            player2 = false;
                        }
                    }
                    break;
                }
                case 21:{
                    if(player1){
                        if(elegido21 == 0){
                            txv21.setText("X");
                            elegido21 = 1;
                            player1 = false;
                            player2 = true;
                        }
                    } else{
                        if(elegido21 == 0){
                            txv21.setText("O");
                            elegido21 = 2;
                            player1 = true;
                            player2 = false;
                        }
                    }
                    break;
                }
                case 22:{
                    if(player1){
                        if(elegido22 == 0){
                            txv22.setText("X");
                            elegido22 = 1;
                            player1 = false;
                            player2 = true;
                        }
                    } else{
                        if(elegido22 == 0){
                            txv22.setText("O");
                            elegido22 = 2;
                            player1 = true;
                            player2 = false;
                        }
                    }
                    break;
                }
                case 23:{
                    if(player1){
                        if(elegido23 == 0){
                            txv23.setText("X");
                            elegido23 = 1;
                            player1 = false;
                            player2 = true;
                        }
                    } else{
                        if(elegido23 == 0){
                            txv23.setText("O");
                            elegido23 = 2;
                            player1 = true;
                            player2 = false;
                        }
                    }
                    break;
                }
                case 31:{
                    if(player1){
                        if(elegido31 == 0){
                            txv31.setText("X");
                            elegido31 = 1;
                            player1 = false;
                            player2 = true;
                        }
                    } else{
                        if(elegido31 == 0){
                            txv31.setText("O");
                            elegido31 = 2;
                            player1 = true;
                            player2 = false;
                        }
                    }
                    break;
                }
                case 32:{
                    if(player1){
                        if(elegido32 == 0){
                            txv32.setText("X");
                            elegido32 = 1;
                            player1 = false;
                            player2 = true;
                        }
                    } else{
                        if(elegido32 == 0){
                            txv32.setText("O");
                            elegido32 = 2;
                            player1 = true;
                            player2 = false;
                        }
                    }
                    break;
                }
                case 33:{
                    if(player1){
                        if(elegido33 == 0){
                            txv33.setText("X");
                            elegido33 = 1;
                            player1 = false;
                            player2 = true;
                        }
                    } else{
                        if(elegido33 == 0){
                            txv33.setText("O");
                            elegido33 = 2;
                            player1 = true;
                            player2 = false;
                        }
                    }
                    break;
                }
            }
        }
    }

    private void VerificarGanador(){
        boolean gano = false;
        if((elegido11 == 1 && elegido12 == 1 && elegido13 == 1) || (elegido11 == 1 && elegido22 == 1 && elegido33 == 1) || (elegido11 == 1 && elegido21 == 1 && elegido31 == 1)){ AlertaGanador(1); gano = true;}
        if((elegido12 == 1 && elegido22 == 1 && elegido32 == 1)){ AlertaGanador(1); gano = true;}
        if((elegido13 == 1 && elegido23 == 1 && elegido33 == 1) || (elegido13 == 1 && elegido22 == 1 && elegido31 == 1)){ AlertaGanador(1); gano = true;}
        if((elegido21 == 1 && elegido22 == 1 && elegido23 == 1)){ AlertaGanador(1); gano = true;}
        if((elegido31 == 1 && elegido32 == 1 && elegido33 == 1)){ AlertaGanador(1); gano = true;}

        if((elegido11 == 2 && elegido12 == 2 && elegido13 == 2) || (elegido11 == 2 && elegido22 == 2 && elegido33 == 2) || (elegido11 == 2 && elegido21 == 2 && elegido31 == 2)){ AlertaGanador(2); gano = true;}
        if((elegido12 == 2 && elegido22 == 2 && elegido32 == 2)){ AlertaGanador(2); gano = true;}
        if((elegido13 == 2 && elegido23 == 2 && elegido33 == 2) || (elegido13 == 2 && elegido22 == 2 && elegido31 == 2)){ AlertaGanador(2); gano = true;}
        if((elegido21 == 2 && elegido22 == 2 && elegido23 == 2)){ AlertaGanador(2); gano = true;}
        if((elegido31 == 2 && elegido32 == 2 && elegido33 == 2)){ AlertaGanador(2); gano = true;}

        if(elegido11 != 0 && elegido12 != 0 && elegido13 != 0 && elegido21 != 0 && elegido22 != 0 && elegido23 != 0 && elegido31 != 0 && elegido32 != 0 && elegido33 != 0 && !gano){
            new AlertDialog.Builder(this).setTitle("¡Información!").setMessage("No hay ningún ganador.\n¿Desea volver a jugar?")
                    .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            txv11.setText("");
                            txv12.setText("");
                            txv13.setText("");
                            txv21.setText("");
                            txv22.setText("");
                            txv23.setText("");
                            txv31.setText("");
                            txv32.setText("");
                            txv33.setText("");

                            elegido11 = 0;
                            elegido12 = 0;
                            elegido13 = 0;
                            elegido21 = 0;
                            elegido22 = 0;
                            elegido23 = 0;
                            elegido31 = 0;
                            elegido32 = 0;
                            elegido33 = 0;

                            player1 = true;
                            player2 = false;
                        }
                    }).show();
        }
    }

    private void AlertaGanador(int ganador){
        if(this.id1 == 0){      //Para un jugador
            if(ganador == 1){       //Gano el jugador
                new AlertDialog.Builder(this).setTitle("¡Felicidades!").setMessage("¡Ha ganado el jugador: " + jugadores.getNombre() + "!")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                boolean add = false;
                                for(int i = 0; i < lstJugadores.size(); i++){
                                    if(!add){
                                        if(jugadores.getId() == lstJugadores.get(i).getId()){
                                            lstJugadores.remove(i);

                                            Jugadores j = new Jugadores();
                                            j.setId(jugadores.getId());
                                            j.setNombre(jugadores.getNombre());
                                            j.setGanadas(jugadores.getGanadas() + 1);

                                            lstJugadores.add(j);
                                            add = true;
                                        }
                                    }
                                }
                                finish();
                            }
                        }).show();
            } else{                 //Gano la máquina
                new AlertDialog.Builder(this).setTitle("¡Felicidades!").setMessage("¡La máquina te ha ganado :v!")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                boolean add = false;
                                for(int i = 0; i < lstJugadores.size(); i++){
                                    if(!add){
                                        if(lstJugadores.get(i).getNombre().equals("Maquina")){
                                            Jugadores j = new Jugadores();
                                            j.setId(lstJugadores.get(i).getId());
                                            j.setNombre(lstJugadores.get(i).getNombre());
                                            j.setGanadas(lstJugadores.get(i).getGanadas() + 1);

                                            lstJugadores.remove(i);
                                            lstJugadores.add(j);
                                            add = true;
                                        }
                                    }
                                }
                                finish();
                            }
                        }).show();
            }
        } else{             //Para dos jugadores
            if(ganador == 1){       //Gano el jugador 1
                new AlertDialog.Builder(this).setTitle("¡Felicidades!").setMessage("¡Ha ganado el jugador: " + this.nombreJugador1 + "!")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                boolean add = false;
                                for(int i = 0; i < lstJugadores.size(); i++){
                                    if(!add){
                                        if(lstJugadores.get(i).getId() == id1){
                                            Jugadores j = new Jugadores();
                                            j.setId(id1);
                                            j.setNombre(nombreJugador1);
                                            j.setGanadas(ga1 + 1);

                                            lstJugadores.remove(i);
                                            lstJugadores.add(j);
                                            add = true;
                                        }
                                    }
                                }
                                finish();
                            }
                        }).show();
            } else{                 //Gano el jugador 2
                new AlertDialog.Builder(this).setTitle("¡Felicidades!").setMessage("¡Ha ganado el jugador: " + this.nombreJugador2 + "!")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                boolean add = false;
                                for(int i = 0; i < lstJugadores.size(); i++){
                                    if(!add){
                                        if(lstJugadores.get(i).getId() == id2){
                                            Jugadores j = new Jugadores();
                                            j.setId(id2);
                                            j.setNombre(nombreJugador2);
                                            j.setGanadas(ga2 + 1);

                                            lstJugadores.remove(i);
                                            lstJugadores.add(j);
                                            add = true;
                                        }
                                    }
                                }
                                finish();
                            }
                        }).show();
            }
        }
    }

    private void TurnoMaquina(){
        int random = (int) ((Math.random() * 9) + 1);
        switch (random){
            case 1:{
                if(elegido11 == 0){
                    txv11.setText("O");
                    elegido11 = 2;
                    player1 = true;
                    player2 = false;
                } else{
                    TurnoMaquina();
                }
                break;
            }
            case 2:{
                if(elegido12 == 0){
                    txv12.setText("O");
                    elegido12 = 2;
                    player1 = true;
                    player2 = false;
                } else{
                    TurnoMaquina();
                }
                break;
            }
            case 3:{
                if(elegido13 == 0){
                    txv13.setText("O");
                    elegido13 = 2;
                    player1 = true;
                    player2 = false;
                } else{
                    TurnoMaquina();
                }
                break;
            }
            case 4:{
                if(elegido21 == 0){
                    txv21.setText("O");
                    elegido21 = 2;
                    player1 = true;
                    player2 = false;
                } else{
                    TurnoMaquina();
                }
                break;
            }
            case 5:{
                if(elegido22 == 0){
                    txv22.setText("O");
                    elegido22 = 2;
                    player1 = true;
                    player2 = false;
                } else{
                    TurnoMaquina();
                }
                break;
            }
            case 6:{
                if(elegido23 == 0){
                    txv23.setText("O");
                    elegido23 = 2;
                    player1 = true;
                    player2 = false;
                } else{
                    TurnoMaquina();
                }
                break;
            }
            case 7:{
                if(elegido31 == 0){
                    txv31.setText("O");
                    elegido31 = 2;
                    player1 = true;
                    player2 = false;
                } else{
                    TurnoMaquina();
                }
                break;
            }
            case 8:{
                if(elegido32 == 0){
                    txv32.setText("O");
                    elegido32 = 2;
                    player1 = true;
                    player2 = false;
                } else{
                    TurnoMaquina();
                }
                break;
            }
            case 9:{
                if(elegido33 == 0){
                    txv33.setText("O");
                    elegido33 = 2;
                    player1 = true;
                    player2 = false;
                } else{
                    TurnoMaquina();
                }
                break;
            }
        }
    }
}
