package com.yachay.model;

public class Vocabulario {

    private int idVocabulario;
    private String codVocabulario;
    private String vocabulario;
    private String descripcion;
    private String imgSenia;
    private Respuesta respuesta;

    public int getIdVocabulario() {
        return idVocabulario;
    }

    public void setIdVocabulario(int idVocabulario) {
        this.idVocabulario = idVocabulario;
    }

    public String getCodVocabulario() {
        return codVocabulario;
    }

    public void setCodVocabulario(String codVocabulario) {
        this.codVocabulario = codVocabulario;
    }

    public String getVocabulario() {
        return vocabulario;
    }

    public void setVocabulario(String vocabulario) {
        this.vocabulario = vocabulario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImgSenia() {
        return imgSenia;
    }

    public void setImgSenia(String imgSenia) {
        this.imgSenia = imgSenia;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }
}