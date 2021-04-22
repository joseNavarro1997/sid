package com.example.myapplication;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//package com.example.fbobillo.testapplication3;

public class MyAsyncTask extends AsyncTask<String, Void, String>
{
    private MainActivity mActivity = null;


    public MyAsyncTask(MainActivity activity)
    {
        attach(activity);
    }


    HttpURLConnection urlConnection;    //conexion. Referencia: https://stackoverflow.com/questions/29465996/how-to-get-json-object-using-httpurlconnection-instead-of-volley

    public List<imagenFlickr> listaImagenes = new ArrayList<imagenFlickr>();
    private ImagenAdapter adapter;



    /**
     * Parte del código extraída de la siguiente web/referencia: https://stackoverflow.com/questions/29465996/how-to-get-json-object-using-httpurlconnection-instead-of-volley
     * @param params
     * @return
     */
    @Override
    protected String doInBackground(String... params)
    {
        Log.i("MyAsyncTask -> en doInBackground()", params[0]); //DEBUG
        //If para debug
        if(params[0] != null){
            Log.i("MyAsyncTask -> parametro 0", params[0]); //DEBUG
        }

        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(params[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            //prueba leer lista de imagenes parseando jason
            //
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

        }catch( Exception e) {
            e.printStackTrace();
        }
        finally {
            urlConnection.disconnect();
        }


        Log.i("MyAsyncTask -> respuesta! ", result.toString());//DEBUG
        List<imagenFlickr> lista = new ArrayList<>();
        try {
            System.out.println(result.toString());
            String output = result.toString().substring(result.toString().indexOf("\"photo\"") );
            //System.out.println(output);
            leerDatosJSON(output);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return result.toString();



    }

    public void leerDatosJSON(String datos) throws JSONException {
        //JSONObject json = new JSONObject(datos);
       // listaImagenes = new ArrayList<imagenFlickr>();

        for (int i=0; i< datos.length(); i++){

            String subString = datos.substring(datos.indexOf("{"), datos.indexOf("}")+1);
            try{
                JSONObject array = new JSONObject(subString);
                imagenFlickr imagen = new imagenFlickr(array.getString("id"),array.getString("owner"),
                        array.getString("secret"), array.getString("server"),
                        array.getString("farm"), array.getString("ispublic"),
                        array.getString("isfriend"), array.getString("isfamily"), array.getString("title"), array.getString("tags"));

                listaImagenes.add(imagen);  //rellenar lista imagenes con nueva imagen parseada

                System.out.println("IMAGEN_FLICKR: " + imagen.toString());

            }catch (JSONException e){
                e.printStackTrace();
            }
            datos = datos.substring(datos.indexOf("}")+1);
            //System.out.println(subString);

        }

       // mActivity.setupAdapter(listaImagenes);


    }

    /**
     *
     * @param param
     */
    @Override
    protected void onPostExecute(String param)
    {
        if (mActivity == null)
            Log.i("MyAsyncTask", "Me salto onPostExecute() -- no hay nueva activity");
        else {
            Log.i("MyAsyncTask", "Antes del adapter");


            mActivity.setupAdapter(listaImagenes);
            Log.i("MyAsyncTask", "Despues del adapter");
        }
    }

    void detach()
    {

        this.mActivity = null;
    }


    void attach(MainActivity activity)
    {

        this.mActivity = activity;
    }
}
