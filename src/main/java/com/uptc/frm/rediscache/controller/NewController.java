package com.uptc.frm.rediscache.controller;

import com.uptc.frm.rediscache.jpa.entity.New;
import com.uptc.frm.rediscache.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/new")
@CacheConfig(cacheNames = "new")
public class NewController {

    @Autowired
    private NewService newService;

    @GetMapping
    @Cacheable
    public List<New> getAll() {
        return newService.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "new")
    public New getById(@PathVariable Long id) {
        return newService.findById(id);
    }

    @PostMapping
    @Cacheable
    public void create(@RequestBody New newEntity) {
        System.out.println(newEntity);
        newService.create(newEntity);
    }

    @PutMapping("/{id}")
    @Cacheable
    public New update(@PathVariable Long id, @RequestBody New newEntity) {
        return newService.update(id, newEntity);
    }

    @DeleteMapping("/{id}")
    @Cacheable
    public void deleteById(@PathVariable Long id) {
        newService.deleteById(id);
    }
}
