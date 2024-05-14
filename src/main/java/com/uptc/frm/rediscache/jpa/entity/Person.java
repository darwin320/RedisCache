package com.uptc.frm.rediscache.jpa.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PERSONAS")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PersonGen")
    @SequenceGenerator(name = "PersonGen",sequenceName = "PERSON_SEQ",allocationSize=1)
    @Column(name = "ID_PERSONA")
    private int id;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "FECHA_NACIMIENTO")
    private Date date;

    @Column(name = "DIRECCION")
    private String address;

    @Column(name = "TELEFONO")
    private String phoneNumber;

    @OneToMany(mappedBy = "involvedPerson")
    private List<InvolvedNews> involvedPersons;

    @OneToMany(mappedBy = "journalist")
    private List<Interview> journalists;



    public Person() {
    }



    public List<InvolvedNews> getInvolvedPersons() {
        return involvedPersons;
    }

    public void setInvolvedPersons(List<InvolvedNews> involvedPersons) {
        this.involvedPersons = involvedPersons;
    }

    public List<Interview> getJournalists() {
        return journalists;
    }

    public void setJournalists(List<Interview> journalists) {
        this.journalists = journalists;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
