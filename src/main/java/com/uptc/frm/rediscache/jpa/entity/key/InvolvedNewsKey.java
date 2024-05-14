package com.uptc.frm.rediscache.jpa.entity.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InvolvedNewsKey implements Serializable {

    private int idInvolved;
    private int idNews;

    public InvolvedNewsKey() {
    }

    public int getIdInvolved() {
        return idInvolved;
    }

    public void setIdInvolved(int idInvolved) {
        this.idInvolved = idInvolved;
    }

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }
}
