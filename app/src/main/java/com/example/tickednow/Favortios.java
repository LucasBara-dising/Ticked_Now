package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Favortios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favortios);

        Button BtnMostraRecomendados = (Button) findViewById(R.id.BtnMostraRecomendados);
        BtnMostraRecomendados.setOnClickListener(new View.OnClickListener() {
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
    }

    public  void TelaMaps(){
        Intent Maps = new Intent(getApplicationContext(), Tela_Maps.class);
        startActivity(Maps);
    }

    public  void TelaPesquisa(){
        Intent Pesquisa = new Intent(getApplicationContext(), Pesquisa_evento.class);
        startActivity(Pesquisa);
    }
}