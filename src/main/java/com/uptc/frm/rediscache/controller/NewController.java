package com.uptc.frm.rediscache.controller;

import com.uptc.frm.rediscache.jpa.entity.New;
import com.uptc.frm.rediscache.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/new")
public class NewController {

    @Autowired
    private NewService newService;

    @GetMapping
    public List<New> getAll() {
        return newService.findAll();
    }

    @GetMapping("/{id}")
    public New getById(@PathVariable Long id) {
        return newService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody New newEntity) {
        System.out.println(newEntity);
        newService.create(newEntity);
    }

    @PutMapping("/{id}")
    public New update(@PathVariable Long id, @RequestBody New newEntity) {
        return newService.update(id, newEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        newService.deleteById(id);
    }
}
