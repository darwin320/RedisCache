package com.uptc.frm.rediscache.service;


import com.uptc.frm.rediscache.jpa.entity.InvolvedNews;
import com.uptc.frm.rediscache.jpa.repository.InvolvedNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvolvedNewsService {

    @Autowired
    private InvolvedNewsRepository involvedNewsRepository;


    public List<InvolvedNews> findAll() {
        return involvedNewsRepository.findAll();
    }

    public InvolvedNews findOne(Integer id) {
        return involvedNewsRepository.findById(id).orElse(null);
    }

    public InvolvedNews saveInvolvednews(InvolvedNews involvedNews) {
        return involvedNewsRepository.save(involvedNews);
    }

    public InvolvedNews updateInvolvednews(Integer id, InvolvedNews involvedNews) {
        InvolvedNews involvedNewsBd = findOne(id);
        if (involvedNewsBd != null) {
            involvedNewsBd.setIdNews(involvedNews.getIdNews());
            involvedNewsBd.setQuality(involvedNewsBd.getQuality());
            return saveInvolvednews(involvedNewsBd);
        }
        throw new RuntimeException("Noticias de Implicados no encontradas");
    }

    public void deleteInvolvednews(Integer id) {
        involvedNewsRepository.deleteById(id);
    }
}
