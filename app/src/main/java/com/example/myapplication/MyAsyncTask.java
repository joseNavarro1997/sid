package com.example.myapplication;

//package com.example.fbobillo.testapplication3;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MyAsyncTask extends AsyncTask<String, Void, String>
{
    private MainActivity mActivity = null;
    public MyAsyncTask(MainActivity activity)
    {
        attach(activity);
    }
    HttpURLConnection urlConnection;    //conexion. Referencia: https://stackoverflow.com/questions/29465996/how-to-get-json-object-using-httpurlconnection-instead-of-volley


    //Constructor
    public MyAsyncTask() {

    }

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
            List<imagenFlickr> Lista = readJsonStream(in);
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

        Log.i("MyAsyncTask -> respuesta! ", result.toString()); //DEBUG

        return result.toString();

        /* V2

        HttpURLConnection connection;

        Log.i("MyAsyncTask","doInBackground().DEBUG_0");

       // try {
        try {
            connection = (HttpURLConnection) new URL(params[0]).openConnection();
            String info = connection.getRequestMethod();
            Log.i("MyAsyncTask", info);
            connection.disconnect();


        } catch (IOException e) {
            e.printStackTrace();
        }
        */


        //   return connection.getResponseCode();



                /* V1
                InputStream in = new BufferedInputStream(connection.getInputStream());

                String recibido = in.toString();

                 */


           // } finally {
           //      connection.disconnect();

        //}
/*
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
       // return -1;

    }

    public List<imagenFlickr> readJsonStream(InputStream in) throws IOException {
        // Nueva instancia JsonReader
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            // Leer Array
            return leerArrayImagenes(reader);
        } finally {
            reader.close();
        }

    }

    public List leerArrayImagenes(JsonReader reader) throws IOException {
        // Lista temporal
        ArrayList imagenes = new ArrayList();

        reader.beginArray();
        while (reader.hasNext()) {
            // Leer objeto
            imagenes.add(leerImagen(reader));
        }
        reader.endArray();
        return imagenes;
    }

    public imagenFlickr leerImagen(JsonReader reader) throws IOException {
        String id = null;   //id de la imagen
        String owner = null;   //owner
        String secret = null;   //secret
        String server = null;   //server
        String farm = null;   //title
        Boolean ispublic = null; //isPublic
        Boolean isfriend = null; //isfriend
        Boolean isfamily = null; //isfamily
        // List<String> hastags = null;    //lista de hashtags
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "id":
                    id = reader.nextString();
                    break;
                case "owner":
                    owner = reader.nextString();
                    break;
                case "secret":
                    secret = reader.nextString();
                    break;
                case "server":
                    server = reader.nextString();
                    break;
                case "farm":
                    farm = reader.nextString();
                    break;
                case "ispublic":
                    ispublic = Boolean.valueOf(reader.nextString());
                    break;
                case "isfriend":
                    isfriend = Boolean.valueOf(reader.nextString());
                    break;
                case "isfamily":
                    isfamily = Boolean.valueOf(reader.nextString());
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return new imagenFlickr(id, owner, secret, server, farm, ispublic, isfriend, isfamily);
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
        else{}
            //mActivity.setupAdapter(integer);
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
