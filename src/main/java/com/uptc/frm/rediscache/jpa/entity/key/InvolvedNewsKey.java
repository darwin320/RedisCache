package com.uptc.frm.rediscache.jpa.entity.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class InvolvedNewsKey implements Serializable {

    private int idInterview;
    private int idNews;

    public InvolvedNewsKey() {
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
}
