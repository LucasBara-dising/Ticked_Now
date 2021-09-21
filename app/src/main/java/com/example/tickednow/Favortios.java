package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class Favortios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favortios);


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

        ImageButton imgBtnHome = (ImageButton) findViewById(R.id.imgBtnHome);
        imgBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaHome();
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

    public  void TelaHome(){
        Intent home = new Intent(getApplicationContext(), Tela_Home.class);
        startActivity(home);
        finish();
    }


    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        CheckBox CkboxFav = (CheckBox) findViewById(R.id.CkboxFav);

        switch(view.getId()) {
            case R.id.CkboxFav:
                if (checked){
                    CkboxFav.setBackgroundResource(R.drawable.favorito_preenchido);
                }
                else {
                    CkboxFav.setBackgroundResource(R.drawable.favorito);
                }
            break;
        }

    }
}