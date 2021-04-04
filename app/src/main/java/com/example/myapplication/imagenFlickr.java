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
    Boolean ispublic = null; //isPublic
    Boolean isfriend = null; //isfriend
    Boolean isfamily = null; //isfamily

    public imagenFlickr(String id, String owner, String secret, String server, String farm, Boolean ispublic, Boolean isfriend, Boolean isfamily) {
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

    public Boolean getIspublic() {
        return ispublic;
    }

    public void setIspublic(Boolean ispublic) {
        this.ispublic = ispublic;
    }

    public Boolean getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(Boolean isfriend) {
        this.isfriend = isfriend;
    }

    public Boolean getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(Boolean isfamily) {
        this.isfamily = isfamily;
    }
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
