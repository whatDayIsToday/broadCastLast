package com.example.david.broadcast;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ComponentName componentName;
    private PackageManager packageManager;

    //fogadó osztaly peldanyositasa
    private fogado receiver = new fogado();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gomb kattintásfigyelő vezérlő meghívása, majd értesítés küldése.

        findViewById(R.id.bcGomb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void uzenetMutato(){

        // a bemeneti adatok elmentése két segédváltozóba

        String felado = ((EditText) findViewById(R.id.mailCimBox)).getText().toString();
        String targy = ((EditText) findViewById(R.id.targybox)).getText().toString();

        // a fogadó osztályból érkező "Ertesites" lekezelése

        Intent seged = new Intent(fogado.Ertesites);

        // segédváltozók átadása

        seged.putExtra("felado",felado);
        seged.putExtra("targy",targy);

        //Helyi broadcast küldése

        LocalBroadcastManager.getInstance(this).sendBroadcast(seged);



    }

}
