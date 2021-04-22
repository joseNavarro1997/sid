
package com.example.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

//package com.example.fbobillo.testapplication3;


public class MainActivity extends AppCompatActivity
{
    //Para GUI

    private ArrayList<String> names;

    //List<imagenFlickr> listaImagenes = new ArrayList<imagenFlickr>();

    private final static String TAG = "Practica 4";
    private MyAsyncTask myTask = null;
    private ImagenAdapter imagenAdapter; // Adaptador personalizado
    private List <imagenFlickr> listaImagenes = new ArrayList<>() ; // Lista de imagenes
    private ListView listview;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Looper // usamos Looper para comportamiento sincrono ?

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate");

        // Para obtener el valor devuelto en onRetainCustomNonConfigurationInstance
        myTask = (MyAsyncTask) getLastCustomNonConfigurationInstance();
        if (myTask == null) {
            // Evita crear una AsyncTask cada vez que, por ejemplo, hay una rotación
            Log.i(TAG, "onCreate: About to create MyAsyncTask");
            // myTask = new MyAsyncTask(this);
            String url_flickr = "https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=8fc8cff47099f5643e1feb9c945f1493&format=json&extras=tags";    //REVISAR: extras=tags ¿necesario para los hashtag que pide el guion?

            new MyAsyncTask(this).execute(url_flickr);

            //String respuesta = new MyAsyncTask().execute();
            //Log.i("La respuesta ha sido:", respuesta);
            Log.i(TAG, "onCreate: DEBUG 1");
        } else
            myTask.attach(this);

        Button button = findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



    /** Permite devolver un objeto y que persista entre cambios de configuración. Lo
     invoca el sistema cuando se va a destruir una actividad y se sabe que se va a
     crear otra nueva inmediatamente. Se llama entre onStop y onDestroy. */
    @Override
    public Object onRetainCustomNonConfigurationInstance()
    {
        // Además de devolver mi tarea, elimino la referencia en mActivity
        myTask.detach();
        // Devuelvo mi tarea, para que no se cree de nuevo cada vez
        return myTask;
    }



    public void setupAdapter(List<imagenFlickr> listaImagenes1)
    {


        listview = (ListView) findViewById(R.id.listView);
        imagenAdapter = new ImagenAdapter(MainActivity.this, R.layout.imagen, listaImagenes1);
        listview.setAdapter(imagenAdapter);


        /*
        //listview = (ListView) findViewById(R.id.exp2);
        imagenAdapter = new ImagenAdapter(MainActivity.this, R.layout.imagen, listaImagenes);
        //listview.setAdapter(imagenAdapter);

         */

    }
}




/*
public class MainActivity extends AppCompatActivity {
    //procedimiento
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
*/

