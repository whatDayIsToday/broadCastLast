package com.example.david.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;



public class fogado extends BroadcastReceiver {

    public static final String Ertesites = "com.example.david.broadcast.Ertesites";

    public fogado(){
        // üres konstruktor
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String segeduzenet = intent.getStringExtra("felado");
        mutasd("Ertesitésed érkezett: " +segeduzenet, context);

    }

    private void mutasd (String felado, Context context){
        Toast.makeText(context,felado, Toast.LENGTH_LONG).show();
      //  Toast.makeText(context,targy,Toast.LENGTH_SHORT).show();

    }
}
