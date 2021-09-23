package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class EscolhaIngresso extends AppCompatActivity {


    int IngressoInt=0;
    int IngressoMeia=0;
    int IngressoIdoso=0;

    //valores
    double precoInteira=72.00;
    double precoMeia=37.00;
    double precoidoso=37.00;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_ingresso);


        ImageButton imgBtnVoltaHome= (ImageButton) findViewById(R.id.imgBtnVoltaHome);
        imgBtnVoltaHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {InfoEventos(); }
        });


        //======================Ingresso interia====================
        ImageButton btnMaisPass= (ImageButton) findViewById(R.id.btnMaisPass);
        btnMaisPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngressoInt++;

                String QtnIngressoInteita=Integer.toString(IngressoInt);

                TextView numPassInteira= (TextView) findViewById(R.id.numPassInteira);
                numPassInteira.setText(QtnIngressoInteita);

                Total();
            }
        });


        ImageButton btnMenosPass= (ImageButton) findViewById(R.id.btnMenosPass);
        btnMenosPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngressoInt=IngressoInt-1;

                if(IngressoInt <0){
                    IngressoInt=0;
                }

                String QtnIngressoInteita=Integer.toString(IngressoInt);

                TextView numPassInteira= (TextView) findViewById(R.id.numPassInteira);
                numPassInteira.setText(QtnIngressoInteita);

                Total();
            }
        });

        //==============================Ingresso meia==============================
        ImageButton btnMaisPassMeia= (ImageButton) findViewById(R.id.btnMaisPassMeia);
        btnMaisPassMeia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngressoMeia++;

                String QtnIngressoMeia=Integer.toString(IngressoMeia);

                TextView numPassInteira= (TextView) findViewById(R.id.numPassMeia);
                numPassInteira.setText(QtnIngressoMeia);

                Total();
            }
        });

        ImageButton btnMenosPassMeia= (ImageButton) findViewById(R.id.btnMenosPassMeia);
        btnMenosPassMeia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngressoMeia=IngressoMeia-1;

                if(IngressoMeia <0){
                    IngressoMeia=0;
                }

                String QtnIngressoMeia=Integer.toString(IngressoMeia);

                TextView numPassInteira= (TextView) findViewById(R.id.numPassMeia);
                numPassInteira.setText(QtnIngressoMeia);

                Total();
            }
        });

        //===========================Ingresso idoso===========================
        ImageButton btnMaisPassIdoso= (ImageButton) findViewById(R.id.btnMaisPassIdoso);
        btnMaisPassIdoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngressoIdoso++;

                String QtnIngressoMeia=Integer.toString(IngressoIdoso);

                TextView numPassInteira= (TextView) findViewById(R.id.numPassIdoso);
                numPassInteira.setText(QtnIngressoMeia);

                Total();
            }
        });

        ImageButton btnMenosPassIdoso= (ImageButton) findViewById(R.id.btnMenosPassIdoso);
        btnMenosPassIdoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngressoIdoso=IngressoIdoso-1;

                if(IngressoIdoso <0){
                    IngressoIdoso=0;
                }

                String QtnIngressoMeia=Integer.toString(IngressoIdoso);

                TextView numPassInteira= (TextView) findViewById(R.id.numPassIdoso);
                numPassInteira.setText(QtnIngressoMeia);

                Total();
            }
        });
    }

    public void Total(){
        double totalVl=(IngressoInt*precoInteira)+(IngressoMeia*precoMeia)+(IngressoIdoso*precoidoso);
        if(totalVl<0){
            totalVl=0;
        }
        String total=Double.toString(totalVl);
        TextView textviewTotal= (TextView) findViewById(R.id.textviewTotal);
        textviewTotal.setText("R$" + total);
    }

    public  void InfoEventos(){
        Intent InfoEventos = new Intent(getApplicationContext(), InfoEvento.class);
        startActivity(InfoEventos);
    }

}