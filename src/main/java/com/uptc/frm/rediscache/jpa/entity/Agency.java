package com.uptc.frm.rediscache.jpa.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "AGENCIAS")
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "AgencyGen")
    @SequenceGenerator(name = "AgencyGen",sequenceName = "AGENCIAS_SEQ",allocationSize=1)
    @Column(name = "ID_AGENCIA")
    private int id;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "ANIO_CREACION")
    private String yearRelease;


    public Agency() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(String yearRelease) {
        this.yearRelease = yearRelease;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearRelease='" + yearRelease + '\'' +
                '}';
    }
}
