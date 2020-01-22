package com.example.bottnav;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.pm.PackageManager;
import android.widget.Toast;

import java.net.URLEncoder;

public class Intenciones  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intenciones);
    }
    public void web(View view) {

    }
    public void Llamar(View view) {

    }
    public void maps(View view) {

    }
    public void foto(View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }
    public void email(View view) {

    }
    public void whatsapp(View view) {
        startActivity(new Intent(this,login_.class));

        PackageManager packageManager = this.getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);
        try {
            String url = "https://api.whatsapp.com/send?phone=" + "+51952000243" + "&text="
                    + URLEncoder.encode("Buen día, tenia una duda del curso ... ", "UTF-8");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
                this.startActivity(i);
            }
            else {
                Toast.makeText(this, "No tiene Whatsapp porfavor instale la app"
                        , Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void navegacion(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage("Seleccione la aplicación");
        builder.setTitle("Escoja entre Waze o Google Maps");
        builder.setNeutralButton("Google Map", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Uri gmmIntentUri;
                gmmIntentUri = Uri.parse("google.navigation:q=" + -18.013739816 + "," + -70.2510593169);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null)
                    startActivity(mapIntent);
                else
                    Toast.makeText(Intenciones.this, "Maps no esta instalado", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Waze", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Uri gmmIntentUri;
                gmmIntentUri = Uri.parse("waze://?ll=" + -18.013739816 + "," + -70.2510593169 + "&navigate=yes");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.waze");
                if (mapIntent.resolveActivity(getPackageManager()) != null)
                    startActivity(mapIntent);
                else
                    Toast.makeText(Intenciones.this, "Waze no esta instalado", Toast.LENGTH_LONG).show();
            }
        });
        builder.setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                return;
            }
        });
        builder.show();
    }
}
