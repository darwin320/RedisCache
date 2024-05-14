package com.uptc.frm.rediscache.jpa.entity;

import jakarta.persistence.*;

public class InvolvedNews {

    @Id
    @Column(name = "ID_IMPLICADO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "involveNewsGen")
    @SequenceGenerator(name = "involveNewsGen", sequenceName = "IMPLICADO_NOTICIAS_SEQ", allocationSize = 1)
    private int idInterview;

    @Column(name = "ID_NOTICIA")
    private int idNews;

    @Column(name = "CALIDAD")
    private String quality;

    public InvolvedNews() {
    }

    public int getIdInterview() {
        return idInterview;
    }

    public void setIdInterview(int idInterview) {
        this.idInterview = idInterview;
    }

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "InvolvedNews{" +
                "idInterview=" + idInterview +
                ", idNews=" + idNews +
                ", quality='" + quality + '\'' +
                '}';
    }
}
