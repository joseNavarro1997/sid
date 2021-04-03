package com.example.myapplication;

import java.net.URL;
import java.util.List;

/*
    Clase con la información a extraer de flickr

 */
public class imagenFlickr {

    //datos privados de la clase
    private URL url = null; //url de la imagen
    private String id = null;   //id de la imagen
    private String url_imagen = null;   //quizás se puede cambiar por un data tipo Serializable o algo así que directamente almacene la imagen (creo que en binario)
    private String titulo = null;   //titulo imagen
    private List<String> hastags = null;    //lista de hashtags

    //Métodos SET (actualizan el valor del campo correspondiente)
    public void setHastags(List<String> _hastags) {
        this.hastags = _hastags;
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public void setUrl(URL _url){
        this.url = _url;
    }

    public void setTitulo(String _titulo) {
        this.titulo = _titulo;
    }

    public void setUrl_imagen(String _url_imagen) {
        this.url_imagen = _url_imagen;
    }

    //métodos GET (devuelven el valor del campo correspondiente)

    public String getId(){
        return this.id;
    }
    public String getUrl_imagen(){
        return getUrl_imagen();
    }

    public String getTitulo(){
        return titulo;
    }

    public URL getUrl(){
        return url;
    }

    public List<String> getHastags(){
        return hastags;
    }


}
