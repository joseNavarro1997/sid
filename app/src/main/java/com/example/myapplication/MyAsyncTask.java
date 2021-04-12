package com.example.myapplication;
import org.json.*;
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
import java.util.Arrays;
import java.util.List;

public class MyAsyncTask extends AsyncTask<String, Void, String>
{
    private MainActivity mActivity = null;
    public MyAsyncTask(MainActivity activity)
    {
        attach(activity);
    }
    HttpURLConnection urlConnection;    //conexion. Referencia: https://stackoverflow.com/questions/29465996/how-to-get-json-object-using-httpurlconnection-instead-of-volley

    List<imagenFlickr> listaImagenes;

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

        if(params[1] != null){
            Log.i("MyAsyncTask -> parametro 1", params[1]); //DEBUG
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
            //System.out.println(result.toString());
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
        listaImagenes = new ArrayList<imagenFlickr>();
        for (int i=0; i< datos.length(); i++){
            String subString = datos.substring(datos.indexOf("{"), datos.indexOf("}")+1);
            try{
                JSONObject array = new JSONObject(subString);
                imagenFlickr imagen = new imagenFlickr(array.getString("id"),array.getString("owner"),
                        array.getString("secret"), array.getString("server"),
                        array.getString("farm"), array.getString("ispublic"),
                        array.getString("isfriend"), array.getString("isfamily"), array.getString("title"), array.getString("tags"));
                listaImagenes.add(imagen);
                System.out.println(imagen.toString());
            }catch (JSONException e){
                e.printStackTrace();
            }
            datos = datos.substring(datos.indexOf("}")+1);
            //System.out.println(subString);

        }

    }
/*
    public List<imagenFlickr> readJsonStream(String in) throws IOException {
        // Nueva instancia JsonReader
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            // Leer Array
            return leerArrayImagenes(reader);
        } finally {
            reader.close();
        }

    }

    public List<imagenFlickr> leerArrayImagenes(JsonReader reader) throws IOException {
        // Lista temporal

        List<imagenFlickr> imagenes = new ArrayList();
        reader.beginObject();
        Log.i("MyAsyncTask -> imagen! ", "empezado");

        while (reader.hasNext()) {
            // Leer objeto
            imagenes.add(leerImagen(reader));

        }
        System.out.println(imagenes);
        reader.endObject();
        return imagenes;
    }

    public imagenFlickr leerImagen(JsonReader reader) throws IOException {
        String id = null;   //id de la imagen
        String owner = null;   //owner
        String secret = null;   //secret
        String server = null;   //server
        String farm = null;   //title
        String ispublic = null; //isPublic
        String isfriend = null; //isfriend
        String isfamily = null; //isfamily
        // List<String> hastags = null;    //lista de hashtags
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            Log.i("MyAsyncTask -> imagen! ", name);
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
                    ispublic = reader.nextString();
                    break;
                case "isfriend":
                    isfriend = reader.nextString();
                    break;
                case "isfamily":
                    isfamily = reader.nextString();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return new imagenFlickr(id, owner, secret, server, farm, ispublic, isfriend, isfamily);
    }
*/
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
            mActivity.setupAdapter(listaImagenes);
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
