package com.example.myapplication;

//package com.example.fbobillo.testapplication3;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.lang.String.valueOf;

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
