package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    public static final String NOME_LOGIN = "nome_login";
    public static final String EMAIL_LOGIN = "email_login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText Loginame = (EditText) findViewById(R.id.BoxNome);
        final EditText Loginemail = (EditText) findViewById(R.id.BoxEmail);

        Button Logar = (Button) findViewById(R.id.btnlogin);

        Logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefsLog = getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);
                SharedPreferences.Editor edLog = prefsLog.edit();

                edLog.putString(NOME_LOGIN, Loginame.getText().toString());
                edLog.putString(EMAIL_LOGIN, Loginemail.getText().toString());

                edLog.apply();
                Toast.makeText(getBaseContext(), "Login cadastrado com sucesso", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Login.this,Conta.class);
                intent.putExtra("NomeLogin", Loginame.getText().toString());
                intent.putExtra("EmailLogin", Loginemail.getText().toString());
                startActivity(intent);

            }
        });
    }
}

