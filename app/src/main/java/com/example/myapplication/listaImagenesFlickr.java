package com.example.myapplication;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase con la información de una lista o conjunto de imágenes de Flickr
 */
public class listaImagenesFlickr {
    private List<imagenFlickr> listaImagenes;

    public listaImagenesFlickr(List<imagenFlickr> listaImagenes) {
        this.listaImagenes = listaImagenes;
    }

    public void concatenarImagen(imagenFlickr imagenFlickr) {
        this.listaImagenes.add(imagenFlickr);
    }

    public List<imagenFlickr> getListaImagenes() {
        return listaImagenes;
    }


}
