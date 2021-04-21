
package com.example.myapplication;


import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

//package com.example.fbobillo.testapplication3;


public class MainActivity extends AppCompatActivity
{
    //Para GUI
    private ListView listview;
    private ArrayList<String> names;

    //List<imagenFlickr> listaImagenes = new ArrayList<imagenFlickr>();

    private final static String TAG = "Practica 4";
    private MyAsyncTask myTask = null;
    private ImagenAdapter itemAdapter; // Adaptador personalizado
    private List <imagenFlickr> listaImagenes; // Lista de imagenes





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Looper // usamos Looper para comportamiento sincrono ?

        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);
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
        Toast.makeText(this, "Hola!", Toast.LENGTH_LONG).show();

        listview = findViewById(R.id.listview);
        ImagenAdapter imagenAdapter = new ImagenAdapter(MainActivity.this, R.layout.imagen, listaImagenes);
        listview.setAdapter(imagenAdapter);
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
        listaImagenes= listaImagenes1;
        /*
        System.out.println("listaImagenesFlickr 1: " + listaImagenes);

        ArrayAdapter<imagenFlickr> adapter = new ArrayAdapter<imagenFlickr>(this, android.R.layout.simple_list_item_1, listaImagenes);

        System.out.println("listaImagenesFlickr 2: " + listaImagenes);

        listview = (ListView) findViewById(R.id.listview); //https://naps.com.mx/blog/uso-de-un-listview-en-android/

        listview.setAdapter(adapter);

        System.out.println("DEBUG 3: " + listaImagenes);

       /*
        if (integer != -1)
            Toast.makeText(MainActivity.this,
                    "Codigo de respuesta: " + integer, Toast.LENGTH_LONG).show();

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

