package com.uptc.frm.rediscache.jpa.entity.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AgencyNewKey implements Serializable{

    private long agencyId;
    private long newId;

    public AgencyNewKey() {
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
}
