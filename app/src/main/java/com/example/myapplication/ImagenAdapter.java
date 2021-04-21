package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImagenAdapter extends ArrayAdapter<imagenFlickr> {
    private int newId;
    public ImagenAdapter(Context context, int resourceId, List<imagenFlickr> arr){
        super(context,resourceId,arr);
        newId = resourceId;
    }

    @Override
    public View getView(final int position, View converView, ViewGroup parent){
        imagenFlickr imagenFlickr = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(newId,parent,false);
        TextView text = view.findViewById(R.id.text);
        ImageView image = view.findViewById(R.id.image);
        text.setText(imagenFlickr.getTitle());
        image.setImageResource(Integer.parseInt(imagenFlickr.getUrl_imagen()));
        return view;
    }
}