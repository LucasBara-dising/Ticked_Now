package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Tela_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_home);

        ImageView ImgBtnConta = (ImageView) findViewById(R.id.ImgBtnConta);
        ImgBtnConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaConta();
            }
        });

        EditText TxtEdtPesquisa = (EditText) findViewById(R.id.TxtEdtPesquisa);
        TxtEdtPesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaPesquisa();
            }
        });

        ImageButton imgBtnFiltro = (ImageButton) findViewById(R.id.imgBtnFiltro);
        imgBtnFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaPesquisa();
                finish();
            }
        });

        ImageButton ImgPoster = (ImageButton) findViewById(R.id.ImgPoster);
        ImgPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoEventos();
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

        ImageButton imgBtnIngre = (ImageButton) findViewById(R.id.imgBtnIngre);
        imgBtnIngre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaIngresso();
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

    public  void TelaIngresso(){
        Intent Ingresso = new Intent(getApplicationContext(), Meus_Ingressos.class);
        startActivity(Ingresso);
        finish();
    }

    public  void TelaFavorito(){
        Intent Fav = new Intent(getApplicationContext(), Favortios.class);
        startActivity(Fav);
    }

    public  void TelaConta(){
        Intent Conta = new Intent(getApplicationContext(), Conta.class);
        startActivity(Conta);
    }

    public  void TelaPesquisa(){
        Intent TelaPesquisa = new Intent(getApplicationContext(), Pesquisa_evento.class);
        startActivity(TelaPesquisa);
    }

    public  void InfoEventos(){
        Intent InfoEventos = new Intent(getApplicationContext(), InfoEvento.class);
        startActivity(InfoEventos);
    }

}