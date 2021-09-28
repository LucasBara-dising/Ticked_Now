package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    private final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";
    private EditText Loginame;
    private EditText Loginemail;
    private Button Logar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Loginame = findViewById(R.id.BoxNome);
        Loginemail = findViewById(R.id.BoxEmail);

       Logar = findViewById(R.id.btnlogin);

        Logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = preferences.edit();

                String nome = Loginame.getText().toString();
                editor.putString("nome", nome);
                String email = Loginemail.getText().toString();
                editor.putString("email", email);

                editor.commit();
                Toast.makeText(getBaseContext(), "Login cadastrado com sucesso", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Login.this,Conta.class);
                intent.putExtra("NomeLogin", Loginame.getText().toString());
                intent.putExtra("EmailLogin", Loginemail.getText().toString());
                startActivity(intent);

            }
        });
    }
}

