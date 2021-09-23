package com.example.tickednow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class Tela_Maps extends AppCompatActivity implements OnMapReadyCallback {

    //variaveis
    GoogleMap mGoogleMap;
    SupportMapFragment mapFrag;
    LocationRequest mLocationRequest;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_maps);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);


        //ligacoes de telas
        ImageButton imgBtnFav = (ImageButton) findViewById(R.id.imgBtnFav);
        imgBtnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaFavoritos();
            }
        });

        ImageButton imgBtnIngre = (ImageButton) findViewById(R.id.imgBtnIngre);
        imgBtnIngre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaMeusIngresso();
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

    @Override
    public void onPause() {
        super.onPause();

        //quando o app estiver muito inativo para as atualizacoes
        if (mFusedLocationClient != null) {
            mFusedLocationClient.removeLocationUpdates(mLocationCallback);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(120000);
        mLocationRequest.setFastestInterval(120000);
        //localizacao quase exata
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        //check permissoes
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {

                //Com permissoes concedias
                mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback,
                        Looper.myLooper());
                mGoogleMap.setMyLocationEnabled(true);
            } else {
                //pede para checar permissoes
                checkLocationPermission();
            }
        } //se permissao negada
        else {
            mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
            mGoogleMap.setMyLocationEnabled(true);
        }

        //Marcadores
        LatLng CasaDeShow = new LatLng(-23.56765274015991, -46.69079578979636);
        mGoogleMap.addMarker(new MarkerOptions()
                .position(CasaDeShow)
                .title("Casa de show em sp"));

        LatLng Museu = new LatLng(-23.547436263446908, -46.665136403290916);
        mGoogleMap.addMarker(new MarkerOptions()
                .position(Museu)
                .title("Museu do futbol em sp"));

        LatLng Teatro = new LatLng(-23.55878732382339, -46.662656505137974);
        mGoogleMap.addMarker(new MarkerOptions()
                .position(Teatro)
                .title("teatro em sp"));

        LatLng Exposisao = new LatLng(-23.555826215114326, -46.66195709825712);
        mGoogleMap.addMarker(new MarkerOptions()
                .position(Exposisao)
                .title("Casa de Exposisões em sp"));

    }

    LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            List<Location> locationList = locationResult.getLocations();
            if (locationList.size() > 0) {
                //pega a ultima localizacao
                Location location = locationList.get(locationList.size() - 1);
                mLastLocation = location;
                if (mCurrLocationMarker != null) {
                    mCurrLocationMarker.remove();
                }

                //move a camera pra localizao do usuario
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(latLng.latitude, latLng.longitude)).zoom(11).build();
                mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        }
    };

    //checar a permissão
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                //caso não tenha permissao mostra uma mnessagen pedindo
                new AlertDialog.Builder(this)
                        .setTitle("Permissão de Localização nessesaria")
                        .setMessage("Esta Função nessesita da localização para funcionar")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions(Tela_Maps.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION );
                            }
                        })
                        .create()
                        .show();
            } else {
                //soliita permissao ja consedida
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION );
            }
        }
    }

    //pedi permissoes
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //permissao concedida
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        mFusedLocationClient.requestLocationUpdates(mLocationRequest,mLocationCallback, Looper.myLooper());
                        mGoogleMap.setMyLocationEnabled(true);
                    }

                } else {
                    // se não permitir a permissao o app vai voltar pra home
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                    System.exit(0);
                }
            }
        }
    }

    //telas
    public  void TelaHome(){
        Intent home = new Intent(getApplicationContext(), Tela_Home.class);
        startActivity(home);
        finish();
    }

    public  void TelaFavoritos(){
        Intent Favoritos = new Intent(getApplicationContext(), Favortios.class);
        startActivity(Favoritos);
        finish();
    }

    public  void TelaMeusIngresso(){
        Intent Ingressos = new Intent(getApplicationContext(), Meus_Ingressos.class);
        startActivity(Ingressos);
        finish();
    }
}