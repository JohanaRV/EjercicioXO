package com.example.ejercicioxo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import Entidades.Jugadores;
import static com.example.ejercicioxo.MainActivity.lstJugadores;
import static com.example.ejercicioxo.ElegirJugador.keyJugador;

public class XO extends AppCompatActivity implements View.OnClickListener{

    TextView txv11, txv12, txv13, txv21, txv22, txv23, txv31, txv32, txv33;
    int elegido11, elegido12, elegido13, elegido21, elegido22, elegido23, elegido31, elegido32, elegido33;
    boolean player1, player2;
    Jugadores jugadores;

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
        jugadores = (Jugadores) or.getSerializable(keyJugador);
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

    private void VerificarGanador(){
        if((elegido11 == 1 && elegido12 == 1 && elegido13 == 1) || (elegido11 == 1 && elegido22 == 1 && elegido33 == 1) || (elegido11 == 1 && elegido21 == 1 && elegido31 == 1)){ AlertaGanador(1);}
        if((elegido12 == 1 && elegido22 == 1 && elegido32 == 1)){ AlertaGanador(1);}
        if((elegido13 == 1 && elegido23 == 1 && elegido33 == 1) || (elegido13 == 1 && elegido22 == 1 && elegido31 == 1)){ AlertaGanador(1);}
        if((elegido21 == 1 && elegido22 == 1 && elegido23 == 1)){ AlertaGanador(1);}
        if((elegido31 == 1 && elegido32 == 1 && elegido33 == 1)){ AlertaGanador(1);}

        if((elegido11 == 2 && elegido12 == 2 && elegido13 == 2) || (elegido11 == 2 && elegido22 == 2 && elegido33 == 2) || (elegido11 == 2 && elegido21 == 2 && elegido31 == 2)){ AlertaGanador(2);}
        if((elegido12 == 2 && elegido22 == 2 && elegido32 == 2)){ AlertaGanador(2);}
        if((elegido13 == 2 && elegido23 == 2 && elegido33 == 2) || (elegido13 == 2 && elegido22 == 2 && elegido31 == 2)){ AlertaGanador(2);}
        if((elegido21 == 2 && elegido22 == 2 && elegido23 == 2)){ AlertaGanador(2);}
        if((elegido31 == 2 && elegido32 == 2 && elegido33 == 2)){ AlertaGanador(2);}
    }

    private void AlertaGanador(int ganador){
        if(ganador == 1){
            new AlertDialog.Builder(this).setTitle("¡Felicidades!").setMessage("¡Ha ganado el jugador: " + jugadores.getNombre() + "!")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).show();
        } else{
            new AlertDialog.Builder(this).setTitle("¡Felicidades!").setMessage("¡Ha ganado el jugador: player2!")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).show();
        }
    }
}
