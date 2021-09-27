package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TelaOpiniao extends AppCompatActivity {

    EditText opinaoTXT;
    final String filename = "AvaliacaoApp.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_opiniao);

        opinaoTXT = (EditText) findViewById(R.id.edAvaliacao);
    }

    public void  salvar(View view) {
        try {
            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
            String avaliacao = opinaoTXT.getText().toString();
            //grava na memoria
            fos.write(avaliacao.getBytes());
            //Mensagem de sucesso
            Toast.makeText(TelaOpiniao.this, "Sua opinião foi salva", Toast.LENGTH_SHORT).show();
            fos.close();

            //le os dados gravados
            FileInputStream fis = openFileInput(filename);
            int i = 0;
            String opinaouser = " ";
            //loop para escrever os dados gravados
            while ((i = fis.read()) != -1) {
                opinaouser = opinaouser + (char) i;
            }

            String mostraAvalicao = opinaouser;

            Intent intent = new Intent(this, Conta.class);
            intent.putExtra("mostraAvalicao", mostraAvalicao);
            startActivity(intent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void telaConta(View view){
        Intent Conta = new Intent(getApplicationContext(), Conta.class);
        startActivity(Conta);
    }

}