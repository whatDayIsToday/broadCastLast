package com.example.david.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class fogado extends BroadcastReceiver {

    public static final String Ertesites = "com.example.david.broadcast.Ertesites";

    @Override
    public void onReceive(Context context, Intent intent) {
            String segeduzenet = intent.getStringExtra("felado");
            String leveltargy = intent.getStringExtra("targy");

            mutasd("E-mailed érkezett:" + segeduzenet +"-től", context);
            mutasd2("levél tárgya: " + leveltargy,context);

    }

    private void mutasd (String segeduzenet, Context context){
        Toast.makeText(context,segeduzenet, Toast.LENGTH_LONG).show();
    }

    private void mutasd2(String leveltargy, Context context) {
        Toast.makeText(context, leveltargy, Toast.LENGTH_SHORT).show();
    }
}
