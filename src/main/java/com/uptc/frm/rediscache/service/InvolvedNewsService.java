package com.uptc.frm.rediscache.service;


import com.uptc.frm.rediscache.jpa.entity.InvolvedNews;
import com.uptc.frm.rediscache.jpa.entity.New;
import com.uptc.frm.rediscache.jpa.entity.Person;
import com.uptc.frm.rediscache.jpa.entity.key.InvolvedNewsKey;
import com.uptc.frm.rediscache.jpa.repository.InvolvedNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvolvedNewsService {

    @Autowired
    private InvolvedNewsRepository involvedNewsRepository;

    @Autowired
    AgencyService agencyService;

    @Autowired
    NewService newService;

    @Autowired
    PersonService personService;

    public List<InvolvedNews> findAll() {
        return involvedNewsRepository.findAll();
    }

    public InvolvedNews findOne(InvolvedNewsKey id) {
        return involvedNewsRepository.findById(id).orElse(null);
    }

    public InvolvedNews saveInvolvednews(InvolvedNews involvedNews) {
        New news = newService.findById((long) involvedNews.getIdNews());
        Person involved = personService.findById(involvedNews.getIdInterview());

        involvedNews.set_new(news);
        involvedNews.setInvolvedPerson(involved);
        return involvedNewsRepository.save(involvedNews);
    }

    public InvolvedNews updateInvolvednews(InvolvedNewsKey id, InvolvedNews involvedNews) {
        InvolvedNews involvedNewsBd = findOne(id);
        if (involvedNewsBd != null) {
            involvedNewsBd.setIdNews(involvedNews.getIdNews());
            involvedNewsBd.setQuality(involvedNewsBd.getQuality());
            return saveInvolvednews(involvedNewsBd);
        }
        throw new RuntimeException("Noticias de Implicados no encontradas");
    }

    public void deleteInvolvednews(InvolvedNewsKey id) {
        involvedNewsRepository.deleteById(id);
    }
}
