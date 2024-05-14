package com.uptc.frm.rediscache.jpa.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "ENTREVISTAS")
public class Interview {

    @Id
    @Column(name = "ID_ENTREVISTA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interviewGen")
    @SequenceGenerator(name = "interviewGen", sequenceName = "ENTREVISTAS_SEQ", allocationSize = 1)
    private int idInterview;

    @Column(name = "ID_PERIODISTA",insertable = false, updatable = false)
    private int idJournalist;

    @Column(name = "ID_IMPLICADO",insertable = false, updatable = false)
    private int idInvolved;

    @Column(name = "ID_NOTICIA",insertable = false, updatable = false)
    private int idNews;

    @Column(name = "PREGUNTA")
    private String question;

    @ManyToOne
    @JoinColumn(name = "ID_PERIODISTA")
    private Person journalist;

    @ManyToOne
    @JoinColumn(name = "ID_IMPLICADO")
    private Person involvedPerson;

    @ManyToOne
    @JoinColumn(name = "ID_NOTICIA")
    private New aNew;

    public Interview() {
    }

    public Person getJournalist() {
        return journalist;
    }

    public void setJournalist(Person journalist) {
        this.journalist = journalist;
    }

    public Person getInvolvedPerson() {
        return involvedPerson;
    }

    public void setInvolvedPerson(Person involvedPerson) {
        this.involvedPerson = involvedPerson;
    }

    public New getaNew() {
        return aNew;
    }

    public void setaNew(New aNew) {
        this.aNew = aNew;
    }

    public int getIdInterview() {
        return idInterview;
    }

    public void setIdInterview(int idInterview) {
        this.idInterview = idInterview;
    }

    public int getIdJournalist() {
        return idJournalist;
    }

    public void setIdJournalist(int idJournalist) {
        this.idJournalist = idJournalist;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "idInterview=" + idInterview +
                ", idJournalist=" + idJournalist +
                ", idInvolved=" + idInvolved +
                ", idNews=" + idNews +
                ", question='" + question + '\'' +
                '}';
    }
}
