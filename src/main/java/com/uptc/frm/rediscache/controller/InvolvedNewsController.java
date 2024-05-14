package com.uptc.frm.rediscache.controller;


import com.uptc.frm.rediscache.jpa.entity.InvolvedNews;
import com.uptc.frm.rediscache.jpa.entity.key.InvolvedNewsKey;
import com.uptc.frm.rediscache.service.InvolvedNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/involvedNews")
public class InvolvedNewsController {

    @Autowired
    private InvolvedNewsService involvedNewsService;

    @GetMapping
    @Cacheable(value = "involvedNews")
    public List<InvolvedNews> getInvolvedNews() {
        return involvedNewsService.findAll();
    }

    @GetMapping("/{idInterview}/{idNews}")
    @Cacheable(value = "involvedNews", key = "#idInterview + '-' + #idNews")
    public InvolvedNews getInvolvedNewsById(@PathVariable int idInterview, @PathVariable int idNews) {
        InvolvedNewsKey involvedNewsKey = new InvolvedNewsKey();
        involvedNewsKey.setIdInvolved(idInterview);
        involvedNewsKey.setIdNews(idNews);
        return involvedNewsService.findOne(involvedNewsKey);
    }

    @PostMapping
    public InvolvedNews saveInvolvedNews(@RequestBody InvolvedNews involvedNews) {
        return involvedNewsService.saveInvolvednews(involvedNews);
    }

    @PutMapping("/{idInterview}/{idNews}")
    public InvolvedNews updateInvolvedNews(@PathVariable int idInterview, @PathVariable int idNews, @RequestBody InvolvedNews news) {
        InvolvedNewsKey involvedNewsKey = new InvolvedNewsKey();
        involvedNewsKey.setIdInvolved(idInterview);
        involvedNewsKey.setIdNews(idNews);
        return involvedNewsService.updateInvolvednews(involvedNewsKey, news);
    }

    @DeleteMapping("/{idInterview}/{idNews}")
    public void deleteInvolvedNews(@PathVariable int idInterview, @PathVariable int idNews) {
        InvolvedNewsKey involvedNewsKey = new InvolvedNewsKey();
        involvedNewsKey.setIdInvolved(idInterview);
        involvedNewsKey.setIdNews(idNews);
        involvedNewsService.deleteInvolvednews(involvedNewsKey);
    }
}
