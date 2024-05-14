package com.uptc.frm.rediscache.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Noticias")
public class New {

    @Id
    @Column(name = "ID_NOTICIA")
    private long idNoticas;

    @Column(name = "FECHA")
    private String date;

    @Column(name = "TITULAR")
    private String headline;

    @Column(name = "TEXTO")
    private String text;

    public New() {
    }

    public long getIdNoticas() {
        return idNoticas;
    }

    public void setIdNoticas(long idNoticas) {
        this.idNoticas = idNoticas;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
