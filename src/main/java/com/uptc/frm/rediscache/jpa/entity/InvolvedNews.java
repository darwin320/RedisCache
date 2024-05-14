package com.uptc.frm.rediscache.jpa.entity;

import com.uptc.frm.rediscache.jpa.entity.key.InvolvedNewsKey;
import jakarta.persistence.*;
@Entity
@Table(name = "IMPLICADO_NOTICIAS")
@IdClass(InvolvedNewsKey.class)
public class InvolvedNews {

    @Id
    @Column(name = "ID_IMPLICADO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "involveNewsGen")
    @SequenceGenerator(name = "involveNewsGen", sequenceName = "IMPLICADO_NOTICIAS_SEQ", allocationSize = 1)
    private int idInterview;

    @Column(name = "ID_NOTICIA",insertable = false, updatable = false)
    private int idNews;

    @Column(name = "CALIDAD")
    private String quality;

    @ManyToOne
    @JoinColumn(name = "ID_NOTICIA",nullable = false)
    private New _new;

    @ManyToOne
    @JoinColumn(name = "ID_IMPLICADO")
    private Person involvedPerson;

    public New get_new() {
        return _new;
    }

    public void set_new(New _new) {
        this._new = _new;
    }

    public InvolvedNews() {
    }

    public Person getInvolvedPerson() {
        return involvedPerson;
    }

    public void setInvolvedPerson(Person involvedPerson) {
        this.involvedPerson = involvedPerson;
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
