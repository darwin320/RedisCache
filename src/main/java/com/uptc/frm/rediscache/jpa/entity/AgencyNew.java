package com.uptc.frm.rediscache.jpa.entity;

import com.uptc.frm.rediscache.jpa.entity.key.AgencyNewKey;
import jakarta.persistence.*;

@Entity
@Table(name = "AGENCIA_NOTICIAS")
@IdClass(AgencyNewKey.class)
public class AgencyNew {

    @Id
    @Column(name = "ID_AGENCIA")
    private long agencyId;

    @Id
    @Column(name = "ID_NOTICIA")
    private long newId;

    @Column(name = "FECHA_CUBRIMIENTO")
    private String coverageDate;

    public AgencyNew() {
    }

    public long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(long agencyId) {
        this.agencyId = agencyId;
    }

    public long getNewId() {
        return newId;
    }

    public void setNewId(long newId) {
        this.newId = newId;
    }

    public String getCoverageDate() {
        return coverageDate;
    }

    public void setCoverageDate(String coverageDate) {
        this.coverageDate = coverageDate;
    }
}
