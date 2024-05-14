package com.uptc.frm.rediscache.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uptc.frm.rediscache.jpa.entity.key.AgencyNewKey;
import jakarta.persistence.*;

import java.util.Date;

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
    private Date coverageDate;

    @ManyToOne
    @JoinColumn(name = "ID_NOTICIA", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private New aNew;

    @ManyToOne
    @JoinColumn(name = "ID_AGENCIA", nullable = false, insertable = false, updatable = false)
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

    public Date getCoverageDate() {
        return coverageDate;
    }

    public void setCoverageDate(Date coverageDate) {
        this.coverageDate = coverageDate;
    }

    @Override
    public String toString() {
        return "AgencyNew{" +
                "coverageDate='" + coverageDate + '\'' +
                ", newId=" + newId +
                ", agencyId=" + agencyId +
                '}';
    }
}
