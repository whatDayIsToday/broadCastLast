package com.example.david.broadcast;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Mailcimbox valtozo deklarálása
   //INAKTIV
    //
/*
    EditText mailCimBox;
    EditText targybox;
    Button bcGomb;
*/


    //fogadó osztaly peldanyositasa
    private fogado receiver = new fogado();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mailcimbox megszorítás @-ra.
    /*
        mailCimBox = findViewById(R.id.mailCimBox);
        targybox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                adatellenorzo();
            }
        });
        */



        // Gomb kattintásfigyelő vezérlő meghívása, majd értesítés küldése.

        findViewById(R.id.bcGomb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uzenetMutato();
            }
        });
        //Helyi broadcast küldése

        LocalBroadcastManager.getInstance(this).registerReceiver(receiver,new IntentFilter(fogado.Ertesites));

    }
/*
    // mailcim ellenorzés, nézi, hogy üres-e a box, illetve hogy stimmel-e az e-mail formatummal.
    boolean emailcim (EditText text){
        CharSequence mailCimBox = text.getText().toString();
        return (!TextUtils.isEmpty(mailCimBox) && Patterns.EMAIL_ADDRESS.matcher(mailCimBox).matches());
    }
    // ellenorizzuk, hogy irt-e be a felhasználó egyáltalán valamit
    boolean nemuresacimveletlenul(EditText text){
        CharSequence szoveg = text.getText().toString();
        return TextUtils.isEmpty(szoveg);
    }

    void adatellenorzo(){
        if(emailcim(mailCimBox)==false){
            mailCimBox.setError("Nem érvényes a cím");
        }
        if(nemuresacimveletlenul(targybox)){
            targybox.setError("Nem irtál be semmit...");
        }
    }
*/
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
