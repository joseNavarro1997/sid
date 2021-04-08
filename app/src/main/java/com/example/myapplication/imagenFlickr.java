package com.example.myapplication;

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

    String id = null;   //id de la imagen
    String owner = null;   //owner
    String secret = null;   //secret
    String server = null;   //server
    String farm = null;   //title
    String ispublic = null; //isPublic
    String isfriend = null; //isfriend
    String isfamily = null; //isfamily

    public imagenFlickr(String id, String owner, String secret, String server, String farm, String ispublic, String isfriend, String isfamily) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.ispublic = ispublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
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

    public String toString(){return "id: " + id + ", secret: " + secret + ", server: " + server +
            ", farm: " + farm + ", ispublic: " + ispublic + ", isfriend: " + isfriend +
            ", isfamily: " + isfriend;}
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
