package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;


public class InfoEvento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_evento);

        Button btnComprarIngresso = (Button) findViewById(R.id.btnComprarIngresso);
        btnComprarIngresso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComprarIngresso();
            }
        });

        ImageButton btnVoltaPesquisa = (ImageButton) findViewById(R.id.btnVoltaPesquisa);
        btnVoltaPesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaPesquisa();
                finish();
            }
        });

        //abir maps ao clicar no nome do teatro
        TextView TXTlocalEvento=(TextView)findViewById(R.id.TXTlocalEvento);
        TXTlocalEvento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                String LocalEvento = getResources().getString(R.string.TxtLocal);
                Uri location= Uri.parse("geo:0,0?q="+LocalEvento);
                Intent maps = new Intent(Intent.ACTION_VIEW,location);
                startActivity(maps);
            }
        });
    }

    public  void ComprarIngresso(){
        Intent escolhaIngresso = new Intent(getApplicationContext(), EscolhaIngresso.class);
        startActivity(escolhaIngresso);
    }

    public  void TelaPesquisa(){
        Intent TelaPesquisa = new Intent(getApplicationContext(), Pesquisa_evento.class);
        startActivity(TelaPesquisa);
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        CheckBox checkboxInfoFav = (CheckBox) findViewById(R.id.checkboxInfoFav);

        switch(view.getId()) {
            case R.id.checkboxInfoFav:
                if (checked){
                    checkboxInfoFav.setBackgroundResource(R.drawable.favorito_preenchido);
                }
            else
                    checkboxInfoFav.setBackgroundResource(R.drawable.favorito);
                break;
        }
    }
}

