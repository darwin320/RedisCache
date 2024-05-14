package com.uptc.frm.rediscache.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne
    @JoinColumn(name = "ID_NOTICIA")
    @JsonIgnore
    private New aNew;

    @ManyToOne
    @JoinColumn(name = "ID_AGENCIA")
    @JsonIgnore
    private Agency agency;

    public AgencyNew() {
    }

    public New getaNew() {
        return aNew;
    }

    public void setaNew(New aNew) {
        this.aNew = aNew;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
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
