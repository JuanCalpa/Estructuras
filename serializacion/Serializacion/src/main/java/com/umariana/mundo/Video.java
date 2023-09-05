
package com.umariana.mundo;

/**
 *
 * @author Isabella
 */
public class Video {
    
    //Declaracion de atributos 
    private int idVideo;
    private String titulo;
    private String autor;
    private String anio;
    private String categoria;
    private String letra;
    private String url;

        //constructor vacio
    public Video() {
    }
    //constructor lleno para inicializar las variables donde se van a guardar  
    public Video(int idVideo, String titulo, String autor, String anio, String categoria, String letra, String url) {
        this.idVideo = idVideo;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.categoria = categoria;
        this.letra = letra;
        this.url = url;
    }
    //getters y setters
    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
   
    
}
