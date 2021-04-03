package com.example.myapplication;

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
