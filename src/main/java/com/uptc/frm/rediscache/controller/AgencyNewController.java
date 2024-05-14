package com.uptc.frm.rediscache.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.uptc.frm.rediscache.jpa.entity.AgencyNew;
import com.uptc.frm.rediscache.jpa.entity.key.AgencyNewKey;
import com.uptc.frm.rediscache.service.AgencyNewService;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency-new")
@CacheConfig(cacheNames = "agency-new")
public class AgencyNewController {

    @Autowired
    private AgencyNewService agencyNewService;

    @GetMapping
    @Cacheable
    public List<AgencyNew> getAll() {
        return agencyNewService.findAll();
    }

    @PostMapping
    @Cacheable
    public void create(@RequestBody AgencyNew agencyNew) {
        System.out.println(agencyNew);

        agencyNewService.create(agencyNew);
    }

    @GetMapping("/{idAgency}/{idNew}")
    @Cacheable(key = "#idAgency", value = "agency-new")
    public AgencyNew getById(@PathVariable long idAgency, @PathVariable long idNew) {
        AgencyNewKey agencyNewKey = new AgencyNewKey();
        agencyNewKey.setAgencyId(idAgency);
        agencyNewKey.setNewId(idNew);
        return agencyNewService.findById(agencyNewKey);
    }

    @PutMapping("/{idAgency}/{idNew}")
    @Cacheable
    public AgencyNew update(@PathVariable long idAgency, @PathVariable long idNew, @RequestBody AgencyNew agencyNew) {
        AgencyNewKey agencyNewKey1 = new AgencyNewKey();
        agencyNewKey1.setAgencyId(idAgency);
        agencyNewKey1.setNewId(idNew);
        return agencyNewService.update(agencyNewKey1, agencyNew);
    }

    @DeleteMapping("/{idAgency}/{idNew}")
    @Cacheable
    public void deleteById(@PathVariable long idAgency, @PathVariable long idNew) {
        AgencyNewKey agencyNewKey = new AgencyNewKey();
        agencyNewKey.setAgencyId(idAgency);
        agencyNewKey.setNewId(idNew);
        agencyNewService.deleteById(agencyNewKey);
    }
}
