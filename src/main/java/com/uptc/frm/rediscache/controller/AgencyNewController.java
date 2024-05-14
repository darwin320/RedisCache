package com.uptc.frm.rediscache.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.uptc.frm.rediscache.jpa.entity.AgencyNew;
import com.uptc.frm.rediscache.jpa.entity.key.AgencyNewKey;
import com.uptc.frm.rediscache.service.AgencyNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency-new")
public class AgencyNewController {

    @Autowired
    private AgencyNewService agencyNewService;

    @GetMapping
    public List<AgencyNew> getAll() {
        return agencyNewService.findAll();
    }

    @PostMapping
    public void create(@RequestBody AgencyNew agencyNew) {
        System.out.println(agencyNew);

        agencyNewService.create(agencyNew);
    }

    @GetMapping("/{idAgency}/{idNew}")
    public AgencyNew getById(@PathVariable long idAgency, @PathVariable long idNew) {
        AgencyNewKey agencyNewKey = new AgencyNewKey();
        agencyNewKey.setAgencyId(idAgency);
        agencyNewKey.setNewId(idNew);
        return agencyNewService.findById(agencyNewKey);
    }

    @PutMapping("/{idAgency}/{idNew}")
    public AgencyNew update(@PathVariable long idAgency, @PathVariable long idNew, @RequestBody AgencyNew agencyNew) {
        AgencyNewKey agencyNewKey1 = new AgencyNewKey();
        agencyNewKey1.setAgencyId(idAgency);
        agencyNewKey1.setNewId(idNew);
        return agencyNewService.update(agencyNewKey1, agencyNew);
    }

    @DeleteMapping("/{idAgency}/{idNew}")
    public void deleteById(@PathVariable long idAgency, @PathVariable long idNew) {
        AgencyNewKey agencyNewKey = new AgencyNewKey();
        agencyNewKey.setAgencyId(idAgency);
        agencyNewKey.setNewId(idNew);
        agencyNewService.deleteById(agencyNewKey);
    }
}
