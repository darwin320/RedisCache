package com.uptc.frm.rediscache.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "NOTICIAS")
public class New {

    @Id
    @Column(name = "ID_NOTICIA")
    private long idNoticas;

    @Column(name = "FECHA")
    private String date;

    @Column(name = "TITULAR")
    private String headline;

    @Column(name = "TEXTO")
    private String text;

    @OneToMany(mappedBy = "_new")
    private List<InvolvedNews> involvedNews;

    @ManyToMany
    @JoinTable(name = "NOTICIAS_RELACIONADAS",
                joinColumns = @JoinColumn(name = "ID_NOTICIA"),
                inverseJoinColumns = @JoinColumn(name = "ID_NOTICIA_RELACIONADA")
    )
    private List<New> newsRelated;

    @ManyToMany(mappedBy = "newsRelated")
    private List<New> relatedNews;

    @OneToMany(mappedBy = "aNew")
    private List<AgencyNew> agencyNews;

    @OneToMany(mappedBy = "aNew")
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
}
