package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class VisorDeImagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_de_imagen);

        ImageView img = (ImageView) findViewById(R.id.imageView2);
        TextView textView = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null) {
            Picasso.get().load(b.getString("IMG")).into(img);
            textView.setText("Título: " + b.getString("TIT") + "\nHashtags: " + b.getString("TAGS") + "\n");
        }
    }
}