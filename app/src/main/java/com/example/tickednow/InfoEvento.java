package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class InfoEvento extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_evento);


        ImageView ImgFavoritar = (ImageView) findViewById(R.id.ImgFavoritar);
        ImgFavoritar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImgFavoritar.setBackgroundResource(R.drawable.favorito_preenchido);
            }
        });

        Button btnComprarIngresso = (Button) findViewById(R.id.btnComprarIngresso);
        btnComprarIngresso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComprarIngresso();
            }
        });

        ImageButton btnVoltaPesquisa = (ImageButton) findViewById(R.id.btnVoltaPesquisa);
        btnVoltaPesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaPesquisa();
                finish();
            }
        });
    }

    public  void ComprarIngresso(){
        Intent escolhaIngresso = new Intent(getApplicationContext(), EscolhaIngresso.class);
        startActivity(escolhaIngresso);
    }

    public  void TelaPesquisa(){
        Intent TelaPesquisa = new Intent(getApplicationContext(), Pesquisa_evento.class);
        startActivity(TelaPesquisa);
    }
}

