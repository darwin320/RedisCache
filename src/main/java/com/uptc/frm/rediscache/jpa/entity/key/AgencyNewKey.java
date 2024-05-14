package com.uptc.frm.rediscache.jpa.entity.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AgencyNewKey implements Serializable{

    private long idAgencia;
    private long idNoticia;

    public AgencyNewKey() {
    }

    public long getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(long idAgencia) {
        this.idAgencia = idAgencia;
    }

    public long getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(long idNoticia) {
        this.idNoticia = idNoticia;
    }
}
