package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pesquisa_evento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_evento);

        CardView card_view1 = (CardView) findViewById(R.id.card_view1);
        card_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoEventos();
            }
        });
    }

    public  void InfoEventos(){
        Intent InfoEventos = new Intent(getApplicationContext(), InfoEvento.class);
        startActivity(InfoEventos);
    }
}

