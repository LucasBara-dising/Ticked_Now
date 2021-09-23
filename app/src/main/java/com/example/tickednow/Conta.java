package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Conta extends AppCompatActivity {

   // private Button infoConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);

        Intent intent = getIntent();
        String nome = (String) intent.getSerializableExtra("NomeLogin");
        String email = (String) intent.getSerializableExtra("EmailLogin");

        TextView txtNome = (TextView) findViewById(R.id.txtViewName);
        txtNome.setText(nome);
        TextView txtEmail = (TextView) findViewById(R.id.txtViewEmail);
        txtEmail.setText(email);


        ImageButton imgBtnVoltaHome4 = (ImageButton) findViewById(R.id.imgBtnVoltaHome4);
        imgBtnVoltaHome4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaHome();
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



    }
    public void TelaHome(){
        Intent home = new Intent(getApplicationContext(), Tela_Home.class);
        startActivity(home);
        finish();
    }
}