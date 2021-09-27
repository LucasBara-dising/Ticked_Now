package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Conta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);

        ImageButton imgBtnVoltaHome4 = (ImageButton) findViewById(R.id.imgBtnVoltaHome4);
        imgBtnVoltaHome4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaHome();
            }
        });

        //recebe o texto da tela opinao
        TextView txtopinao = (TextView) findViewById(R.id.txtopinao);
        Intent intent = getIntent();
        String mostraAvalicao =intent.getStringExtra("mostraAvalicao");
        txtopinao.setText(mostraAvalicao);
    }

    public  void TelaHome(){
        Intent home = new Intent(getApplicationContext(), Tela_Home.class);
        startActivity(home);
        finish();
    }

    public  void TelaOpinao(View view){
        Intent opinao = new Intent(getApplicationContext(), TelaOpiniao.class);
        startActivity(opinao);
    }



}