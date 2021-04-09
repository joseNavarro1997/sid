package com.example.myapplication;

import java.util.List;

/*
    Clase con la información a extraer de flickr

 */
public class imagenFlickr {

    //datos privados de la clase
    //private URL url = null; //url de la imagen
    //private String id = null;   //id de la imagen
    //private String url_imagen = null;   //quizás se puede cambiar por un data tipo Serializable o algo así que directamente almacene la imagen (creo que en binario)
    //private String titulo = null;   //titulo imagen
    //private List<String> hastags = null;    //lista de hashtags

    private String id = null;   //id de la imagen
    private String owner = null;   //owner
    private String secret = null;   //secret
    private String server = null;   //server
    private String farm = null;   //title
    private String ispublic = null; //isPublic
    private String isfriend = null; //isfriend
    private String isfamily = null; //isfamily


    private String title = null;   //titulo imagen
    private List<String> hastags = null;    //lista de hashtags

    String url_imagen = null; // atributo derivado formado por id, server, secret y tamaño de la foto (size-suffix, que usaremos el "s" que es un cuadrado de 75px), etc. Referencia: https://www.flickr.com/services/api/misc.urls.html


    public imagenFlickr(String id, String owner, String secret, String server, String farm, String ispublic, String isfriend, String isfamily, String title) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.ispublic = ispublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;

        this.title = title; //titulo imagen

        //Formar URL de la imagen de Flickr
        String aux = "https://live.staticflickr.com/";
        aux = aux.concat(server);
        aux = aux.concat("/");
        aux = aux.concat(id);
        aux = aux.concat("_");
        aux = aux.concat(secret);
        aux = aux.concat("_s.jpg");   //para obtener foto cuadradas y de tamaño de 75px

        this.url_imagen = aux;
    }

    /*
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

     */

    //getters y setters con sintaxis que nos devuelve la llamada
    public String getOwner() {
        return owner;
    }

    public String getSecret() {
        return secret;
    }

    public String getServer() {
        return server;
    }

    public String getFarm() {
        return farm;
    }

    public String getIspublic() {
        return ispublic;
    }

    public void setIspublic(String ispublic) {
        this.ispublic = ispublic;
    }

    public String getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(String isfriend) {
        this.isfriend = isfriend;
    }

    public String getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(String isfamily) {
        this.isfamily = isfamily;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setUrl_imagen( String server, String id, String secret){
        //Formar URL de la imagen de Flickr
        String aux = "https://live.staticflickr.com/";
        aux = aux.concat(server);
        aux = aux.concat("/");
        aux = aux.concat(id);
        aux = aux.concat("_");
        aux = aux.concat(secret);
        aux = aux.concat("_s.jpg");   //para obtener foto cuadradas y de tamaño de 75px

        this.url_imagen = aux;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public String toString(){return "id: " + id + ", secret: " + secret + ", server: " + server +
            ", farm: " + farm + ", ispublic: " + ispublic + ", isfriend: " + isfriend +
            ", isfamily: " + isfriend + ", title: " + title + ", url_imagen: " + url_imagen;}
    /*
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
    */

}
