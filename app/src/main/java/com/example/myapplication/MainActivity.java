
package com.example.myapplication;


import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//package com.example.fbobillo.testapplication3;


public class MainActivity extends AppCompatActivity
{
    private final static String TAG = "Practica 4";
    private MyAsyncTask myTask = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        // Para obtener el valor devuelto en onRetainCustomNonConfigurationInstance
        myTask = (MyAsyncTask) getLastCustomNonConfigurationInstance();
        if (myTask == null) {
            // Evita crear una AsyncTask cada vez que, por ejemplo, hay una rotación
            Log.i(TAG, "onCreate: About to create MyAsyncTask");
            myTask = new MyAsyncTask(this);
            myTask.execute("http://developer.android.com");

            myTask.doInBackground("http://api.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=1ae9a4b4ce337d4b29b7770f405e558c&format=json");
            Log.i(TAG, "onCreate: DEBUG 1");
        }
        else
            myTask.attach(this);
        Toast.makeText(this, "Hola!", Toast.LENGTH_LONG).show();
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
    public void setupAdapter(Integer integer)
    {
        if (integer != -1)
            Toast.makeText(MainActivity.this,
                    "Codigo de respuesta: " + integer, Toast.LENGTH_LONG).show();
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

