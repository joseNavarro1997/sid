package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImagenAdapter extends ArrayAdapter<imagenFlickr> {
    private int newId;
    private List<imagenFlickr> mList;
    private Context mContext;
    public ImagenAdapter(@NonNull Context context, int resourceId, List<imagenFlickr> arr){
        super(context,resourceId,arr);
        this.mList = arr;
        this.mContext = context;
        this.newId = resourceId;
    }

    @Override
    public View getView(final int position, View converView, ViewGroup parent){
        View view = converView;
        if (view == null){
            view = LayoutInflater.from(mContext).inflate(newId, null);
        }

        imagenFlickr imagen = mList.get(position);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        Picasso.get().load(imagen.getUrl_imagen()).into(imageView);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText("Título: " + imagen.getTitle() + "\nHashtags: " + imagen.getTags() + "\nUrl: " + imagen.getUrl_imagen() );
//        imageView.setTag(String.valueOf(position));
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent visorImage = new Intent(mContext, VisorDeImagen.class);
//                visorImage.putExtra("IMG", mList.get((Integer) v.getTag()).getUrl_imagen());
//                mContext.startActivity(visorImage);
//            }
 //       });
        return view;
        /*imagenFlickr imagenFlickr = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(newId,parent,false);
        TextView text = view.findViewById(R.id.text);
        ImageView image = view.findViewById(R.id.image);
        text.setText(imagenFlickr.getTitle());
        image.setImageResource(Integer.parseInt(imagenFlickr.getUrl_imagen()));
        return view;*/

    }
}