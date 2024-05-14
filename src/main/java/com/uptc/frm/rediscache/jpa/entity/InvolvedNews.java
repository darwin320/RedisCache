package com.uptc.frm.rediscache.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uptc.frm.rediscache.jpa.entity.key.InvolvedNewsKey;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "IMPLICADO_NOTICIAS")
@IdClass(InvolvedNewsKey.class)
public class InvolvedNews implements Serializable {

    @Id
    @Column(name = "ID_IMPLICADO")
    private int idInvolved;

    @Id
    @Column(name = "ID_NOTICIA", insertable = false, updatable = false)
    private int idNews;

    @Column(name = "CALIDAD")
    private String quality;

    @ManyToOne
    @JoinColumn(name = "ID_NOTICIA", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private New _new;

    @ManyToOne
    @JoinColumn(name = "ID_IMPLICADO", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
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

    public int getIdInvolved() {
        return idInvolved;
    }

    public void setIdInvolved(int idInterview) {
        this.idInvolved = idInterview;
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
                "idInterview=" + idInvolved +
                ", idNews=" + idNews +
                ", quality='" + quality + '\'' +
                '}';
    }
}
