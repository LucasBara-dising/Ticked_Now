package com.example.tickednow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Meus_Ingressos extends AppCompatActivity {

    //giroscopio
    SensorManager sensorManager;
    Sensor sensor;
    TextView txtMenss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_ingressos);

        //instancianod giroscopio
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        txtMenss =findViewById(R.id.TXtMensagIngresso);

        Button BtnProcuraEventos = (Button) findViewById(R.id.BtnProcuraEventos);
        BtnProcuraEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaPesquisa();
            }
        });


        //barra de baixo
        ImageButton imgBtnLoc = (ImageButton) findViewById(R.id.imgBtnLoc);
        imgBtnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaMaps();
            }
        });

        ImageButton imgBtnFav = (ImageButton) findViewById(R.id.imgBtnFav);
        imgBtnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaFavorito();
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

    public  void TelaFavorito(){
        Intent Fav = new Intent(getApplicationContext(), Favortios.class);
        startActivity(Fav);
    }

    public  void TelaPesquisa(){
        Intent Pesquisa = new Intent(getApplicationContext(), Pesquisa_evento.class);
        startActivity(Pesquisa);
    }

    public  void TelaHome(){
        Intent home = new Intent(getApplicationContext(), Tela_Home.class);
        startActivity(home);
        finish();
    }

    public void onResume() {
        super.onResume();
        sensorManager.registerListener(gyroListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onStop() {
        super.onStop();
        sensorManager.unregisterListener(gyroListener);
    }

    public SensorEventListener gyroListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int acc) {
        }

        @SuppressLint("SetTextI18n")
        public void onSensorChanged(SensorEvent event) {
            float y = event.values[1];

            if(y>3){
                txtMenss.setText("Pare de me Banlançar!! vou ficar tonto");
            }

            else if(y<2){
                txtMenss.setText(R.string.TxtIngressoMensagem);
            }

            else if(y>-3){
                txtMenss.setText("Pare de me Banlançar!! vou ficar tonto");
            }
        }
    };

}