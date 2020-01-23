package com.example.bottnav;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import java.net.URLEncoder;

public class intenciones_f extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_intenciones, container, false);


        Button btnfoto = (Button) view.findViewById(R.id.foto);
        btnfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });
        Button btnweb = (Button) view.findViewById(R.id.web);
        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://developer.android.com/guide/components/intents-common?hl=es-419"));
                startActivity(intent);
            }
        });
        Button btnllamar = (Button) view.findViewById(R.id.llamar);
        btnllamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:952000243"));
                startActivity(intent);
            }
        });
        Button btnmaps = (Button) view.findViewById(R.id.maps);
        btnmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:-18.013739816,-70.2510593169"));
                startActivity(intent);
            }
        });
        Button btnw = (Button) view.findViewById(R.id.whatsapp);
        btnw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager packageManager = getActivity().getPackageManager();
                Intent i = new Intent(Intent.ACTION_VIEW);
                try {
                    String url = "https://api.whatsapp.com/send?phone=" + "+51952000243" + "&text="
                            + URLEncoder.encode("Buen día, tenia una duda del curso ... ", "UTF-8");
                    i.setPackage("com.whatsapp");
                    i.setData(Uri.parse(url));
                    if (i.resolveActivity(packageManager) != null) {
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(getActivity(), "No tiene Whatsapp porfavor instale la app"
                                , Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Button btnemail= (Button) view.findViewById(R.id.email);
        btnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Duda de Android");
                intent.putExtra(Intent.EXTRA_TEXT, "Buen día Ing. Wilson tengo la siguiente duda...");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"nosliwsys@gmail.com"});
                startActivity(intent);
            }
        });
        Button btnn= (Button) view.findViewById(R.id.navegacion);
        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(true);
                builder.setMessage("Seleccione la aplicación");
                builder.setTitle("Escoja entre Waze o Google Maps");
                builder.setNeutralButton("Google Map", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Uri gmmIntentUri;
                        gmmIntentUri = Uri.parse("google.navigation:q=" + -18.013739816 + "," + -70.2510593169);
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null)
                            startActivity(mapIntent);
                        else
                            Toast.makeText(getActivity(), "Maps no esta instalado", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Waze", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Uri gmmIntentUri;
                        gmmIntentUri = Uri.parse("waze://?ll=" + -18.013739816 + "," + -70.2510593169 + "&navigate=yes");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.waze");
                        if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null)
                            startActivity(mapIntent);
                        else
                            Toast.makeText(getActivity(), "Waze no esta instalado", Toast.LENGTH_LONG).show();
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
        });


        return view;


    }
}