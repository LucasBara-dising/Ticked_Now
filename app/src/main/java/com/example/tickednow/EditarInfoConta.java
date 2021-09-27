package com.example.tickednow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.BufferUnderflowException;


public class EditarInfoConta extends AppCompatActivity{

  //  public static final String NOME_EDITAR = "nome";
  //  public static final String EMAIL_EDITAR = "email";

   // @Override
 //   protected void onCreate(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_editar_info_conta);

       // final EditText Edtname = (EditText) findViewById(R.id.editTextName);
      //  final EditText Edtemail = (EditText) findViewById(R.id.editTextEmail);

       // Button salvar = (Button) findViewById(R.id.buttonSalvar);

      //  salvar.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View view) {
       //         SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        //        SharedPreferences.Editor ed = prefs.edit();
//
        //        ed.putString(NOME_EDITAR, Edtname.getText().toString());
          //      ed.putString(EMAIL_EDITAR, Edtemail.getText().toString());
//
  //              ed.apply();
    //            Toast.makeText(getBaseContext(), "Salvo com sucesso", Toast.LENGTH_SHORT).show();
//
  //              Intent intent = new Intent(EditarInfoConta.this,Conta.class);
    //            intent.putExtra("NomeParametro", Edtname.getText().toString());
      //          intent.putExtra("EmailParametro", Edtemail.getText().toString());
        //        startActivity(intent);
//
  //          }
    //    });

}



    //public boolean Leitura(){
    //    File file = getFileStreamPath(EDITAR_USUARIO);
    //    FileInputStream fis = new FileInputStream(file);
    //    ObjectInputStream ois = new ObjectInputStream(fis);
    //    Contato retorno = (Contato) ois.readObject();
     //   ois.close();
    //    fis.close();

    //}
    //public boolean Gravacao()
   // {
    //    try {
   //         ArrayList<Contato> contato = new ArrayList<>();
    //        File file = getFileStreamPath(EDITAR_USUARIO);
    //        FileOutputStream fos = new FileOutputStream(file);
    //        ObjectOutputStream oos = new ObjectOutputStream(fos);
    //        oos.writeObject(contato);
    //        oos.close();
   //         fos.close();
    //        return  true;
    //    } catch (IOException e) {
   //         e.printStackTrace();
   //         return false;
    //    }


