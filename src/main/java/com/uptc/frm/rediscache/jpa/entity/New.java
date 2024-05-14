package com.uptc.frm.rediscache.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "NOTICIAS")
public class New implements Serializable {

    @Id
    @Column(name = "ID_NOTICIA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "newGen")
    @SequenceGenerator(name = "newGen",sequenceName = "NOTICIAS_SEQ", allocationSize = 1)
    private long idNoticas;

    @Column(name = "FECHA")
    private Date date;

    @Column(name = "TITULAR")
    private String headline;

    @Column(name = "TEXTO")
    private String text;

    @OneToMany(mappedBy = "_new")
    @JsonIgnore
    private List<InvolvedNews> involvedNews;

    @ManyToMany
    @JoinTable(name = "NOTICIAS_RELACIONADAS",
                joinColumns = @JoinColumn(name = "ID_NOTICIA"),
                inverseJoinColumns = @JoinColumn(name = "ID_NOTICIA_RELACIONADA")
    )
    @JsonIgnore
    private List<New> newsRelated;

    @ManyToMany(mappedBy = "newsRelated")
    @JsonIgnore
    private List<New> relatedNews;

    @OneToMany(mappedBy = "aNew")
    @JsonIgnore
    private List<AgencyNew> agencyNews;

    @OneToMany(mappedBy = "aNew")
    @JsonIgnore
    private List<Interview> interviews;

    public New() {
    }

    public List<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<Interview> interviews) {
        this.interviews = interviews;
    }

    public List<AgencyNew> getAgencyNews() {
        return agencyNews;
    }

    public void setAgencyNews(List<AgencyNew> agencyNews) {
        this.agencyNews = agencyNews;
    }


    public List<InvolvedNews> getInvolvedNews() {
        return involvedNews;
    }

    public void setInvolvedNews(List<InvolvedNews> involvedNews) {
        this.involvedNews = involvedNews;
    }

    public List<New> getNewsRelated() {
        return newsRelated;
    }

    public void setNewsRelated(List<New> newsRelated) {
        this.newsRelated = newsRelated;
    }

    public List<New> getRelatedNews() {
        return relatedNews;
    }

    public void setRelatedNews(List<New> relatedNews) {
        this.relatedNews = relatedNews;
    }

    public long getIdNoticas() {
        return idNoticas;
    }

    public void setIdNoticas(long idNoticas) {
        this.idNoticas = idNoticas;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "New{" +
                "idNoticas=" + idNoticas +
                ", date=" + date +
                ", headline='" + headline + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
