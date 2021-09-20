package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Meus_Ingressos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_ingressos);

        Button BtnProcuraEventos = (Button) findViewById(R.id.BtnProcuraEventos);
        BtnProcuraEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaPesquisa();
            }
        });


        //barra de baixo
        ImageButton imgBtnLoc = (ImageButton) findViewById(R.id.imgBtnLoc);
        imgBtnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaMaps();
            }
        });

        ImageButton imgBtnFav = (ImageButton) findViewById(R.id.imgBtnFav);
        imgBtnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaFavorito();
            }
        });
    }

    public  void TelaMaps(){
        Intent Maps = new Intent(getApplicationContext(), Tela_Maps.class);
        startActivity(Maps);
        finish();
    }

    public  void TelaFavorito(){
        Intent Fav = new Intent(getApplicationContext(), Favortios.class);
        startActivity(Fav);
    }

    public  void TelaPesquisa(){
        Intent Pesquisa = new Intent(getApplicationContext(), Pesquisa_evento.class);
        startActivity(Pesquisa);
    }
}