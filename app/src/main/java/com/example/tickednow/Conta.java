package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class Conta extends AppCompatActivity {

   // private Button infoConta;
    private TextView txtNome;
    private TextView txtEmail;
    private final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);

        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

        String nome = (String) preferences.getString("nome", "");
        String email = (String) preferences.getString("email", "");

        txtNome = findViewById(R.id.txtViewName);
        txtNome.setText(nome);
        txtEmail = findViewById(R.id.txtViewEmail);
        txtEmail.setText(email);


        ImageButton imgBtnVoltaHome4 = (ImageButton) findViewById(R.id.imgBtnVoltaHome4);
        imgBtnVoltaHome4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaHome();
            }
        });

        Button btnCupom = (Button) findViewById(R.id.btnCupom);
        btnCupom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaCupom();
            }
        });

       // infoConta = (Button) findViewById(R.id.info_conta);
      //  infoConta.setOnClickListener(new View.OnClickListener() {
        //    @Override
       //     public void onClick(View v) {
        //        Intent goInfo = new Intent(getApplicationContext(), EditarInfoConta.class);
      //          startActivity(goInfo);
        //    }
     //   });



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

    public  void TelaCupom(){
        Intent cupom = new Intent(getApplicationContext(), Cupom.class);
        startActivity(cupom);
    }
}