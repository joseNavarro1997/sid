package com.example.myapplication;

//package com.example.fbobillo.testapplication3;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.lang.String.valueOf;

public class MyAsyncTask extends AsyncTask<String, Void, Integer>
{
    private MainActivity mActivity = null;
    public MyAsyncTask(MainActivity activity)
    {
        attach(activity);
    }
    @Override
    protected Integer doInBackground(String... params)
    {
        HttpURLConnection connection;

        Log.i("MyAsyncTask","doInBackground().DEBUG_0");

        try {
            connection = (HttpURLConnection) new URL(params[0]).openConnection();
            return connection.getResponseCode();
            /*
            try {
                InputStream in = new BufferedInputStream(connection.getInputStream());

                String recibido = in.toString();

                Log.i("Recibido","recibido");

            } finally {
                connection.disconnect();
            }
            */
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }



    @Override
    protected void onPostExecute(Integer integer)
    {
        if (mActivity == null)
            Log.i("MyAsyncTask", "Me salto onPostExecute() -- no hay nueva activity");
        else
            mActivity.setupAdapter(integer);
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
