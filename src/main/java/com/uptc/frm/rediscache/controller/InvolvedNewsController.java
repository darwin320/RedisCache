package com.uptc.frm.rediscache.controller;


import com.uptc.frm.rediscache.jpa.entity.InvolvedNews;
import com.uptc.frm.rediscache.service.InvolvedNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/involvedNews")
public class InvolvedNewsController {

    @Autowired
    private InvolvedNewsService involvedNewsService;

    @GetMapping
    public List<InvolvedNews> getInvolvedNews() {
        return involvedNewsService.findAll();
    }

    @GetMapping("/{idInvolved}")
    public InvolvedNews getInvolvedNewsById(@PathVariable int idInvolved) {
        return involvedNewsService.findOne(idInvolved);
    }

    @PostMapping
    public InvolvedNews saveInvolvedNews(@RequestBody InvolvedNews involvedNews) {
        return involvedNewsService.saveInvolvednews(involvedNews);
    }

    @PutMapping("/{idInvolved}")
    public InvolvedNews updateInvolvedNews(@PathVariable int idInvolved, @RequestBody InvolvedNews news) {
        return involvedNewsService.updateInvolvednews(idInvolved, news);
    }

    @DeleteMapping("/{idInvolved}")
    public void deleteInvolvedNews(@PathVariable int idInvolved) {
        involvedNewsService.deleteInvolvednews(idInvolved);
    }
}
